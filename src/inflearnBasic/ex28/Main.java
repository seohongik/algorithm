package inflearnBasic.ex28;

import java.util.Scanner;

// 답 조건 안맞으면 빼기
class Solution2{

    public int  solution(int n, int m, int[] a) {
        int ans = 0;
        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < a.length; rt++) {

            sum += a[rt];
            if(sum == m){
                ans++;
            }
            // 한번에 안빠지는 경우도 있음
            while (sum>=m){
                sum -= a[lt++];
                if(sum == m){
                    ans++;
                }
            }

        }

        return ans;
    }

}
// 내풀이식 크면 sum =0 초기화
class Solution{
  public int  solution(int n, int m, int[] a){
      int initIdx =0;
      int sumIdx =0;
      int sum =0;
      int count=0;
      while (sumIdx<n){
          if(sum>m){
              initIdx++;
              sumIdx = initIdx;
              sum = 0;
          }
          sum +=a[sumIdx];
          sumIdx++;
          if(sum==m){
              count++;
          }
      }
      return count;
  }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[] a=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        System.out.println(T.solution(n, m, a));
    }
}

