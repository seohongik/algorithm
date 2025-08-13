package programus;
import java.util.Arrays;


public class SequenceAndQuery {

    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1]; i++) {
                if (i % query[2] == 0) {
                    arr[i] += 1;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        SequenceAndQuery seq = new SequenceAndQuery();
        int[] result =  seq.solution(new int[]{0,1,2,4,3},new int[][]{ {0,4,1}, {0,3,2}, {0,3,3}});
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }
}
