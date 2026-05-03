package programus;

import java.util.*;

public class YellowLight {

    public int solution(int[][] signals) {
        long maxTime = 100_000_000L;

        for (int t = 0; t < maxTime; t++) {
            boolean allYellow = true;

            for (int[] s : signals) {
                int green = s[0];
                int yellow = s[1];
                int cycle = s[0] + s[1] + s[2];

                int currentTimeInCycle = t % cycle;

                // 노란불 구간: green 시간 이후부터 green + yellow 시간 전까지
                if (!(currentTimeInCycle >= green && currentTimeInCycle < green + yellow)) {
                    allYellow = false;
                    break;
                }
            }

            if (allYellow) return t+1;
        }

        return -1;
    }

    public static void main(String[] args) {

        YellowLight yellowLight = new YellowLight();
        System.out.println(yellowLight.solution(new int[][]{{2, 1, 2}, {5, 1, 1}}));
        System.out.println(yellowLight.solution(new int[][]{{3, 3, 3}, {5, 4, 2}, {2, 1, 2}}));

    }
}
