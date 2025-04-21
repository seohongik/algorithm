package ex37;

import java.util.*;


class Solution {
    public String solution(String braces) {

        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        int cnt=0;
        for (int i = 0; i < braces.length(); i++) {

            if(braces.charAt(i) == '('){
                stack.add(braces.charAt(i));
            }else {
                while (!stack.isEmpty()){
                    queue.offer(stack.pop());
                }
                cnt++;
            }
        }
        if(stack.isEmpty()&& cnt==queue.size()){
            return "YES";
        }

        return "NO";
    }
}

// 문제 풀이 2
class Solution2 {
    public String solution(String braces) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < braces.length(); i++) {
            if(braces.charAt(i) == '('){
                stack.push(braces.charAt(i));
            }else {
                if(stack.isEmpty()){
                    return "NO";
                }
                stack.pop();
            }

        }
        if(stack.isEmpty()){
            return "YES";
        }
        return "NO";
    }
}

public class Main {

    public static void main(String[] args){
        Solution2 T = new Solution2();
        Scanner kb = new Scanner(System.in);
        String str=kb.next();
        System.out.println(T.solution(str));
    }
}
