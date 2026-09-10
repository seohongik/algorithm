package easyspub.exemChapter;

import java.util.*;

public class DFSAndBFS {
/*
4 5 1
1 2
1 3
1 4
2 4
3 4
* */
    private static int N;
    private static int M;
    private static int start;
    private static int[] A;
    private static List<Integer>[] lists;
    private static boolean[] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        start = in.nextInt();
        lists = new List[N+1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            lists[x].add(y);
            lists[y].add(x);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }
        System.out.println("인접 리스트 = " + Arrays.toString(lists));
        visited = new boolean[N+1];
        DFS(start);
        System.out.println();
        visited = new boolean[N+1];
        BFS(start);
        System.out.println();
        visited = new boolean[N+1];
        DFS2(start);
        System.out.println();
    }
    private static void DFS(int x) {
        System.out.print(x+" ");
        visited[x] = true;
        for (int y : lists[x]) {
            if(!visited[y]) {
                DFS(y);
            }
        }
    }
    private static void BFS(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now+" ");
            for (int y : lists[now]) {
                if(!visited[y]) {
                    visited[y] = true;
                    queue.add(y);
                }
            }
        }
    }

    private static void DFS2(int x) {
        Stack<Integer> stack = new Stack<>();
        stack.push(x);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            // 꺼낼 때 방문 체크
            if (!visited[now]) {
                visited[now] = true;
                System.out.print(now+" ");

                // 인접 노드를 스택에 추가
                for (int y : lists[now]) {
                    if (!visited[y]) {
                        stack.push(y);
                    }
                }
            }
        }
    }
}
