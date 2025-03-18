package ex14;

import java.util.*;

class Solution {

    public int solution(int n, int[] array) {
        int count = 1;
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max) {
                max = array[i];
                count++;
            }
        }
        return count;
    }

}

class Main {
    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] arr=new int[n+1];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(n, arr));
    }
}
