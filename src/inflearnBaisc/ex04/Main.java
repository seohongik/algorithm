package inflearnBaisc.ex04;

import java.util.Scanner;

class Solution{

    public String solution(int x,String s) {


        StringBuilder ans = new StringBuilder();
        ans.append(s);
        return ans.reverse().toString();
    }

}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();

        int start = 0;
        int x = Integer.parseInt(sc.nextLine());
        while (start < x) {
            String result = solution.solution(x, sc.nextLine());
            System.out.println(result);
            start++;
        }
    }
}
