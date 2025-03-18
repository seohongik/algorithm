package ex6;

import java.util.*;
import java.util.stream.Collectors;

class Solution{

    public String solution(String s) {
        return Arrays.stream(s.split("")).distinct().collect(Collectors.joining());
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
