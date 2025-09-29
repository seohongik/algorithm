package programus;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {

    /*
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    * */

    public int[] solution(String[] genres, int[] plays) {
        Set<Integer> bestAlbum = new LinkedHashSet<>();
        List<Integer> index = new ArrayList<>();
        Map<String, List<Integer> > groupPlayTimesByGenre = new HashMap<>();
        Map<Integer, String> summingPlayTimesPartitionByGerne = new TreeMap<>(Collections.reverseOrder());

        for (int i = 0; i < genres.length; i++) {
            List<Integer> playTimes = new ArrayList<>();

            for (int j=0; j<genres.length; j++) {
                if(genres[i].equals(genres[j])) {
                    playTimes.add(plays[j]);
                }
            }
            groupPlayTimesByGenre.put(genres[i],playTimes);
            index.add(plays[i]);
        }

        for (Map.Entry<String, List<Integer>> grouping : groupPlayTimesByGenre.entrySet()) {
            int sum =grouping.getValue().stream().mapToInt(i-> i).sum();
            summingPlayTimesPartitionByGerne.put(sum,grouping.getKey());
        }


        summingPlayTimesPartitionByGerne.values().forEach(genre -> {
            Collections.sort(groupPlayTimesByGenre.get(genre), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
        });

        summingPlayTimesPartitionByGerne.values().forEach(genre -> {

            int puttingSongInBestAlbumCount = groupPlayTimesByGenre.get(genre).size()==1?1:2;
            for (int i = 0; i < puttingSongInBestAlbumCount; i++) {

                for (int j = 0 ; j<index.size(); j++) {
                    int maxPlayTimeSong = groupPlayTimesByGenre.get(genre).get(i);

                    if(index.get(j)==maxPlayTimeSong){
                        bestAlbum.add(j);
                    }
                }
            }
        });
        return bestAlbum.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {

        BestAlbum bestAlbum = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] plays = {400, 600, 150, 600, 500, 500};
        int[] answer = bestAlbum.solution(genres, plays);
        System.out.println("Arrays.toString(answer) = " + Arrays.toString(answer)); //[4,5,1,3]

        System.out.println("=== ===================");

        String[] genres2 = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays2 = {500, 600, 150, 800, 2500};
        int[] answer2 = bestAlbum.solution(genres2, plays2);
        System.out.println("Arrays.toString(answer2) = " + Arrays.toString(answer2)); //	[4, 1, 3, 0]



    }

}
