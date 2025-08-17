package programus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemovedRocks {


    int solution(int distance, int[] rocks, int n) {
        
        Arrays.sort(rocks);

        List<Integer> ans = new ArrayList<>();


        Set<List<Integer>> set = new HashSet<>();
        int counter = 0;
        while (true){
            List<Integer> list = Arrays.stream(rocks).boxed().collect(Collectors.toList());

            for (int j=0; j<rocks.length; j++){
                Collections.shuffle(list);
            }
            List<Integer> subList=list.subList(0,n);
            Collections.sort(subList);
            set.add(subList);

            if(counter>Math.pow(rocks.length,n)){
                break;
            }
            counter++;

        }

        List<List<Integer>> removeRocks = new ArrayList<>(set);
        for (int j=0; j<removeRocks.size(); j++){
            List<Integer> restRocks = new ArrayList<>();
            for (int k=0; k<rocks.length; k++){
                if(removeRocks.get(j).contains(rocks[k])){
                    continue;
                }
                restRocks.add(rocks[k]);
            }
            Collections.sort(restRocks);

            IntStream.range(1, restRocks.size())
                    .map(index -> Math.abs(restRocks.get(index) - restRocks.get(index-1))).forEach(i-> {
                        int firstSpan = restRocks.get(0);
                        int span = i;
                        int lastSpan = distance-restRocks.get(restRocks.size()-1);
                        int min = Math.min(span,Math.min(firstSpan,lastSpan));
                        ans.add(min);
                    });
        }
        return Collections.max(ans);
    }
    

    /*
    IntStream.range(1, list.size())
                    .map(index -> Math.abs(list.get(index) - list.get(index-1))).forEach(tempList::add);
    * */


    public static void main(String[] args) {
        RemovedRocks solution = new RemovedRocks();
        System.out.println(solution.solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }
}
