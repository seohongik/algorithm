package easyspub.exemChapter;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AvgSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getMyAvg(sc);
        getAnswerAvg(sc);
    }

    public static void getMyAvg(Scanner sc) {
        int N=sc.nextInt();
        double[] scores = new double[N];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextDouble();
        }
        double sum = 0;
        double max = scores[0];
        for (int i = 0; i < scores.length; i++) {
            max= Math.max(max, scores[i]);
        }

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i]/max*100;
        }

        double avg = sum/N;
        System.out.println(avg);
    }

    public static void getAnswerAvg(Scanner sc) {
        int N=sc.nextInt();
        int[] scores = new int[N];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] > max) {
                max = scores[i];
            }
            sum += scores[i];
        }
        // 한 과목과 관련된 수식을 총합과 관련된 수식으로 변환해야 로직이 간단해짐
        System.out.println(sum*100/max/N);
    }
}
