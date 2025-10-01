package programus;

import java.util.Arrays;

public class ArrayMulti2 {
    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(x -> x * 2).toArray();
    }
    public static void main(String[] args) {
        ArrayMulti2 arrayMulti2 = new ArrayMulti2();
        System.out.println(Arrays.toString(arrayMulti2.solution(new int[]{1, 2, 3, 4, 5})));
    }
}
