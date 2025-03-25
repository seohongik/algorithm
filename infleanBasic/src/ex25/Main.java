package ex25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 투 포인터로 후 처리 이용하는게 더 빠름 ..
class Solution2 {

    public ArrayList<Integer> solution(int n, int m, int[] a, int[] b){
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (p1 <n && p2 <m) {

            if(a[p1]<b[p2]) {
                list.add(a[p1++]);
            }else{
                list.add(b[p2++]);
            }
        }
        while (p1 <n) {
            list.add(a[p1++]);
        }
        while (p2 <m) {
            list.add(b[p2++]);
        }

        return list;
    }

}


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
        Solution2 solution = new Solution2();
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

