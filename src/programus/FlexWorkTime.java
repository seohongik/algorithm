package programus;

import java.time.LocalTime;

public class FlexWorkTime {

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        LocalTime[] hopeTime = new LocalTime[schedules.length];
        LocalTime[] recognizedTime = new LocalTime[schedules.length];

        for (int i = 0; i < recognizedTime.length; i++) {
            int value = schedules[i];
            int hour = value / 100;
            int minute = value % 100;

            LocalTime time = LocalTime.of(hour, minute);
            hopeTime[i] = time;
            time = time.plusMinutes(10);
            recognizedTime[i] = time;
        }

        for (int i = 0; i < timelogs.length; i++) {

            int count = 0;
            for (int j = 0; j < timelogs[i].length; j++) {
                // 요일 계산 (1~7 유지, 6=토, 7=일)
                int day = (startday + j) % 7;
                if (day == 0) day = 7;

                // 주말 제외
                if (day == 6 || day == 7) {
                    continue;
                }

                int value = timelogs[i][j];
                int hour = value / 100;
                int minute = value % 100;
                LocalTime workTime = LocalTime.of(hour, minute);

                if (!workTime.isAfter(recognizedTime[i])) {
                    count++;
                }

            }
            if(count==5){
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        FlexWorkTime ft = new FlexWorkTime();

        // 테스트 케이스 #1
        int[] schedules1 = {700, 800, 1100};
        int[][] timelogs1 = {
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        int startday1 = 5;
        System.out.println(ft.solution(schedules1, timelogs1, startday1));  // 기대 출력: 3

        // 테스트 케이스 #2
        int[] schedules2 = {730, 855, 700, 720};
        int[][] timelogs2 = {
                {710, 700, 650, 735, 700, 931, 912},
                {908, 901, 805, 815, 800, 831, 835},
                {705, 701, 702, 705, 710, 710, 711},
                {707, 731, 859, 913, 934, 931, 905}
        };
        int startday2 = 1;
        System.out.println(ft.solution(schedules2, timelogs2, startday2));  // 기대 출력: 2
    }
}
