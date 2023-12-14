import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class GymClothes {

    public int solution(int n, int[] lost, int[] reserve) {

        List<Integer> all_list = IntStream.range(1, n+1).boxed().collect(Collectors.toList());

        Map<Integer,Integer> clothes_map = new TreeMap<>();

        List<Integer> lost_list = Arrays.stream(lost).boxed().collect(Collectors.toList());

        List<Integer> reserve_list = Arrays.stream(reserve).boxed().collect(Collectors.toList());

        for(int i=0; i<all_list.size(); i++){

            for(int j=0; j<lost.length; j++){
                if(lost[j]==all_list.get(i)){
                    clothes_map.put(i+1,0);

                }
            }

            for(int k=0; k<reserve.length; k++){
                if(reserve[k]==all_list.get(i)){
                    clothes_map.put(i+1,2);

                }
            }

        }

        List<Integer> key_list = clothes_map.keySet().stream().collect(Collectors.toList());

        for(int i=0; i<all_list.size(); i++){

            if(!key_list.contains(all_list.get(i))){

                clothes_map.put(i+1,1);
            }

            if(clothes_map.get(i+1)==2 && lost_list.contains(all_list.get(i)) && reserve_list.contains(all_list.get(i))){
                clothes_map.put(i+1,1);
            }

        }

        key_list = clothes_map.keySet().stream().collect(Collectors.toList());

        List<Integer> val_list = clothes_map.values().stream().collect(Collectors.toList());

        for(int i=0,j=1; j<val_list.size(); i++,j++){
            int pre= clothes_map.get(key_list.get(i));
            int suf= clothes_map.get(key_list.get(j));

            if(pre==2&&suf==0){
                clothes_map.put(i+1, 1);
                clothes_map.put(j+1, 1);
            }

            if(pre==0&& suf==2){
                clothes_map.put(i+1, 1);
                clothes_map.put(j+1, 1);

            }
        }

        List<Integer> list = clothes_map.values().stream().collect(Collectors.toList());

        int sum= 0;

        for(int i=0; i<list.size(); i++){

            if(list.get(i)==2){

                sum+=1;
            }else {
                sum+=list.get(i);
            }

        }

        return sum;

    }

}
