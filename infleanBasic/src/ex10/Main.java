package ex10;

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
