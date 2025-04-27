package inflearnBaisc.ex31;

import java.util.*;


// 시간초과 남 (직접 뒤집지말고... 생각 한번 더 해보기)
class Solution2{
  public int  solution(int n, int k , int[] array ){

      Queue<Integer> que=new LinkedList<>();
      int count=0;
      int start2 =0;
      int max = 0;
      for (int i=0; i<array.length; i++){
          if(array[i]==0){
              count++;
              que.add(start2);
              array[start2] = 1;
              if (count > k) {
                  int revert = que.poll();
                  array[revert] = 0;
              }
          }
          int ans =0;
          for (int j=0; j<start2+1; j++){

              if(array[j]==1){
                  ans++;
              }else if(array[j]==0){
                  ans=0;
              }
              max =Math.max(max,ans);
          }
          start2++;

      }
      return max;
  }
}
// ans = 누적 길이 cnt = 변경된값   수열길이 lt~rt
class Solution{
    public int  solution(int n, int k , int[] array ){
        int cnt =0;
        int answer=0;
        int lt =0;
        for (int rt=0; rt<array.length; rt++){
            if(array[rt]==0){
                cnt++;
            }
            while(cnt>k){ // k=2 라고 가정하면 cnt가 3일 때 와일문 돌고 하나 깍으니까 최초 바꾼 것을 바꾸고 감소 결과는 !2>2이니까 하나 바꾸고 빠져나옴, 즉 , 하나만 바꿈
                if(array[lt]==0) {
                    cnt--;
                }
                lt++;
            }
            answer=Math.max(answer, rt-lt+1);

        }

        return answer;
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

