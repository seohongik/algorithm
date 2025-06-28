package inflearnBasic.ex49;

import java.util.*;

class Solution {
    public List<List<Integer>> solution(int n,List<List<Integer>> xy){
        xy.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int diff = o1.get(0).compareTo(o2.get(0));

                if (diff == 0) {
                    return o1.get(1).compareTo(o2.get(1));
                }
                return diff;
            }
        });
        return new ArrayList<>(xy);
    }
}
// 이게 답
class Point implements Comparable<Point>{
    public int x, y;
    Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    @Override
    public int compareTo(Point o){
        if(this.x==o.x) return this.y-o.y;
        else return this.x-o.x;
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

        // 이게 답
        ArrayList<Point> arr=new ArrayList<>();
        for(int i=0; i<n; i++){
            int x=kb.nextInt();
            int y=kb.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        for(Point o : arr) System.out.println(o.x+" "+o.y);
    }
}