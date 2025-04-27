package inflearnBaisc.ex18;
import java.util.Scanner;

class Solution{

    public int solution(int n) {
        return isPrime(reverseNumberUsingReverseFormula(n));
    }

    /*
    public int reverseNumber(int number){

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(number);
        return  Integer.parseInt(stringBuilder.reverse().toString());
    }*/


    public int reverseNumberUsingReverseFormula(int n){
        // 뒤집기 공식
        // ex 32
        // res = 0 ;
        // t = 32%10 = 2
        // res = res*10+t = 0*10+2 = 2
        // n = n/10 = 3
        // res = 2
        // t= 3%10 = 3
        // res = res*10+t = 2*10+3
        // n = 23
        // false
        int res = 0;
        for (int i=0; i<n; i++){
            int t = n%10;
            res = res*10+t;
            n = n/10;
        }
        return  res;
    }

    public int isPrime(int n) {
        if (n <= 1) return 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)  return 0;
        }
        return n;
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int n = sc.nextInt();
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < n) {
            int result = sol.solution(sc.nextInt());
            if (result != 0) {
                stringBuilder.append(result).append(" ");
            }
            i++;
        }
        System.out.println(stringBuilder.toString());
    }
}