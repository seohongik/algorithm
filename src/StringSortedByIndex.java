import java.util.Arrays;
public class StringSortedByIndex {

    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings);

        Arrays.sort(strings, (o1, o2) -> {

            if(String.valueOf(o1.charAt(n)).equals(String.valueOf(o2.charAt(n)))){

                return o1.compareTo(o2);
            }
            return String.valueOf(o1.charAt(n)).compareTo(String.valueOf(o2.charAt(n)));
        });


        return strings;
    }

}
