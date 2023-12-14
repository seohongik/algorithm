import java.util.*;
import java.util.stream.Collectors;

public class PlusEmptyNum {

    public int solution(int[] numbers) {
        Set<Integer> set= new HashSet<>();

        for(int i=0; i<10; i++){ //0-9까지 셋에 담고
            set.add(i);
        }
        Arrays.sort(numbers); // 정렬후에

        List<Integer> copyList = Arrays.stream(numbers).boxed().collect(Collectors.toList()); //리스트로 만든다.

        for(int i=0; i<copyList.size(); i++){
            set.remove(copyList.get(i)); //set에서 list의 원소를 삭제하고
        }

        return set.stream().mapToInt(Integer::intValue).sum(); //총합 더해서 리턴
    }

}
