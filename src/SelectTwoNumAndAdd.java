import java.util.*;

public class SelectTwoNumAndAdd {

    public int[] selectTwoNumAndAdd(int[] numbers) {
        //int[] answer = {};
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {
                int beForeResult = numbers[i] + numbers[j];

                set.add(beForeResult);

            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

}
