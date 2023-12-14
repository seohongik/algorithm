
import java.util.*;

public class Trio {

    public int solution(int[] number) {
        number = new int[]{-3, -2, -1, 0, 1, 2, 3};
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0; i<number.length; i++){
            for(int j=0; j<i; j++){
                for(int k=0; k<j; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(number[i]);
                        list.add(number[j]);
                        list.add(number[k]);
                        lists.add(list);

                    }
                }
            }
        }
        return lists.size();
    }
}
