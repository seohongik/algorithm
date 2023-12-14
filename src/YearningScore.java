import java.util.*;

public class YearningScore {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {

        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<photo.length; i++){
            int sum=0;
            for(int j=0; j<photo[i].length; j++){
                sum+=map.getOrDefault(photo[i][j],0);
            }
            list.add(sum);
        }
        return list.stream().mapToInt(i->i).toArray();
    }

}
