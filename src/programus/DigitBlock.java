package programus;

import java.util.*;

public class DigitBlock {
    public int[] solution(long begin, long end) {
        int size = (int)(end - begin + 1);
        int[] block = new int[size];

        for (long i = begin; i <= end; i++) {
            block[(int)(i - begin)] = getBlockValue(i);
        }

        return block;
    }

    public int getBlockValue(long n) {
        if (n == 1) return 0;

        int result = 1;
        for (long d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                long div = n / d;
                if (div <= 10_000_000) {
                    return (int) div;
                }
                if (d <= 10_000_000) {
                    result = (int) d;
                }
            }
        }
        return result;
    }

    /*
    // 시간초과
    public void measure(long n, List<Integer> digits) {
        long max=0;
        long temp = n;
        for (long i = 1; i<temp; i++) {
            if(temp % i == 0) {
                max=Math.max(temp/i, 0);
            }
        }
        if(max==0) {
            digits.add(0);
        }else {
            digits.add((int) (temp/max));
        }
    }*/


    public static void main(String[] args) {
        DigitBlock digitBlock = new DigitBlock();
        System.out.println(Arrays.toString(digitBlock.solution(1L, 10L)));
        //1	10	[0, 1, 1, 2, 1, 3, 1, 4, 3, 5]
    }
}
