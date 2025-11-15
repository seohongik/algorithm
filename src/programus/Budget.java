package programus;

import java.util.*;

public class Budget {

    public int solution(int[] d, int budget) {
       Arrays.sort(d);
        int index = 0;

        while (index < d.length && d[index] <= budget) {
            budget -= d[index++];
        }

        return index;
    }


    public static void main(String[] args) {
        Budget budget = new Budget();
        System.out.println(budget.solution(new int[] { 1, 3, 2, 5, 4 }, 9));
        System.out.println(budget.solution(new int[] { 2, 2, 3, 3 }, 10));
    }

}
