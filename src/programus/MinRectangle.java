
import java.util.*;
import java.util.List;
public class MinRectangle {

    public int solution(int[][] sizes) {

        List<Integer> xList = new ArrayList<>();

        List<Integer> yList = new ArrayList<>();

        for (int i = 0; i < sizes.length; i++) {

            for (int j = 0; j < sizes[i].length; j++) {
                int max = Math.max(Math.max(sizes[i][j], sizes[i][0]),sizes[i][1]);
                int min =  Math.min(Math.min(sizes[i][j], sizes[i][0]),sizes[i][1]);
                xList.add(max);
                yList.add(min);
            }
        }

        Collections.sort(xList, Collections.reverseOrder());
        Collections.sort(yList, Collections.reverseOrder());
        return xList.get(0)*yList.get(0);
    }


    public static void main(String[] args) {
        MinRectangle minRectangle = new MinRectangle();
        minRectangle.solution(new int[][]{{60, 50}
                                        , {30, 70}
                                        , {60, 30}
                                        , {80, 40}});




        minRectangle.solution(new int[][]{{10, 7}
                                        , {12, 3}
                                        , {8, 15}
                                        , {14, 7}
                                        , {5, 15}});


        minRectangle.solution(new int[][]{{14, 4}
                                        , {19, 6}
                                        , {6, 16}
                                        , {18, 7}
                                        , {7, 11}});

    }

}
