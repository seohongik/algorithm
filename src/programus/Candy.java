package programus;


public class Candy {

    // 영희가 최종적으로 이길 확률 반환
    public static double probYongWin(int n, int chol, int yong) {
        // 철수가 먼저 n번 이기면 영희는 패배
        if (chol == n) return 0.0;
        // 영희가 먼저 n번 이기면 영희는 승리
        if (yong == n) return 1.0;

        // 다음 판은 50% 확률로 철수 승, 50% 확률로 영희 승
        return 0.5 * probYongWin(n, chol + 1, yong)
                + 0.5 * probYongWin(n, chol, yong + 1);
    }

    public static void main(String[] args) {
        int n = 5; // 5번 먼저 이기는 사람이 승리
        int chol = 4;
        int yong = 3;

        double yongWinProb = probYongWin(n, chol, yong);
        double cholWinProb = 1.0 - yongWinProb;

        int totalCandy = 60;
        int yongCandy = (int) Math.round(totalCandy * yongWinProb);
        int cholCandy = totalCandy - yongCandy;

        System.out.println("철수 승률: " + (cholWinProb * 100) + "%, 사탕 " + cholCandy);
        System.out.println("영희 승률: " + (yongWinProb * 100) + "%, 사탕 " + yongCandy);
    }
}
