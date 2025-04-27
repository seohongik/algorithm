package inflearnBaisc.ex07;

import java.util.*;

class Solution{

    public String solution(String s) {
        s = s.toLowerCase();
        int count =0;

        for (int i=0,j=s.length()-1; i<s.length()/2; i++,j--){

            if(s.charAt(i)==s.charAt(j)){
                count++;
            }
        }

        if( count == s.length() / 2){
            return "YES";
        }
        return "NO";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        String result = solution.solution(sc.nextLine());
        System.out.println(result);
    }
}
