package inflearnBaisc.ex51;
import java.util.*;


/*
 9 3
1 2 3 4 5 6 7 8 9
->17


10 3
6 5 8 5 6 8 7 6 6 7
->25
* */

class Solution {
    public int  solution(int songEA,int dvdEA, int[] songTime){

        int lt = Arrays.stream(songTime).max().getAsInt();
        int rt = Arrays.stream(songTime).sum();

        int ans = 0;
        while (lt <= rt){

            int mid = (lt + rt) / 2;

            if(isPuttable(songTime, mid)<=dvdEA){
                ans= mid;
                rt = mid-1;
            }else if(isPuttable(songTime, mid)>dvdEA){
                lt = mid+1;
            }
        }
        return ans-1;
    }

    int isPuttable(int[] songTime, int capacity){
        int count =1;
        int sum = 0;

        for (int x : songTime){
            if(sum+x<capacity){
                sum += x;
            }else {
                count++;
                sum = x;
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