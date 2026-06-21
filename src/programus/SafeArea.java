package programus;

public class SafeArea {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] newBoard = new int[board.length][board[0].length];

        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {

                if(board[i][j] == 1) {
                    newBoard[i][j] = 1;

                    // 상
                    if (i - 1 >= 0) {
                        newBoard[i-1][j] = 1;
                    }
                    // 하
                    if (i + 1 < newBoard.length) {
                        newBoard[i+1][j] = 1;
                    }
                    // 좌
                    if (j - 1 >= 0) {
                        newBoard[i][j-1] = 1;
                    }
                    // 우
                    if (j + 1 < newBoard[i].length) {
                        newBoard[i][j+1] = 1;
                    }

                    // 좌 대각선 하단
                    if (i + 1 < newBoard.length && j - 1 >= 0) {
                        newBoard[i+1][j-1] = 1;
                    }
                    // 우 대각선 하단
                    if (i + 1 < newBoard.length && j + 1 < newBoard[i].length) {
                        newBoard[i+1][j+1] = 1;
                    }
                    // 좌 대각선 상단
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        newBoard[i-1][j-1] = 1;
                    }
                    // 우 대각선 상단
                    if (i - 1 >= 0 && j + 1 < newBoard[i].length) {
                        newBoard[i-1][j+1] = 1;
                    }
                }
            }
        }
        for (int i = 0; i < newBoard.length; i++) {
            for (int j = 0; j < newBoard[i].length; j++) {
                if(newBoard[i][j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        SafeArea area = new SafeArea();

        System.out.println(area.solution(new int[][] {{0, 0, 0, 0, 0}
                                                    , {0, 0, 0, 0, 0}
                                                    , {0, 0, 0, 0, 0}
                                                    , {0, 0, 1, 0, 0}
                                                    , {0, 0, 0, 0, 0}}));

        System.out.println(area.solution(new int[][]{ {0, 0, 0, 0, 0}
                                                    , {0, 0, 0, 0, 0}
                                                    , {0, 0, 0, 0, 0}
                                                    , {0, 0, 1, 1, 0}
                                                    , {0, 0, 0, 0, 0}}));

        System.out.println(area.solution(new int[][]{ {1, 1, 1, 1, 1, 1}
                                                    , {1, 1, 1, 1, 1, 1}
                                                    , {1, 1, 1, 1, 1, 1}
                                                    , {1, 1, 1, 1, 1, 1}
                                                    , {1, 1, 1, 1, 1, 1}
                                                    , {1, 1, 1, 1, 1, 1}}));



        System.out.println(area.solution(new int[][] {{1, 0, 0, 0, 0}
                                                    , {0, 0, 0, 0, 0}
                                                    , {0, 0, 0, 0, 0}
                                                    , {0, 0, 0, 0, 0}
                                                    , {0, 0, 0, 0, 0}}));
    }
}
