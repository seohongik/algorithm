package programus;

import java.util.*;

public class BridgeTruck {
    public  int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> passenger = new ArrayDeque<>(); // 다리 위 트럭
        int idx = 0;                                   // 다음 대기 트럭 인덱스
        int currentWeight = 0;                         // 다리 위 총 무게
        int time = 0;

        // 다리 초기화: 길이만큼 0으로 채움
        for (int i = 0; i < bridge_length; i++) {
            passenger.addLast(0);
        }

        while (!passenger.isEmpty()) {
            time++;

            int out = passenger.removeFirst();
            currentWeight -= out;

            if (idx < truck_weights.length) {
                if (currentWeight + truck_weights[idx] <= weight) {
                    passenger.addLast(truck_weights[idx]); // 트럭 진입
                    currentWeight += truck_weights[idx];
                    idx++;
                } else {
                    passenger.addLast(0); // 못 올리면 빈칸
                }
            }
        }

        return time;
    }

    public static void main(String[] args) {
        BridgeTruck bridgeTruck = new BridgeTruck();
        System.out.println(bridgeTruck.solution(2, 10, new int[]{7,4,5,6}));
        System.out.println(bridgeTruck.solution(100, 100, new int[]{10}));
        System.out.println(bridgeTruck.solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }

}
