package programus;

import java.util.Arrays;
import java.util.Comparator;

public class MakeMinValue {

    public int solution(int[] A,int[] B) {
        int answer = 0;
        Integer[] A1= Arrays.stream(A).boxed().toArray(Integer[]::new);
        Integer[] B1=Arrays.stream(B).boxed().toArray(Integer[]::new);

        Arrays.sort(A1);
        Arrays.sort(B1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i=0; i<A1.length; i++){
            answer += (A1[i]*B1[i]);
        }

        return answer;
    }

}
