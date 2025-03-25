package ex30;

import java.util.Scanner;
import java.util.stream.IntStream;

//빼고 남은 횟수로 나웠을 때 몫이 0 이면 참 아니면 거짓
class Solution3 {
    public int solution(int n) {

        int ans = 0;
        int cnt = 1;
        n--; // 14
        while (n > 0) {
            cnt++; //2 //3
            n = n - cnt; //12 //9
            if (n / cnt == 0) { // 6 6 -> 7+8  = 15 / 3 3 3 -> 4+5+6 = 15
                ans++;
            }
        }
        return ans;
    }
}


// 답
class Solution2{
    public int  solution(int n ){
        int[] a= IntStream.range(1, n+1).toArray();
        int ans =0 ;
        int sum=0;
        int lt = 0;

        for(int rt=0; rt<a.length/2+1;rt++){
            sum+=a[rt];
            if(sum == n){
                ans++;
            }
            while (sum>n){
                sum-=a[lt++];
                if(sum == n){
                    ans++;
                }
            }
        }
        return ans;
    }
}


class Solution{
  public int  solution(int n ){
      int[] a= IntStream.range(1, n+1).toArray();
      int start =0;
      int sta = 0;
      int end =a.length-1;
      int sum =0;
      int count=0;

      while (start<=end){
          if(sum>n){
              sum=0;
              sta++;
              start = sta;
          }
          if(sum==n){
              count++;
              sum=0;
              sta++;
              start = sta;
          }
          sum+=a[start];
          start++;

      }
      return count;
  }
}

public class Main {
    public static void main(String[] args) {
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        System.out.println(T.solution(n));
    }
}

