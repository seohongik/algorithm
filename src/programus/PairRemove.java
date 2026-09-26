package programus;

import java.util.Stack;

public class PairRemove {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }else if(stack.peek()!=s.charAt(i)){
                stack.push(s.charAt(i));
            }else {
                stack.pop();
            }

        }

        if(stack.isEmpty()){
            return 1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        PairRemove pairRemove = new PairRemove();
        System.out.println(pairRemove.solution("baabaa"));
        System.out.println(pairRemove.solution("cdcd"));

    }
}
