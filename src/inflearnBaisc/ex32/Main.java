package inflearnBaisc.ex32;

import java.util.*;

class Solution {

    public String solution(int n, String str){

        String[] pickUp = str.split("");
        Map<String , Integer> map = new HashMap<>();
        for (int i = 0; i < pickUp.length; i++) {
            map.put(pickUp[i], map.getOrDefault(pickUp[i], 0) + 1);
        }
        List<Integer> values = new ArrayList<>(map.values());
        int max = values.indexOf(Collections.max(values));
        List<String> winners = new ArrayList<>(map.keySet());
        String winer = winners.get(max);
        return winer;
    }

}

public class Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        String str=kb.next();
        System.out.println(T.solution(n, str));
    }
}
