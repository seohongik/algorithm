package programus;

import java.util.*;

public class ParkWalk {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;         // 공원의 세로 길이 (행의 개수)
        int W = park[0].length();    // 공원의 가로 길이 (열의 개수)

        int current_x = -1; // 현재 행 인덱스
        int current_y = -1; // 현재 열 인덱스

        // 1. 시작점 'S' 찾기
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    current_x = i;
                    current_y = j;
                    break; // 'S'를 찾으면 내부 루프 종료
                }
            }
            if (current_x != -1) {
                break; // 'S'를 찾았으므로 외부 루프 종료
            }
        }

        // 2. 경로(routes) 처리
        for (String route : routes) {
            String[] parts = route.split(" ");
            String direction = parts[0]; // 방향 (N, S, W, E)
            int steps = Integer.parseInt(parts[1]); // 이동 칸 수

            int dx = 0; // x축 (행) 변화량
            int dy = 0; // y축 (열) 변화량

            switch (direction) {
                case "N": dx = -1; break; // 위로 (행 감소)
                case "S": dx = 1; break;  // 아래로 (행 증가)
                case "W": dy = -1; break; // 왼쪽으로 (열 감소)
                case "E": dy = 1; break;  // 오른쪽으로 (열 증가)
            }

            int next_x = current_x + dx * steps; // 최종 도착 예상 행
            int next_y = current_y + dy * steps; // 최종 도착 예상 열

            boolean canMove = true; // 이동 가능 여부

            // 2-1. 경계 이탈 검사 (최종 도착점만 확인)
            if (next_x < 0 || next_x >= H || next_y < 0 || next_y >= W) {
                canMove = false;
            }

            // 2-2. 경로 내 장애물 'X' 검사 (경계 안에 있을 경우에만)
            if (canMove) {
                int temp_x = current_x;
                int temp_y = current_y;

                // 1칸씩 이동하며 경로를 검사
                for (int i = 0; i < steps; i++) {
                    temp_x += dx;
                    temp_y += dy;

                    // 이동하는 중간 경로에 장애물('X')이 있는지 확인
                    if (park[temp_x].charAt(temp_y) == 'X') {
                        canMove = false;
                        break; // 장애물 발견 시 즉시 반복 중단
                    }
                }
            }

            // 3. 이동 적용
            if (canMove) {
                // 전체 경로가 유효할 경우에만 위치 업데이트
                current_x = next_x;
                current_y = next_y;
            }
            // canMove가 false이면, current_x와 current_y는 그대로 유지되어 해당 명령이 무시됨
        }

        // 4. 최종 위치 반환
        return new int[]{current_x, current_y};
    }
}