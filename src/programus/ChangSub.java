package programus;

import java.util.Arrays;

public class ChangSub {

    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length];

        int counter = 0;
        for (int i=n; i<num_list.length; i++){ //3
            //answer[Math.abs(n-i)] = num_list[i];
            answer[i-n] = num_list[i];
            counter++;
        }

        for (int i =0; i<n; i++){
            answer[counter] = num_list[i];
            counter++;
        }

        return answer;
    }

    public static void main(String[] args) {
        ChangSub cs = new ChangSub();
        int[] answer = cs.solution(new int[]{5, 2, 1, 7, 5}, 3);
        System.out.println(Arrays.toString(answer));
        int[] answer2 = cs.solution(new int[]{2,1,6}, 1);
        System.out.println(Arrays.toString(answer2));
    }

}
