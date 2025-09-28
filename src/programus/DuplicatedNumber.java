package programus;

import java.util.HashMap;
import java.util.Map;

public class DuplicatedNumber {

    public int solution(int[] array, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        return map.getOrDefault(n, 0);
    }

    public static void main(String[] args) {

        //https://school.programmers.co.kr/learn/courses/30/lessons/120583?language=java
        System.out.println(new DuplicatedNumber().solution(new int[]{1, 1, 2, 3, 4, 5}, 1));
        System.out.println(new DuplicatedNumber().solution(new int[]{0, 2, 3, 4}, 1));
    }
}
