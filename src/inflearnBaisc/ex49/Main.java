package inflearnBaisc.ex49;

import java.util.*;

class Solution {
    public List<List<Integer>> solution(int n,List<List<Integer>> xy){
        Collections.sort(xy, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int diff  = o1.get(0).compareTo(o2.get(0));

                if(diff==0){
                    return o1.get(1).compareTo(o2.get(1));
                }
                return diff;
            }
        });
        return new ArrayList<>(xy);
    }
}

public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        List<List<Integer>> xy= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list= new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                list.add(kb.nextInt());
            }
            xy.add(list);
        }
        List<List<Integer>> lists =solution.solution(n, xy);

        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i).get(0)+" "+lists.get(i).get(1));
        }
    }
}