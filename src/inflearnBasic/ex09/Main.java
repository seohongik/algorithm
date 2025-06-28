package inflearnBasic.ex09;
import java.util.*;

class Solution{

    public int solution(String s) {

        StringBuilder sb=new StringBuilder();

        for (int i=0; i<s.length(); i++){
            if(48<=s.charAt(i) && s.charAt(i)<=57){
                sb.append(s.charAt(i));
            }
        }

        return Integer.parseInt(sb.toString());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int result = solution.solution(sc.nextLine());
        System.out.println(result);
    }
}