import java.util.*;
import java.util.stream.Collectors;

public class PhoneCatMon {

    public int phoneCatMon(int[] nums) {

        int selectAvailable = nums.length/2; //3

        Map<Integer, List<Integer>> groupResult = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(i -> i));
        List<List<Integer>> list_entries = groupResult.values().stream().collect(Collectors.toList());

        Collections.sort(list_entries, (obj1, obj2) -> {
            // 오름 차순 정렬

            Integer first = obj2.size();
            Integer second = obj1.size();
            return second.compareTo(first);
        });

        List<Integer> vector = new ArrayList<>();

        int index = 1;
        while (vector.size()<selectAvailable){

            List<Integer> entity = list_entries.get(index - 1);

            if(!entity.isEmpty()){
                vector.add(entity.get(0));
                entity.remove(0);
            }


            if(index>=list_entries.size()){
                index=0;
            }
            index++;
        }

        Set<Integer> set=vector.stream().collect(Collectors.toSet());

        return set.size();
    }
}
