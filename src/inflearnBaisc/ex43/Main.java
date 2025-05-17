package inflearnBaisc.ex43;

import java.util.*;

class Solution {

    public String solution(String required, String n ){
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : required.toCharArray()) {
            deque.add(c);
        }
        for (char c : n.toCharArray()) {
            if(!deque.isEmpty()) {
                if (deque.peekFirst() == c) {
                    deque.removeFirst();
                }
            }
        }
        if(deque.isEmpty()){
            return "YES";
        }
        return "NO";
    }
}

// 이게 답
class Solution2 {

    public String solution(String required, String n ){



        return "NO";

    }
}

public class  Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        String required=kb.next();
        String n=kb.next();
        System.out.println(T.solution(required,n));
    }
}

