package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*

18
1
-1
0
0
0
1
1
-1
-1
2
-2
0
0
0
0
0
0
0


* */
public class QueueAbsHeap {
    public static void main(String[] args) throws IOException {

        mySolution();

    }

    private static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 최적화

        int N = Integer.parseInt(br.readLine());

        // 람다식을 이용한 간결한 우선순위 설정
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return Integer.compare(o1, o2); // 절댓값이 같으면 실제 값이 작은 순
            }
            return Integer.compare(abs1, abs2); // 절댓값이 작은 순
        });

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x != 0) {
                heap.add(x);
            } else {
                if (heap.isEmpty()) {
                    sb.append("0\n");
                } else {
                    sb.append(heap.poll()).append("\n");
                }
            }
        }
        System.out.print(sb.toString());
    }

}
