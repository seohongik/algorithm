package ex24;

import java.util.*;
import java.util.stream.Collectors;

class Solution{
 /*
 *
4 3
3 4 1 2
4 3 2 1
3 1 4 2
 *
 * */

 public int solution(int n ,int m ,int[][] array) {

        // n = 학생수
        // m = 수학테스트 횟수
        // array = 등수 배열


        int ans = 0;
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n; j++) {
                int cnt= 0;
                for (int k = 0; k < array.length; k++) {

                    int pi =0, pj=0;
                    for (int s = 0; s <n; s++) {

                        if(array[k][s]==i) {
                            pi = s;
                        }

                        if(array[k][s]==j) {
                            pj = s;
                        }
                    }
                    if(pi<pj){
                        cnt++;
                    }

                }
                if(cnt==m){
                    ans++;
                }
            }
        }

        return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] arr=new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print(solution.solution(n, m, arr));

    }
}

