package inflearnBaisc.ex10;

import java.util.*;

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

class Solution2  {
    int[] dx={-1, 0, 1, 0};
    int[] dy={0, 1, 0, -1};
    public int solution(int n, int[][] arr){
        int answer=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                boolean flag=true;
                for(int k=0; k<4; k++){
                    int nx=i+dx[k];
                    int ny=j+dy[k];
                    if(nx>=0 && nx<n && ny>=0 && ny<n && arr[nx][ny]>=arr[i][j]){
                        flag=false;
                        break;
                    }
                }
                if(flag) answer++;
            }
        }
        return answer;
    }
}

public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.print(solution.solution(n, arr));
    }
}
