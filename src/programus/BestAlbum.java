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
        List<Integer> uniqueIndex = new ArrayList<>();
        Map<String, List<Integer> > groupPlayTimesByGenre = new HashMap<>();
        Map<Integer, String> summingPlayTimesPartitionByGerne = new TreeMap<>(Collections.reverseOrder()); // 장르 내에서 많이 재생된 노래 먼저 수록

        for (int i = 0; i < genres.length; i++) { // 장르와 playTime의 길이가 같으니 장르별 플레이 타임(속한노래가 많이 재생된) 장르 먼저 수록하기 위해 도는 포문
            List<Integer> playTimes = new ArrayList<>();

            for (int j=0; j<genres.length; j++) {
                if(genres[i].equals(genres[j])) {
                    playTimes.add(plays[j]);
                }
            }
            groupPlayTimesByGenre.put(genres[i],playTimes);
            uniqueIndex.add(plays[i]); // 고유 번호 (이름 변경 index-> unique index)
        }

        for (Map.Entry<String, List<Integer>> grouping : groupPlayTimesByGenre.entrySet()) { // 장르별 플레이타입 속한노래가 많이 재생된 장르 구하기
            int sum =grouping.getValue().stream().mapToInt(i-> i).sum();
            summingPlayTimesPartitionByGerne.put(sum,grouping.getKey()); // 핵심
        }


        summingPlayTimesPartitionByGerne.values().forEach(genre -> { // 장르 내에서 많이 재생된 노래먼저 수록(한번더) 사실 이 매서드 없어도 된
            Collections.sort(groupPlayTimesByGenre.get(genre), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
        });

        summingPlayTimesPartitionByGerne.values().forEach(genre -> { // 고유번호 낮은순

            int puttingSongInBestAlbumCount = groupPlayTimesByGenre.get(genre).size()==1?1:2;
            for (int i = 0; i < puttingSongInBestAlbumCount; i++) {

                for (int j = 0 ; j<uniqueIndex.size(); j++) {
                    int maxPlayTimeSong = groupPlayTimesByGenre.get(genre).get(i);

                    if(uniqueIndex.get(j)==maxPlayTimeSong){
                        bestAlbum.add(j);
                    }
                }
            }
        });
        return bestAlbum.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {

        //https://school.programmers.co.kr/learn/courses/30/lessons/42579
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
