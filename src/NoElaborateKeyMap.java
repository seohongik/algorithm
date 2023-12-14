import java.security.AllPermission;
import java.util.*;
import java.util.stream.Collectors;

public class NoElaborateKeyMap {

    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList<>();
        List<String> allKey = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        Map<String ,List<Integer>> map = new HashMap<>();

        for (int k = 0; k < allKey.size(); k++) {

            List<Integer> idx_list = new ArrayList<>();
            for(int i=0; i<keymap.length; i++){

                List<String > key_atom_list= Arrays.stream(keymap[i].split("")).collect(Collectors.toList());

                for(int j=0; j<key_atom_list.size(); j++) {

                    if (allKey.get(k).contains(key_atom_list.get(j))) {

                        idx_list.add(j);
                        map.put(key_atom_list.get(j), new ArrayList<>(idx_list));
                    }

                }

            }
        }

        for(int i=0; i<targets.length; i++){

            String[] targets_arr=targets[i].split("");

            int sum=0;

            for(int j=0; j<targets_arr.length; j++){
                List<Integer> result = map.get(targets_arr[j]);
                if(map.get(targets_arr[j])!=null) {
                    sum+=Collections.min(result)+1;
                }else{
                    sum=-1;
                    break;
                }
            }
            answer.add(sum);
        }

        return answer.stream().mapToInt(i->i).toArray();
    }


}