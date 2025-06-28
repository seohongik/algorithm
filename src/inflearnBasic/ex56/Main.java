package inflearnBasic.ex56;

import java.util.Scanner;

public class Main {

    static int [] memo;
    public static int solution(int n) {

        if(memo[n] > 0) return memo[n]; // 이미 값이 있을때 구해져 있는 값을 이용한다.

        if(n == 1) {
            return memo[n]=1;
        } else if(n == 2) {
            return memo[n]=1;
        }else {
            return memo[n] = solution(n - 2)+solution(n - 1);

        }

    }
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        //for(int i = 1; i <= n; i++) {
        //    System.out.print(solution.solution(i) + " ");
        //}

        memo = new int[n+1];
        solution(n);
        for(int i = 1; i <= n; i++) {
            System.out.println(memo[i]+" ");
        }
    }
}