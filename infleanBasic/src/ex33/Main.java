package ex33;

import java.util.*;

class Solution {

    public String solution(String str1, String str2) {

        Map<Character , Integer> map1 = new TreeMap<>();
        Map<Character , Integer> map2 = new TreeMap<>();

        for (int i = 0; i < str1.length(); i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
        }

        for (int i = 0; i < str2.length(); i++) {
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }

        if(map1.equals(map2)) {
            return "YES";
        }
        return "NO";
    }

}

public class Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        String str1=kb.next();
        String str2=kb.next();
        System.out.println(T.solution(str1,str2));
    }
}
