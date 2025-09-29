package programus;

import java.util.*;

public class BestAlbum {

    /*
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    * */

    public int[] solution(String[] genres, int[] plays) {
        Set<Integer> bestAlbum = new LinkedHashSet<>();
        List<Integer> uniqueIndexs = new ArrayList<>(); // 고유번호 list
        Map<String, List<Integer> > groupPlayTimesByGenre = new HashMap<>(); //장르 내에서 많이 재생된 노래 먼저 수록하기 위한 맵
        Map<Integer, String> summingPlayTimesPartitionByGerne = new TreeMap<>(Collections.reverseOrder()); //장르별 가장 많이 재생된 노래 수록하기 위한 map 

        for (int i = 0; i < genres.length; i++) { // 장르와 playTime의 길이가 같으니 장르별 플레이 타임 장르 먼저 수록하기 위해 도는 포문
            List<Integer> playTimes = new ArrayList<>();

            for (int j=0; j<genres.length; j++) {
                if(genres[i].equals(genres[j])) {
                    playTimes.add(plays[j]);
                }
            }
            groupPlayTimesByGenre.put(genres[i],playTimes); //장르별 플레이타임
            uniqueIndexs.add(plays[i]); // 고유 번호 (이름 변경 index-> unique index) -> 결국이게 베스트엘범이 됨
        }

        for (Map.Entry<String, List<Integer>> grouping : groupPlayTimesByGenre.entrySet()) { // 장르별 플레이타입 속한노래가 많이 재생된 장르 구하기
            int playTimeSum =grouping.getValue().stream().mapToInt(i-> i).sum();
            summingPlayTimesPartitionByGerne.put(playTimeSum,grouping.getKey()); // 장르별 가장많이 재생된 노래 수록하기 위한 map 
        }

        summingPlayTimesPartitionByGerne.values().forEach(genre -> { 
            Collections.sort(groupPlayTimesByGenre.get(genre), new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) { // 고유번호 낮은 순으로 구하기 위해 역정렬
                    return o2.compareTo(o1);
                }
            });
        });
        
        summingPlayTimesPartitionByGerne.values().forEach(genre -> {

            int puttingSongInBestAlbumCount = groupPlayTimesByGenre.get(genre).size()==1?1:2; //장르 내에서 플레이 타임이 같으면 사이즈가 1이고 아니면 2개까지 수록이 가능
            for (int i = 0; i < puttingSongInBestAlbumCount; i++) {

                for (int j = 0 ; j<uniqueIndexs.size(); j++) { 
                    int maxPlayTimeSong = groupPlayTimesByGenre.get(genre).get(i);

                    if(uniqueIndexs.get(j)==maxPlayTimeSong){ //장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
                        bestAlbum.add(j);
                    }
                }
            }
        });
        return bestAlbum.stream().mapToInt(i->i).toArray(); // 베스트 엘범
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
