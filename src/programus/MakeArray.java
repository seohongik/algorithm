package programus;

import java.util.Arrays;


public class MakeArray {

    public int[] solution(int n, int k) {
        int[] answer= new int[n/k];
        int j = 0 ;
        for (int i = k; i <= n; i+=k) {
            answer[j] = i;
            j++;
        }
        return answer;
    }

    public static void main(String[] args) {
        MakeArray m = new MakeArray();
        int[] answer = m.solution(10, 3);
        System.out.println(Arrays.toString(answer));
    }

}
