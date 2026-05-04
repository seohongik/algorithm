package easyspub.exemChapter;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SumNumberValue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        final int N = scanner.nextInt();
        String input = scanner.next();
        for (int i = 0; i < N; i++) {
            sum += input.charAt(i)-48;
        }

        System.out.println(sum);
    }

}
