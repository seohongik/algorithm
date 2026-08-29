package easyspub.exemChapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MakingSequence {

    static  int N;
    static  int M;
    private static boolean[] visited;
    private static int[] sequence;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N=scanner.nextInt();
        M=scanner.nextInt();
        sequence=new int[M];
        visited = new boolean[N];
        DFS(0);

    }
    private static void DFS(int v) {

        if(v == M){
            System.out.println("r = " + Arrays.toString(sequence));
            return;
        }

        for (int i=0; i<N; i++){
            if(!visited[i]) {
                visited[i] = true;
                sequence[v] = i+1;
                DFS(v+1);
                visited[i] = false;
            }
        }
    }
}
