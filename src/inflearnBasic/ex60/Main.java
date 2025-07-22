package inflearnBasic.ex60;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// BFS 전 통과는 했으나 불완전한 정답
class Solution {

    int[] jumpable = {1, -1, 5}; // 가능한 점프
    public int solution(int my , int sheep) {

        int count = 0;
        int lt = Math.min(my, sheep);
        int rt1= sheep;
        int rt2= sheep;

        if(my>sheep){
            return Math.abs(sheep - my); // 만약 양이 뒤에 있다면 -1 점프 밖에 안되니까 두사이의 거리의 절대값
        }

        while (rt1%10!=0){
            rt1++;
        }

        while (rt2%10!=0){
            rt2--;
        }
        int dist1 = rt1 - sheep;
        int dist2 = sheep - rt2;

        int rt = dist1>=dist2?rt2:rt1 ; // 5씩 계산할거니까 가장 양과의 거리에서 가까운쪽 택

        while (lt<rt) {
            if(my<sheep) {
                rt -= jumpable[2];
            }
            count++;
        }// 5씩 계산 양과의 거리 좁히기

        int dif =(lt-rt); // 최종 양과의 양이 나를 넘어선 거리를 구한다
        int dis = Math.min(dist1, dist2); // sheep 위치에서 가장 가까운 10의 배수까지의 거리 중 더 짧은 값 선택
        for (int i=dif; i<dis; i++){ //남은 거리 계산
            count++;
        }
        return count;
    }
}

//BFS 인공지는 결과
class Solution1 {

    public int solution(int my, int sheep) {
        int[] moves = {1, -1, 5};
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

                for (int move : moves) {
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

//BFS 안썼지만 이게 더 직관적 하지만 점프어블에 종속적

/*
1. 최소 점프 횟수를 보장하지 않음
예: my = 5, sheep = 14

가능한 경로: 5 -> 10 -> 11 -> 12 -> 13 -> 14 (5 + 1 + 1 + 1 + 1 = 5점프)

더 좋은 경로: 5 -> 6 -> 11 -> 12 -> 13 -> 14 or 5 -> 10 -> 15 -> 14 등

즉, 단순히 5씩 점프하는 방식은 최적 경로를 보장하지 않음.

2. (sheep - my) % jumpable[2] - 1 이 위험함
이 계산이 음수가 될 수 있음.

예: my = 1, sheep = 6 → (6 - 1) % 5 - 1 = 0 - 1 = -1

결국 count + -1이 되어 정답보다 작을 수 있음.
* */


class Solution3{
    int[] jumpable = {1,-1,5}; // 가능한 점프

    public int solution(int my, int sheep) {

        if(my>sheep){
            return Math.abs(sheep - my); // 만약 양이 뒤에 있다면 -1 점프 밖에 안되니까 두사이의 거리의 절대값
        }
        int count = 0;
        for (int i =my; i<=sheep; i+=jumpable[2]){ // 5씩 점프
            count++;
        }
        return count+((sheep-my)%jumpable[2])-1;
    }

}


class Main{

    public static void main(String[] args){
        int result = 0;
        Scanner sc = new Scanner(System.in);
        int my = sc.nextInt();
        int sheep = sc.nextInt();
        Solution3 sol3 = new Solution3();
        result = sol3.solution(my,sheep);
        System.out.println("result = " + result);
        System.out.println(" =============== END SOL3");
    }
}