package inflearnBasic.ex54;

import java.util.Scanner;

class Solution {

    public void solution(int n) {

        if(n == 0){
            return;
        }else {
            solution(n/2);
        }
        System.out.print(n%2);
    }
}
public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        solution.solution(n);

    }
}