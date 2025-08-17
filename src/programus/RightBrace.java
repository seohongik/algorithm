package programus;

import java.util.Stack;

public class RightBrace {
    boolean solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if(s.charAt(i)=='(') {
                stack.push(s.charAt(i));
            }else {
                if(stack.isEmpty()){
                    stack.push(s.charAt(i));
                }
            }
            if(!stack.isEmpty() && s.charAt(i)==')' && stack.peek()=='(') {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
