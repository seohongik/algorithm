package programus;

import java.util.*;
import java.util.stream.Collectors;

public class NumberMod {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        map=map.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<Integer> keys = new ArrayList<>(map.keySet());
        if(keys.size()==1){
            return keys.get(0);
        }
        if(map.get(keys.get(1)).intValue()==map.get(keys.get(0)).intValue()){
            return -1;
        }else {
            return keys.get(0);
        }
    }


    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/120812/solution_groups?language=java&type=my
        NumberMod numberMod = new NumberMod();
        numberMod.solution(new int[]{1, 2, 3, 4, 5, 5, 7, 8, 9});//5
    }
}
