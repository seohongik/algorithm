package programus;

import java.util.*;

public class ParallelsLine {

    public int solution(int[][] dots) {

        if (isParallel(dots[0], dots[1], dots[2], dots[3])) return 1;
        if (isParallel(dots[0], dots[2], dots[1], dots[3])) return 1;
        if (isParallel(dots[0], dots[3], dots[1], dots[2])) return 1;

        return 0;
    }

    private boolean isParallel(int[] a1, int[] a2, int[] b1, int[] b2) {
        int dx1 = a2[0] - a1[0];
        int dy1 = a2[1] - a1[1];
        int dx2 = b2[0] - b1[0];
        int dy2 = b2[1] - b1[1];

        return dy1 * dx2 == dy2 * dx1;
    }

    public static void main(String[] args) {

        //https://school.programmers.co.kr/learn/courses/30/lessons/120875

        ParallelsLine p = new ParallelsLine();
        System.out.println(p.solution(new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}})); //1
        System.out.println(p.solution(new int[][]{{3, 5}, {4, 1}, {2, 4}, {5, 10}})); //0

    }
}
