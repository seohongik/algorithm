package ex27;

import java.util.*;


// 타임 리밋 
class Solution2{
    public int  solution(int n, int k ,int[] arr){
        int i=0;
        int j=k;
        int sum =0;
        while (j<n){
            int h=i;
            int max =0;
            while ( h < j){
                max += arr[h];
                h++;
            }
            sum =Math.max(sum,max);
            j++;
            i++;
        }
        return sum;
    }
}

class Solution{
  public int  solution(int n, int k ,int[] arr){
      int sum = 0;
      for (int i=0;i<k;i++) {
          sum += arr[i];
      }
      int ans =sum;
      for (int i=k;i<arr.length;i++){
          sum = sum -arr[i-k]+arr[i];
          System.out.println(sum);
         ans= Math.max(ans,sum);
      }
      return ans;
  }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.print(T.solution(n, k, arr));
    }
}

