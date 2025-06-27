package inflearnBaisc.ex53;

import java.util.*;

/*
3

=> 1 2 3
* */

class Solution {
    
    public void solution(int n) {

        if(n==0){
            return ;
        }else {
            solution(n-1);
            System.out.print(n +" ");
        }
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