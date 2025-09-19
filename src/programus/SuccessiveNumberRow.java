package programus;

import java.util.*;

public class SuccessiveNumberRow {
    // 시간 초과
    public int[] solution(int[] sequence, int k) {
        List<List<Integer>> lists = new ArrayList<>();
        int i =0;
        while (i<sequence.length){

            int ans = sequence[i];
            List<Integer> list = new ArrayList<>();
            if(sequence[i]==k){
                list.add(i);
                list.add(i);
                lists.add(list);
            }
            int j=i+1;
            while (j<sequence.length){
                ans +=sequence[j];
                if(ans==k) {
                    list.add(Math.min(i,j));
                    list.add(Math.max(i,j));
                    lists.add(list);
                    break;
                }
                j++;
            }
            i++;
        }
        if(lists.size()==1){
            return lists.get(0).stream().mapToInt(an->an).toArray();
        }

        Collections.sort(lists, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o1.get(1)-o1.get(0))-(o2.get(1)-o2.get(0));
            }
        });

        return lists.get(0).stream().mapToInt(an->an).toArray();
    }

    // 새로운 풀이
    public int[] solution2(int[] sequence, int k) {
        int lt=0;
        int rt=0;
        int sum =0;
        List<int[]> result = new ArrayList<>();
        while (rt<sequence.length){
            sum+=sequence[rt];
            while (sum>k && lt<rt){ // key 
                sum-=sequence[lt++];
            }
            if (sum == k) {
                result.add(new int[]{lt, rt});
            }
            rt++;
        }

        result.sort((a, b) -> (a[1] - a[0]) - (b[1] - b[0]));

        return result.get(0);
    }
    public static void main(String[] args) {
        SuccessiveNumberRow  successiveNumberRow = new SuccessiveNumberRow();
        int[] a=successiveNumberRow.solution2(new int[]{1, 2, 3, 4, 5}, 7);
        System.out.println(Arrays.toString(a));// 결과값 2 3
        int[] b=successiveNumberRow.solution2(new int[]{1, 1, 1, 2, 3, 4, 5}, 5);
        System.out.println(Arrays.toString(b));
        int[] c=successiveNumberRow.solution2(new int[]{2, 2, 2, 2, 2}, 6);
        System.out.println(Arrays.toString(c));
    }
}
