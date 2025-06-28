package inflearnBasic.ex22;

import java.util.*;

// 8방향까지 고려할수 있는 코드
class Solution2{

    int[] dx = {0, -1, 0, 1 };
    int[] dy = {-1, 0, 1, 0};
    public  int solution(int n , int[][] array) {

        int[][] paddedArray = new int[n+2][n+2];
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                paddedArray[i+1][j+1] = array[i][j];
            }
        }

        //boolean으로 봉우리 아닌거 false두고 true만 카운트 세어 리턴할 수 있음
        int peak = 0;
        for (int i = 1; i < paddedArray.length-1; i++) {
            for (int j = 1; j < paddedArray.length-1; j++) {
                int count=0;
                for (int k = 0; k < dx.length; k++) {
                    int x = dx[k];
                    int y = dy[k];

                    if(paddedArray[x+i][y+j]<paddedArray[i][j]){
                       count++;
                    }

                    if (count == 4) {
                        peak++;
                    }
                }
            }
        }
        return peak;
    }

}

//8방향 고려 안됨
class Solution{
    public  int solution(int n , int[][] array) {

        List<Integer> peaks = new ArrayList<>();
        int[][] paddedArray = new int[n+2][n+2];
        for (int i=0; i<array.length; i++){
            for (int j=0; j<array[i].length; j++){
                paddedArray[i+1][j+1] = array[i][j];
            }
        }

        for (int i=1; i<paddedArray.length-1; i++){
            for (int j=1; j<paddedArray[i].length-1; j++){
                int greater1 =  paddedArray[i][j + 1];
                int greater2 =  paddedArray[i][j - 1];
                int greater3 =  paddedArray[i+1][j];
                int greater4 =  paddedArray[i-1][j];
                if(paddedArray[i][j]>greater1 && paddedArray[i][j]>greater2 && paddedArray[i][j]>greater3&& paddedArray[i][j]>greater4){
                    peaks.add(paddedArray[i][j]);
                }
            }
        }
        return peaks.size();

    }

}

public class Main {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.print(solution.solution(n, arr));
    }
}
