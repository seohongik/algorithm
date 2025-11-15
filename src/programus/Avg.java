package programus;

import java.util.Arrays;

public class Avg {
    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() /arr.length;
    }

    public static void main(String[] args) {
        Avg a = new Avg();
        System.out.println(a.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
