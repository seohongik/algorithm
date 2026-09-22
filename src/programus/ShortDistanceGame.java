package programus;

import java.util.LinkedList;
import java.util.Queue;

public class ShortDistanceGame {

    private static class Node {
        int x;
        int y;
        int count;

        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

    }

    int[] x={-1,1,0,0};
    int[] y={0,0,-1,1};

    public int solution(int[][] maps) {
        return bfs(maps.length, maps[maps.length-1].length, maps);
    }

    private int bfs(int N,int M,int[][] maps){

        boolean[][] visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList<>();

        visited[0][0]=true;
        queue.offer(new Node(0,0,1));

        while (!queue.isEmpty()){
            Node curr = queue.poll();
            int r = curr.x;
            int c = curr.y;

            // 상대 팀 진영(목적지) 도착 시 거리 반환
            if (r == N - 1 && c == M - 1) {
                return curr.count;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + x[i];
                int nc = c + y[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (maps[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        queue.offer(new Node(nr, nc, curr.count + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][][] testCases = {
                {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}, // 11
                {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1}}, // -1
                {{1}}, // 1
                {{1,0},{0,1}}, // -1
                {{1, 1, 1, 1, 1}}, // 5
                {{1}, {1}, {1}, {1}, {1}}, // 5
                {{1, 1, 1, 1}, {0, 0, 0, 1}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 1, 1, 1}} // 13
        };

        int[] expectedResults = {11, -1, 1, -1, 5, 5, 13};

        ShortDistanceGame sol = new ShortDistanceGame();

        for (int i = 0; i < testCases.length; i++) {
            int result = sol.solution(testCases[i]);
            System.out.println("Test Case " + (i + 1) + ": " +
                    (result == expectedResults[i] ? "Pass" : "Fail (Expected " + expectedResults[i] + ", Got " + result + ")"));
        }
    }
}
