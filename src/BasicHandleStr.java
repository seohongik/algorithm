import java.util.Arrays;
import java.util.Comparator;

public class BasicHandleStr {
    public boolean solution(String s) {

        String[] arr=s.split("");

        Arrays.sort(arr, Comparator.reverseOrder());

        char ch = arr[0].charAt(0);

        if(ch>='0' && ch<='9' && (s.length()==4 || s.length()==6)){
            return true;
        }
        return false;
    }
}
