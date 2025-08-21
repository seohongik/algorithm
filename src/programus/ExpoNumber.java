package programus;

import java.util.*;

public class ExpoNumber {
    // 효율성에서 떨어짐
    public int solution(int n) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n; i >0; i--) {
            while (stack.stream().mapToInt(integer -> integer).sum() >n) {
                stack.removeLast();
            }
            stack.push(i);
            if(stack.stream().mapToInt(integer -> integer).sum()==n){
                answer++;
                continue;
            }

        }
        return  answer;
    }

    public int solution2(int n) {
        int answer = 0;
        int left =0;
        int right =0;
        int sum = n;

        while(left<=n) {
            if (sum < 0) {
                right++;
                left = right;
                sum=n;
            }
            if(sum==0){
                answer++;
            }
            sum -= (++left);
        }
        return  answer;
    }

    public static void main(String[] args) {
        ExpoNumber expoNumber = new ExpoNumber();
        System.out.println(expoNumber.solution2(15));
    }
}
