package inflearnBaisc.ex52;

import java.util.Arrays;
import java.util.Scanner;

/*
5 3
1 2 8 4 9

=> 3
* */

class Solution {
    public int  solution(int pointEA,int horse, int[] point){

        int ans = 0;
        Arrays.sort(point);

        int lt = 1;
        int rt = point[pointEA-1];

        while (lt <= rt) {
            int mid = lt + (rt - lt)/2;
            if(isPuttable(point,mid)>=horse){
                ans = mid;
                lt = mid + 1;
            }else {
                rt = mid - 1;
            }
        }

        return ans;
    }

    int isPuttable(int[] point, int dist){
        int count =1;
        int endPoint = point[0];
        for(int i=1;i<point.length;i++){

            if(point[i]-endPoint>=dist){
                count++;
                endPoint = point[i];
            }
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