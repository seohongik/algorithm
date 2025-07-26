package inflearnBasic.ex63;

import java.util.*;

/*

5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5


* */

//GRAPH
class Solution {

    int end=0;
    int m=0;
    int answer = 0;
    boolean[] visited;
    int[][] graph;

    public int solution(int start) {


        /*  0  1  2  3  4  5
        0  [0, 0, 0, 0, 0, 0],
        1  [0, 0, 1, 1, 1, 0],
        2  [0, 1, 0, 1, 0, 1],
        3  [0, 0, 0, 0, 1, 0],
        4  [0, 0, 1, 0, 0, 1],
        5  [0, 0, 0, 0, 0, 0]
         */

        /*
        1 -> 2 -> 3 -> 4 -> 5
        1 -> 2 -> 5
        1 -> 3 -> 4 -> 2 -> 5
        1 -> 3 -> 4 -> 5
        1 -> 4- > 2 -> 5
        1 -> 4 -> 5
        */

        if(start==end) answer++;
        else{
            for(int i=1; i<=end; i++){
                if(graph[start][i]==1 && !visited[i]){
                    visited[i]=true;
                    solution(i);
                    visited[i]=false;
                }
            }
        }


        return answer;
    }

}


class Main{



    public static void main(String[] args){ // 예상결과 2

        Solution sol = new Solution();
        Scanner kb = new Scanner(System.in);
        sol.end=kb.nextInt();
        sol.m=kb.nextInt();
        sol.graph=new int[sol.end+1][sol.end+1];
        sol.visited=new boolean[sol.end+1];
        for(int i=0; i<sol.m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            sol.graph[a][b]=1;
        }
        sol.visited[1]=true;
        sol.solution( 1);
        System.out.println(sol.answer);
        
    }
}