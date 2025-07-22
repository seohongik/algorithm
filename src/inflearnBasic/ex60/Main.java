package inflearnBasic.ex60;

import javax.imageio.ImageTypeSpecifier;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


//BFS 인공지능 결과
class Solution1 {
    int[] jumpable = {2, -2, 5};
    public int solution(int my, int sheep) {

        boolean[] visited = new boolean[10001]; // 문제 조건 상 최대 범위 충분히 커버
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(my);
        visited[my] = true;

        int level = 0; // 이동 횟수

        while (!queue.isEmpty()) {
            int size = queue.size();

            // 현재 level의 모든 위치 탐색
            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == sheep) {
                    return level; // 목표에 도달하면 이동 횟수 반환
                }

                for (int move : jumpable) {
                    int next = current + move;
                    if (next >= 0 && next <= 10000 && !visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }

            level++; // 한 단계(1 move set) 증가
        }

        return -1; // 도달할 수 없는 경우 (이론상은 없음)
    }
}




// BFS 해답지
class Solution2 {
    int answer = 0;
    int[] dis = {1, -1, 5};
    int[] ch;
    Queue<Integer> Q = new LinkedList<>();
    public int solution(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        Q.offer(s);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (nx == e) {
                        return L + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
}


class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Solution1 solution = new Solution1();
        int result=solution.solution(sc.nextInt(), sc.nextInt());
        System.out.println("result = " + result);
    }
}