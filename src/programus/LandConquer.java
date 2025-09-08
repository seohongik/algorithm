package programus;
import java.util.*;
import java.util.stream.Collectors;

public class LandConquer {
    int solution(int[][] land) {

        for (int i = 1; i < land.length; i++) {

            land[i][0]+=Math.max(Math.max(land[i-1][1],land[i-1][2]),land[i-1][3]);
            land[i][1]+=Math.max(Math.max(land[i-1][0],land[i-1][2]),land[i-1][3]);
            land[i][2]+=Math.max(Math.max(land[i-1][0],land[i-1][1]),land[i-1][3]);
            land[i][3]+=Math.max(Math.max(land[i-1][0],land[i-1][1]),land[i-1][2]);

        }
        return Math.max(Math.max(Math.max(land[land.length-1][0],land[land.length-1][1]),land[land.length-1][2]),land[land.length-1][3]);
    }

    public static void main(String[] args) {

        LandConquer landConquer = new LandConquer();
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        System.out.println(landConquer.solution(land)); //16
        // 5 7 4

        System.out.println("------------------");
        int[][] land2 =  {{6, 7, 1, 2},{2, 3, 10, 8},{1, 3, 9, 4},{7, 11, 4, 9}};
        System.out.println(landConquer.solution(land2));
        /*
        입력값 〉 [[6, 7, 1, 2], [2, 3, 10, 8], [1, 3, 9, 4], [7, 11, 4, 9]]
        기댓값 〉 35
        /*
        (행1, 열2) = 7
        (행2, 열4) = 8
        (행3, 열3) = 9
        (행4, 열2) = 11
         */

        /*
        입력값 〉 [[4, 3, 2, 1], [2, 2, 2, 1], [6, 6, 6, 4], [8, 7, 6, 5]]
        기댓값 〉 20
        */

        System.out.println("------------------");
        int[][] land3 =  {{4, 3, 2, 1},{2, 2, 2, 1},{6, 6, 6, 4},{8, 7, 6, 5}};
        System.out.println(landConquer.solution(land3));


        /*
        입력값 〉 [[1, 1, 3, 1], [2, 3, 2, 2], [1, 4, 1, 1]]
        기댓값 〉 9
        * */


    }
}
