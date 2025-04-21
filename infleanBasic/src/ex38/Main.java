package ex38;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String braces) {
        Stack<Character> stack = new Stack<>();
        for (Character c : braces.toCharArray()) {

            if(c==')'){
                while (stack.pop()!='(');
            }else {
                stack.push(c);
            }
        }

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}

public class Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.println(T.solution(str));
    }
}
