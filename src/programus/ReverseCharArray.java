import java.util.Arrays;

public class ReverseCharArray {

    public int[] solution(long n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        sb.reverse();

        return Arrays.stream(sb.chars().toArray()).map(i->i-48).toArray();
    }

    public static void main(String[] args) {
        ReverseCharArray s = new ReverseCharArray();
        System.out.println(s.solution(1234));
    }

}
