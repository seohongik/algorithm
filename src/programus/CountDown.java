package programus;

import java.util.ArrayList;
import java.util.List;

public class CountDown {

    List<Integer> list = new ArrayList<>();
    public int[] solution(int start_num, int end_num) {
        int[] answer = {};

        if(start_num==end_num-1) {
            answer = list.stream().mapToInt(i->i).toArray();
            return answer;
        }
        list.add(start_num);
        return solution(--start_num, end_num);
    }

}
