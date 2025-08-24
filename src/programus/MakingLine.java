package programus;

import java.util.*;

public class MakingLine {

    // 정답
    public int[] solution(int n, long k) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        int[] answer = new int[n];
        long factorial = 1;

        // n! 계산
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        k--; // 0-based index 로 맞추기

        for (int i = 0; i < n; i++) {
            factorial /= (n - i); // (n-i)! 로 나눔
            int index = (int) (k / factorial); // 몇 번째 수 선택할지 결정
            answer[i] = numbers.remove(index);
            k %= factorial;
        }

        return answer;
    }

    public static void main(String[] args) {
        MakingLine m = new MakingLine();
        int[] answer = m.solution(3, 5); // 0 4
        System.out.println(Arrays.toString(answer));
    }

}
