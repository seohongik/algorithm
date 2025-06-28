package inflearnBasic.ex55;

import java.util.Scanner;

class Solution {

    public int solution(int n) {

        if(n == 1){
            return 1;
        }else {
            return solution(n-1)*n;
        }
    }
}
public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        System.out.println(solution.solution(n));

    }
}