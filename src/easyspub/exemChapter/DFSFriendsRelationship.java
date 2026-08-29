package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
8 8
1 7
3 7
4 7
3 4
4 6
3 5
0 4
2 7
 */

/*

6 5
0 1
0 2
0 3
0 4
0 5
* */

public class DFSFriendsRelationship {
    static int n=0;
    static int m=0;
    static List<Integer>[] graph;
    static boolean[] visited;
    static boolean arrive;
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        graph= new ArrayList[n + 1];
        visited = new boolean[n + 1];
        arrive = false;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            DFS(i,1);
            if(arrive){
                break;
            }
        }
        if(arrive){
            System.out.println("1");
        }else {
            System.out.println("0");
        }

    }
    
    private static void DFS(int now,int depth) {

        if(depth==5||arrive){
            arrive=true;
            return;
        }
        visited[now]=true;
        for (int i :graph[now]) {
            if(!visited[i]){
                DFS(i,depth+1);
            }
        }
        visited[now]=false;
    }
}
