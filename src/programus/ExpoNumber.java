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
    //성공 왜냐면 1씩 증가하기 때문에 
    public int solution2(int n) {

        int answer = 0;
        int left =1;
        int right =1;
        int end = n;
        int sum=0;

        while (left<end) {

            int  count = 0;

            for (int i=left; i<=right; i++) {
                count++;
            }

            if(count%2==0) {
                sum = (left + right) * ((int)count / 2);
            }else {
                sum = (left + right) * ((int)count / 2) +((left + right) / 2);
            }

            if(sum==n) {
                answer++;
            }else if(sum>n) {
                left++;
                right=left;
            }
            right++;
        }

        if(left<=end){
            answer++;
        }
        return  answer;
    }

    // 이것도 성공 원래 내가 의도한 등차 수열 합 공식
    public int solution(int n) {
        int answer = 0;
        int left = 1;
        int right = 1;
        int end = n;
        
        while (left <= end) {
            int count = right - left + 1; // 구간 길이
            int sum = (left + right) * count / 2; // 등차수열 합 공식
    
            if (sum == n) {
                answer++;
                right++; // 계속 진행
            } else if (sum < n) {
                right++;
            } else {
                left++;
            }
        }
     return answer;
    }

    public static void main(String[] args) {
        ExpoNumber expoNumber = new ExpoNumber();
        System.out.println(expoNumber.solution2(15));
    }
}
