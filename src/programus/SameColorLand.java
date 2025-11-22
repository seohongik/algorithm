package programus;

import java.util.HashMap;
import java.util.Map;

public class SameColorLand {

    public int solution(String[][] board, int h, int w) {
        int left = h-1;
        int right = h+1;
        int top = w+1;
        int bottom = w-1;
        String self = board[h][w];
        Map<String,String> rowMap = new HashMap<>();
        Map<String,String> colMap = new HashMap<>();
        Map<String,String> selfMap = new HashMap<>();
        selfMap.put(w+","+h, board[w][h]);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                rowMap.put(i+","+j, board[i][j]);
                colMap.put(i+","+j, board[j][i]);
            }
        }
        String leftValue = rowMap.get( left+ ","+w);
        String rightValue = rowMap.get( right+ ","+w);
        String topValue = rowMap.get( h+","+top);
        String bottomValue = rowMap.get( h+","+bottom);
        int count = 0;

        if(leftValue!=null&&leftValue.equals(self)){
            count++;
        }
        if(rightValue!=null&&rightValue.equals(self)){
            count++;
        }
        if(topValue!=null&&topValue.equals(self)){
            count++;
        }
        if(bottomValue!=null&&bottomValue.equals(self)){
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        SameColorLand solution = new SameColorLand();
        String[][] board = {
                 {"blue"  , "red"   , "orange" , "red"}
                ,{"red"   , "red"   , "blue"   , "orange"}
                ,{"blue"  , "orange", "red"    , "red"}
                ,{"orange", "orange", "red"    , "blue"}};

        int count =solution.solution(board, 1, 1);
        System.out.println(count);

        int count2 = solution.solution(new String[][]{
                  {"yellow", "green", "blue"}
                , {"blue", "green", "yellow"}
                , {"yellow", "blue", "blue"}
        }, 0, 1);

        System.out.println(count2);
    }

}
