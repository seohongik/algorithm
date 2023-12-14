import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ArrayDivisor {

    public int[] arrayDivisor(int[] arr, int divisor) {
        List<Integer> list= new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0) {
                int puttable = arr[i];
                list = check(puttable, list);
            }
        }
        if(list.isEmpty()){

            list.add(-1);
        }

        Collections.sort(list);

        return list.stream().mapToInt(i->i).toArray();
    }

    private List<Integer> check(int puttable,List<Integer> list ){
        list.add(puttable);
        return list;
    }

}
