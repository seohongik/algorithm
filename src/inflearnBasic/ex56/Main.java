package inflearnBasic.ex56;

import java.util.Scanner;

class Solution {
    public int   solution(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 1;
        }else {
            return solution(n - 1) + solution(n - 2);
        }

    }
    


}
public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();

        for(int i = 1; i <= n; i++) {
            System.out.print(solution.solution(i) + " ");
        }
    }
}