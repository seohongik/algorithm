import java.util.Arrays;
import java.util.stream.Collectors;

public class WaterMelon{
    public String solution(int n) {
        String[] arr = new String[n];
        arr[0]="수";
        for (int i=1; i<arr.length; i++){
            if("수".equals(arr[i-1])){
                arr[i]="박";
            }else {
                arr[i]="수";
            }
        }
        return Arrays.stream(arr).collect(Collectors.joining());
    }
}
