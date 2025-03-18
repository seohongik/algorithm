package ex23;

import java.util.*;


class Solution{

    public int solution(int n , int[][] array) {

        int answer = 0, max = Integer.MIN_VALUE;

        for (int i = 1; i <=n; i++) {
            int count=0;
            for (int j = 1; j <=n; j++) {
                for (int k = 1; k <= 5; k++) {
                    if(array[i][k] == array[j][k]) {
                        count++;
                        break;
                    }
                }
            }

            if(count > max) {
                max = count;
                answer = i;
            }
        }

        return answer;
    }

}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][6];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(solution.solution(n, arr));

    }
}

