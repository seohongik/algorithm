package inflearnBaisc.ex50;

import java.util.*;
import java.util.stream.Collectors;


/*

8 32
23 87 65 12 57 32 99 81

->3

15 99
73 32 31 49 94 37 40 62 78 66 27 100 99 29 9
-> 14

* */



class Solution {
    public int  solution(int n,int m, int[] array){
        Arrays.sort(array);
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        return list.indexOf(m)+1;
    }
}
// 이건 카운트 몇번만에 찾는지 알려주는 알고리즘
class Solution2 {
    public int  solution(int n,int m, int[] array){
        Arrays.sort(array);
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        int count=0;
        while (count<n) {
            if(list.size()==1){
                break;
            }
            list = list.contains(m) &&list.indexOf(m)<list.size()/2 ? list.subList(0, (list.size()) / 2) : list.subList(list.size()/2, list.size());
            count++;
        }
        return count;
    }

}

public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[] array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=kb.nextInt();
        }
        System.out.println(solution.solution(n, m, array));

    }
}