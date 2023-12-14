import java.util.*;
import java.util.stream.Collectors;

public class FruitSeller {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] sorted_arr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Map<Integer, List<Integer>> map = Arrays.stream(sorted_arr).collect(Collectors.groupingBy(i -> i));
        List<List<Integer>> list_val = map.values().stream().collect(Collectors.toList());
        StringBuffer sb = new StringBuffer();

        for(int i=list_val.size()-1; i>=0; i--){
            for(int j =0; j<list_val.get(i).size(); j++){
                if (sb.length()%(m+1) == 0) {
                    sb.append(",");
                }
                sb.append(list_val.get(i).get(j));
            }
        }

        String[] put_arr= sb.toString().split(",");
        for(int i=0; i<put_arr.length; i++) {
            if (put_arr[i].length() == m) {
                answer += Integer.parseInt(String.valueOf(put_arr[i].charAt(put_arr[i].length()-1))) *m;
            }
        }

        return answer;
    }

}
