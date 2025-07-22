package inflearnBasic.ex60;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


// BFS 전 통과는 했으나 불완전한 정답
class Solution {

    public int solution(int my , int sheep) {

        int[] jumpable = {1,-1,5}; // 가능한 점프
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

        while (lt<=rt) {
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



// BFS
class Solution2 {

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


class Main{

    public static void main(String[] args){
        Solution sol = new Solution();
        Scanner sc = new Scanner(System.in);
        int result =  sol.solution(sc.nextInt(), sc.nextInt());
        System.out.println(result);
    }
}