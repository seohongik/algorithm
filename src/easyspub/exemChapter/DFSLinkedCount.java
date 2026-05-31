package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFSLinkedCount {

    /*
    *
    6 5
    1 2
    2 5
    5 1
    3 4
    4 6
    * */

    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        System.out.println("A = " + Arrays.toString(A));

        int count =0;
        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println("count = " + count);
    }

    private static void dfs(int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (Integer i : A[v]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

}
