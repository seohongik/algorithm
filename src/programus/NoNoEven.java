package programus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NoNoEven {

    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        IntStream.range(1, n+1).filter(i->i%2==1).forEach(answer::add);
        return answer.stream().mapToInt(i->i).toArray();
    }


    public static void main(String[] args) {
        NoNoEven noNoEven = new NoNoEven();
        noNoEven.solution(10);
    }
}
