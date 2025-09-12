package programus;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

/*
0 번째 유사 칸토어 비트열은 "1" 입니다.
n(1 ≤ n) 번째 유사 칸토어 비트열은 n - 1 번째 유사 칸토어 비트열에서의 1을 11011로 치환하고 0을 00000로 치환하여 만듭니다.
* */
//1을 11011로 치환하고 0을 00000로 치환
//1101111011000001101111011
//11011

public class KantoBit {

    public int solution(int n, long l, long r) {
        int answer =0;
        for (long i =l-1 ; i <r ; i++) {
            answer+=self(i);
        }
        return answer;
    }

    private int  self(long n) {

        System.out.println(n);
        if (n%5==2) return 0;
        if (n<=4) return 1;
        return self(n/5);
    }

    public static void main(String[] args) {
        KantoBit k = new KantoBit();
        int ans=k.solution(2,4,17);
        //int ans=k.solution2(3,3,17);
        System.out.println(ans);
        //1, 1, 0,     1, 1,   1, 1, 0, 1, 1,    0, 0, 0, 0, 0,     1, 1 ,      0, 1, 1,    1, 1, 0, 1, 1
    }
}
