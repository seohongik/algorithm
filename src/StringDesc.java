import java.util.Arrays;
import java.util.stream.Collectors;

public class StringDesc {

    public String solution(String s) {
        String answer = "";

        String[] arr=s.split("");

        Arrays.sort(arr, (o1, o2) -> {
            return String.valueOf(o2).compareTo(String.valueOf(o1));
        });

        return Arrays.stream(arr).collect(Collectors.joining());
    }
}
