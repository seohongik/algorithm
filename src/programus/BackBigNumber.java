package programus;

import java.util.*;

public class BackBigNumber {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        BackBigNumber b = new BackBigNumber();
        int[] answer = {2, 3, 3, 5};
        System.out.println(Arrays.toString(b.solution(answer))); //3, 5, 5, -1
        int[] answer2 = {9, 1, 5, 3, 6, 2};
        System.out.println(Arrays.toString(b.solution(answer2))); //-1, 5, 6, 6, -1, -1
    }
}
