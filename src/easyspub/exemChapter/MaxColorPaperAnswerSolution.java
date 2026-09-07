package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class MaxColorPaperAnswerSolution {

    static int[][] M = new int[10][10];
    // 색종이 개수 (1×1 ~ 5×5)
    static int[] paper = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backtracking(0, 0, 0);

        if (result == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }

    private static void backtracking(int x, int y, int useCount) {
        // 가지치기: 현재 사용량이 이미 최솟값 이상이면 더 볼 필요 없음
        if (useCount >= result) {
            return;
        }

        // 행을 다 탐색했으면 종료
        if (x >= 10) {
            result = Math.min(result, useCount);
            return;
        }

        // 열을 다 탐색했으면 다음 행으로 이동
        if (y >= 10) {
            backtracking(x + 1, 0, useCount);
            return;
        }

        // 현재 칸이 1인 경우
        if (M[x][y] == 1) {
            // 큰 색종이(5x5)부터 작은 색종이(1x1) 순으로 시도
            for (int size = 5; size >= 1; size--) {
                if (paper[size] > 0 && canAttach(x, y, size)) {
                    attach(x, y, size, 0); // 색종이 붙이기
                    paper[size]--;

                    backtracking(x, y + size, useCount + 1); // 다음 위치 탐색 안겹치게 하려고

                    attach(x, y, size, 1); // 원상복구 (백트래킹)
                    paper[size]++;
                }
            }
        } else {
            // 현재 칸이 0이면 오른쪽으로 이동
            backtracking(x, y + 1, useCount);
        }
    }

    // size x size 크기의 색종이를 붙일 수 있는지 확인
    private static boolean canAttach(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (M[i][j] != 1) return false;
            }
        }
        return true;
    }

    // 색종이를 붙이거나(val=0) 떼는(val=1) 함수
    private static void attach(int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                M[i][j] = val;
            }
        }
    }
}
