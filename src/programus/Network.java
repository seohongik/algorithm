package programus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Network {

    public int solution(int n, int[][] computers) {

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                graph[i].add(computers[i][j]);
            }
        }
        boolean[] visited = new boolean[graph.length];
        int answer = 0;

        /*
        // 모든 컴퓨터를 하나씩 확인합니다.
        for (int i = 0; i < n; i++) {
            // 아직 방문하지 않은 컴퓨터를 발견했다면?
            if (!visited[i]) {
                // 새로운 네트워크를 찾은 것이니 카운트 증가!
                answer++;
                // 이 컴퓨터와 연결된 모든 친구들을 '방문 완료' 처리하러 떠납니다.
                dfs(i, graph, n, visited);
            }
        }*/

        for (int i = 0; i < graph.length; i++) {
            // 아직 방문하지 않은 컴퓨터를 발견했다면?
            if (!visited[i]) {;
                // 새로운 네트워크를 찾은 것이니 카운트 증가!
                answer++;
                // 이 컴퓨터와 연결된 모든 친구들을 '방문 완료' 처리하러 떠납니다.
                dfs2(i, n, computers, visited);
            }
        }

        return answer;

    }

    void dfs(int start, List<Integer>[] graph,int n, boolean[] visited) {

        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                for (int i = 0; i < n; i++) {
                    // i번 컴퓨터와 j번 컴퓨터가 연결되어 있고(1), 아직 방문하지 않았다면
                    if (graph[node].get(i) == 1 && !visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }

    // "나랑 연결된 친구들 다 방문표시 해!"라고 시키는 함수
    void dfs2(int current, int n, int[][] computers, boolean[] visited) {
        visited[current] = true; // 일단 나 방문했어!

        for (int i = 0; i < n; i++) {
            // 1. 나랑 연결되어 있고(1)  2. 아직 방문 안 한 친구라면?
            if (computers[current][i] == 1 && !visited[i]) {
                dfs2(i, n, computers, visited); // 그 친구한테 가서 똑같이 하라고 함 (재귀)
            }
        }
    }

    public static void main(String[] args) {
        Network network = new Network();
        int cnt=network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        System.out.println("cnt  "+cnt);
        System.out.println();
       /* int cnt2=network.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        System.out.println("cnt2  "+cnt2);*/
    }
}
