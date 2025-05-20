package inflearnBaisc.ex46;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;


/*
5 9
1 2 3 2 6 2 3 5 7
-> 7 5 3 2 6
 */

//정렬로 풀기
class Solution2 {
    public int[]  solution(int size, int n , int[] inputs){
        int[] cache=new int[size];
        for(int x : inputs){
            int hit=-1;
            for(int i=0; i<size; i++){
                if(x==cache[i]) {
                    hit=i;
                }
            }
            if(hit==-1){
                for(int i=size-1; i>=1; i--){
                    cache[i]=cache[i-1];
                }
            }
            else{
                for(int i=hit; i>=1; i--){
                    cache[i]=cache[i-1];
                }
            }
            cache[0]=x;
        }
        return cache;
    }
}

//deque로 풀기
class Solution {
    public int[]  solution(int s, int n , int[] inputs){
        int[] memory = new int[s];
        //  cacheMiss 새로운 작업 들어옴 , 앞으로 교환후 하나 씩 밈
        //  cacheHit 새로운 작업이 들어옴 , 메모리는 꽊차있음, 중복되는거 없음 마지막꺼 밀고 , 첫번째 에 넘
        // 방안 1 Deque로 품
        // 방안 2 정렬로 품
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(inputs[0]);
        for (int i = 1; i < inputs.length; i++) {

            boolean cacheMiss = !deque.contains(inputs[i]);
            if (cacheMiss) {
                deque.addFirst(inputs[i]);
            }

            boolean cacheHit = deque.contains(inputs[i]);
            if (cacheHit) {
                deque.remove(inputs[i]);
            }
            deque.addFirst(inputs[i]);

            boolean full = deque.size()>s;
            if(full){
                deque.removeLast();
            }

        }

        return deque.stream().mapToInt(i->i).toArray();
    }
}
public class Main {

    public static void main(String[] args){
        Solution2 solution1 = new Solution2();
        Scanner kb = new Scanner(System.in);
        int s=kb.nextInt();
        int n=kb.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        int[] result=solution1.solution(s,n, arr);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
