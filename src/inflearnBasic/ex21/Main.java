package inflearnBasic.ex21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution{

    public  int solution(int n , int[][] array) {

        List<List<Integer>> sortingList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(array[i][i]);
            for (int j = 0; j < array[i].length; j++) {
                list.add(array[i][j]);
                list.add(array[j][i]);
            }
            list.add(array[i][array.length-i-1]);
            sortingList.add(list);
        }
        List<Integer> sumList = new ArrayList<>();
        for (int i = 0; i < sortingList.get(0).size(); i++) {
            int sum=0;
            for (int j = 0; j < sortingList.size(); j++) {
                sum+=sortingList.get(j).get(i);
            }
            sumList.add(sum);
        }
        return Collections.max(sumList);
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
