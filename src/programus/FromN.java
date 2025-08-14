package programus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FromN {
    public int[] solution(int[] num_list, int n) {
        int count = 0;
        int index = 0;

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] == n) {
                index = i;
                break;
            }
            count++;
        }

        int[] answer = new int[num_list.length - count];


        for (int i = 0; i < answer.length; i++) {
            answer[i] = num_list[index++];
        }

        return answer;
    }

    public int[] solution2(int[] num_list, int n) {
        int index = 0;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] == n) {
                index = i;
                break;
            }
        }


        for (int i = index; i < num_list.length; i++) {
            list.add(num_list[i]);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        FromN solution = new FromN();
        System.out.println(Arrays.toString(solution.solution(new int[]{2, 1, 6}, 6)));
    }
}
