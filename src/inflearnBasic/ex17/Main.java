package inflearnBasic.ex17;
import java.util.Scanner;


class Solution{

    public int solution(int n) {

        int primeNumberCount = 0;

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeNumberCount++;
            }
        }
        return primeNumberCount;
    }

    public boolean isPrime(int i) {
        if (i <= 1) return false;
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (j % i == 0) return false;
        }
        return true;
    }
}

class Solution2 {

    // 에라토스테네스체
    public int solution(int n) {

        int[] primes = new int[n + 1];

        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if(primes[i]==0) {
                ans++;
                for (int j = i; j <= n; j=j+i) {
                    primes[j] = 1;
                }
            }
        }
        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution2 sol = new Solution2();
        int result=sol.solution(sc.nextInt());
        System.out.println(result);
    }
}