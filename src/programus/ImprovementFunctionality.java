package programus;

import java.util.*;
import java.util.stream.Collectors;

public class ImprovementFunctionality {

    public int[] solution(int[] progresses, int[] speeds) {

        int[] calculatedProgresses = new int[progresses.length];

        List<Integer> calculatedSpeeds = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            calculatedProgresses[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            calculatedSpeeds.add(calculatedProgresses[i]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(calculatedSpeeds.get(0));

        for (int i =0; i<calculatedSpeeds.size()-1; i++){
            List<Integer> calcTemp = calculatedSpeeds.subList(i, i+2);
            if(calcTemp.get(0)>=calcTemp.get(1)){
                calcTemp.set(1, calcTemp.get(0));
            }

            if(!queue.isEmpty() && queue.peek()>=calcTemp.get(1)){
                queue.add(calcTemp.get(1));
            }else {
                queue.add(calcTemp.get(1));
            }
        }

        List<Integer> proccessed = new ArrayList<>(queue);

        if(proccessed.get(proccessed.size()-2)>=proccessed.get(proccessed.size()-1)){
            proccessed.set(proccessed.size()-1, proccessed.get(proccessed.size()-2));
        }

        Map<Integer, Long> counter = proccessed.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));

        return counter.values().stream().mapToInt(Long::intValue).toArray();
    }

    public static void main(String[] args) {
        ImprovementFunctionality test = new ImprovementFunctionality();
        System.out.println(Arrays.toString(test.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); //[2, 1]
        System.out.println(Arrays.toString(test.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))); //[1, 3, 2]

    }
}
