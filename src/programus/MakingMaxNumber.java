package programus;

import java.util.*;
import java.util.stream.Collectors;

public class MakingMaxNumber {

    public String solution(String number, int k) {

        List<Integer> numbers = Arrays.stream(number.trim().split("")).map(Integer::parseInt).collect(Collectors.toList());

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < numbers.size(); i++) {

            while (!stack.isEmpty() && k>0 && Integer.parseInt(stack.peek()) < numbers.get(i)) {
                stack.pop();
                k--;
            }
            stack.push(String.valueOf(numbers.get(i)));
        }

        if (k > 0) stack.pop();

        return stack.stream().collect(Collectors.joining());
    }



    public static void main(String[] args) {
        MakingMaxNumber makingMaxNumber = new MakingMaxNumber();
        System.out.println(makingMaxNumber.solution("1924", 2)); //94
        System.out.println("=================");
        System.out.println(makingMaxNumber.solution("1231234", 3)); //3234
        System.out.println("=================");
        System.out.println(makingMaxNumber.solution("4177252841", 4)); //775841
    }
}
