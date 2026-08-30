package easyspub.exemChapter;

import java.util.Scanner;

public class NQueenBackTracking {


    private static int[] chessBoard;
    private static int N;
    private static int answer;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        chessBoard = new int[N];
        backTracking(0);
        System.out.println("answer= " + answer);

    }

    private static void backTracking(int row) {
        if(row == N) {
            answer++;
            return;
        }
        boolean check = true;
        for(int i = 0; i < N; i++) {
            chessBoard[row] = i;
            for(int j = 0; j < row; j++) {

                /*가지치기 유효성 검사*/
                if(chessBoard[j] == chessBoard[row]) {/*직선공격*/
                    check = false;
                    break;
                }
                if(Math.abs(chessBoard[j] - chessBoard[row]) == Math.abs(row - j)) {/*대각선 공격*/
                    check = false;
                    break;
                }
                check=true;
            }
            if(check) {
                backTracking(row + 1);
            }
        }
    }
}
