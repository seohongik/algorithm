package programus;

import java.util.*;
import java.util.stream.Collectors;

public class CutAndModIndexArray {
    public int[] solution(int[] arr, int[] query) {

        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int count = -1;
        for (int i = 0; i < arr.length; i++) {

            for (int j=0; j<query.length; j++) {
                if (i % 2 == 0) {
                    count++;
                }

                if((i+j)%2==0) {
                    list=list.subList(0,query[count]+1);
                }

                if((i+j)%2!=0) {
                    list=list.subList(query[count],list.size());
                }
            }
            if(count>=query.length-1){
                break;
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
        CutAndModIndexArray solution = new CutAndModIndexArray();
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        solution.solution(arr, query);
    }

}
