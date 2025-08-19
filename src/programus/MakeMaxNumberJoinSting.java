package programus;

import java.util.*;
import java.util.stream.Collectors;

public class MakeMaxNumberJoinSting {

    public String solution(int[] numbers) {
        String[] numbersArray = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numbersArray[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numbersArray, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        return Arrays.stream(numbersArray).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        MakeMaxNumberJoinSting test = new MakeMaxNumberJoinSting();
        System.out.println(test.solution(new int[]{6, 10, 2})); // 6 2 10
        System.out.println(test.solution(new int[]{3, 30, 34, 5, 9})); //9534330

    }
}
