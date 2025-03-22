package ex25;

import java.util.Arrays;
import java.util.Scanner;

class Solution{

  public int[] solution(int n, int m, int[] a, int[] b){
     int[] ans = new int[n+m];
     for (int i = 0; i < n; i++){
         ans[i] = a[i];
     }
     for (int i = 0; i < m; i++){
         ans[n+i]=b[i];
     }
     Arrays.sort(ans);
     return ans;
  }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        int m=kb.nextInt();
        int[] b=new int[m];
        for(int i=0; i<m; i++){
            b[i]=kb.nextInt();
        }
        for(int x : solution.solution(n, m, a, b)) System.out.print(x+" ");

    }
}

