package ex08;

import java.util.*;

class Solution{
    public String solution(String s) {
        s = s.toLowerCase();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            if(String.valueOf(s.charAt(i)).matches("^[a-zA-Z]*$")){
                list.add(s.charAt(i));
            }
        }
        int count =0;
        for (int i=0,j=list.size()-1; i<list.size()/2; i++,j--){

            if(list.get(i)==list.get(j)){
                count++;
            }
        }
        if( count == list.size() / 2){
            return "YES";
        }
        return "NO";
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        String result = solution.solution(sc.nextLine());
        System.out.println(result);
    }
}
