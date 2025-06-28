package inflearnBasic.ex41;

import java.util.*;

//this
class Solution {

    public int solution(String bar){
        Stack<Character> stack = new Stack<>();

        int result=0;
        for (int i=0; i<bar.length(); i++) {

            if(bar.charAt(i)=='('){
                stack.push(bar.charAt(i));
                continue;
            }
            if (bar.charAt(i) == ')') { // 닫힌 괄호일 경우,
                stack.pop(); // 일단 stack에서 pop을 실행.

                if (bar.charAt(i - 1) == '(') { // 그 전 괄호가 열린 괄호면 레이저를 의미.
                    result += stack.size(); // 현재 stack의 사이즈만큼 더해 줌.
                } else { // 그 전 괄호가 닫힌 괄호면 레이저가 아님.
                    result++; // 단순히 1을 더해 줌.
                }
            }
            //System.out.println(stack);
        }
        //System.out.println(result);
        return result;
    }
}

public class  Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        T.solution(str);
        System.out.println(T.solution(str));
    }
}
