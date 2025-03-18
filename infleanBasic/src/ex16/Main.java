package ex16;

import java.util.*;
class Solution{

    public int[] solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        return arr;
    }

}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        int[] result=sol.solution(sc.nextInt());

        for (int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
    }
}