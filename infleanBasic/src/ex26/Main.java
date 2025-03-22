package ex26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution{

  public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
     int[] ans = new int[n+m];
     for (int i = 0; i < n; i++){
         ans[i] = a[i];
     }
     for (int i = 0; i < m; i++){
         ans[n+i]=b[i];
     }
     Arrays.sort(ans);
     int count =0;
     ArrayList<Integer> list = new ArrayList<>();
     for (int i = 1; i < ans.length; i++){

         if(ans[i]==ans[i-1]){
             count++;
         }else {
             count=0;
         }
         if(count>=1){
             list.add(ans[i]);
         }
     }

     return list;
  }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
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
        for(int x : T.solution(n, m, a, b)) System.out.print(x+" ");

    }
}

