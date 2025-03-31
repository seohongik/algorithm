package ex36;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    public int solution(int[] arr, int n, int k) {


        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = arr[i];
        }
        Arrays.sort(a, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        return 0;
    }
}

public class Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.println(T.solution(arr, n, k));
    }
}
