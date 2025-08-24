package programus;

import java.util.*;
import java.util.stream.Collectors;

public class RunnerTrack {

    // 시간 초과
    public String[] solution(String[] players, String[] callings) {

        List<String> list = Arrays.stream(players).collect(Collectors.toList());
        int count =0;
        while (count<callings.length) {
            int index = list.indexOf(callings[count]);
            Collections.swap(list, index-1, index);
            count++;
        }
        return list.toArray(new String[0]);
    }

    //map에 넣어놓고 갈아치우기
    public String[] solution2(String[] players, String[] callings) {

        Map<String, Integer> playersMap = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playersMap.put(players[i], i);
        }

        for (int i = 0; i < callings.length; i++) {

            int currentRanking = playersMap.get(callings[i]);

            String temp = players[currentRanking-1];
            players[currentRanking-1] = players[currentRanking];
            players[currentRanking] = temp;

            playersMap.replace(callings[i], currentRanking-1);
            playersMap.replace(temp, currentRanking);

        }

        List<String> keyList = new ArrayList<>(playersMap.keySet());
        Collections.sort(keyList,(o1,o2)-> playersMap.get(o1).compareTo(playersMap.get(o2)));

        return keyList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        RunnerTrack runnerTrack = new RunnerTrack();
        String[] answer = {};
        answer = runnerTrack.solution2(new String[]{"mumu", "soe", "poe", "kai", "mine"}, new String[]{"kai", "kai", "mine", "mine"});
        System.out.println(Arrays.toString(answer)); //["mumu", "kai", "mine", "soe", "poe"]
    }
}
