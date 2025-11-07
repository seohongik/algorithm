package programus;

import java.util.Arrays;

public class EvenOddCount {

    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        answer[0]=(int)Arrays.stream(num_list).filter(x -> x % 2 == 0).count();
        answer[1]=(int)Arrays.stream(num_list).filter(x -> x % 2 != 0).count();

        return answer;
    }

    public static void main(String[] args) {
        EvenOddCount e = new EvenOddCount();
        int[] num_list = { 1, 2, 3, 4, 5};
        e.solution(num_list);
    }
}
