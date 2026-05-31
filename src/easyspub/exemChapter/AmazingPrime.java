package easyspub.exemChapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AmazingPrime {


    private static int N;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

    }

    static void dfs(int number, int jarisu) {
        if(N==jarisu) {
            if(isPrime(number)){
                System.out.println("number = " + number);
            }
            return;
        }
        for(int i=1;i<10;i++) {
            if(i%2==0){ // 짝수면 건너뛰고
                continue;
            }
            if(isPrime(number*10+i)){
                dfs(number*10+i,jarisu+1);
            }
        }
    }

    // 하나의 숫자가 소수인지 판별하는 초고속 최적화 함수
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        // 제곱근까지만 나누어 떨어지는지 검사 (O(√N) 속도)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
