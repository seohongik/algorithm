package programus;


public class TableSum {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            int[] col1 = new int[arr1[0].length];
            for (int j = 0; j < arr1[i].length; j++) {
                col1[j]=(arr1[i][j] + arr2[i][j]);
            }

            answer[i]=col1;
        }

        return answer;
    }

    public static void main(String[] args) {
        TableSum tableSum = new TableSum();
        tableSum.solution(new int [][]{{1,2},{2,3}}, new int [][]{{3,4},{5,6}});
        tableSum.solution(new int [][]{{1},{2}}, new int [][]{{3},{4}});
    }
}
