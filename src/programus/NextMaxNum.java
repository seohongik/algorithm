package programus;

import java.util.Arrays;

public class NextMaxNum {

    public int  solution2(int n) {
        // 원래 숫자 n의 2진수 1의 개수 구하기
        int targetCount = Integer.bitCount(n);

        // n을 1씩 증가시키면서 1의 개수가 같은 첫 번째 수를 찾음
        int next = n + 1;
        while (Integer.bitCount(next) != targetCount) {
            next++;
        }

        return next;
    }


    public int solution(int n) {
        int answer = 0;

        String originalBinaryNumber = Integer.toString(n,2);

        int oriCount = Integer.bitCount(n);

        answer=recur(n,oriCount,originalBinaryNumber,answer);

        return answer;
    }

    private int recur(int n, int oriCount,String original,int answer){

        String findBinaryNumber = Integer.toString(n,2);

        int count = Integer.bitCount(n);

        if(oriCount == count && !findBinaryNumber.equals(original)){
            answer = Integer.parseInt(findBinaryNumber,2);
            return answer;
        }
        return recur(n+1,oriCount,original,answer);
    }



    public static void main(String[] args) {
        NextMaxNum nextMaxNum = new NextMaxNum();
        nextMaxNum.solution(78);
        nextMaxNum.solution(15);
    }
}
