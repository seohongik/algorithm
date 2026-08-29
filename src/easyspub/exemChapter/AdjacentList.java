package easyspub.exemChapter;

import java.util.*;

/*

6 5
1 2
2 5
5 1
3 4
4 6

* */

public class AdjacentList {
    static int n;
    static int m;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new List[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }

    static private void DFS(int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        for (int u : list[v]) {
            if (!visited[u]) {
                DFS(u);
            }
        }
    }
}
