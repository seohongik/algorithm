package easyspub.priorChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DFSVirus {


    /*
    7 6
    1 2
    2 3
    1 5
    5 2
    5 6
    4 7
    * */

    /*
    5 4
    1 2
    2 3
    3 4
    4 5
    * */
    private static ArrayList<Integer>[] A;
    private static boolean[] visited;
    private static int count=0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        A = new ArrayList[n+1];
        visited = new boolean[n+1];
        for (int i = 1; i <n+1; i++) { //0 부터 m가지 배열 만들고
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }

        System.out.println("Arrays.toString(A) = " + Arrays.toString(A));
        DFS(1);

        System.out.println("count = " + count);
    }

    private static void DFS(int v) {

        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int j : A[v]) {
            // 아직 방문하지 않은 이웃 노드가 있다면
            if (!visited[j]) {
                count++; // 바이러스 전파 카운트 증가
                DFS(j);  // 재귀 호출로 더 깊이 탐색
            }
        }
    }
}
