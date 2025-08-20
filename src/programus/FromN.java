package programus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FromN {
    public int[] solution(int[] num_list, int n) {

        //List<Integer> list = new ArrayList<>();
        int count = 0;
        int[] answer = new int[num_list.length-n+1];
        for (int i = n-1; i < num_list.length; i++) {
            //list.add(num_list[i]);
            answer[count++]=num_list[i];
        }

        //return list.stream().mapToInt(i -> i).toArray();
        return answer;
    }

    public static void main(String[] args) {
        FromN solution = new FromN();
        System.out.println(Arrays.toString(solution.solution(new int[]{5,2,1,7,5}, 2)));
    }
}
