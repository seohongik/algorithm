package easyspub.exemChapter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Random;

public class BentleyMcllroy3wayPartitioning {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {

        List<Integer> originalList = new ArrayList<>(List.of(10, 1, 444, 39, 11, 50));
        //List<Integer> originalList = new ArrayList<>(List.of(50, 10, 20));
        //List<Integer> originalList = new ArrayList<>(List.of(5, 1, 3, 5));

        // 아직 정렬되지 않은 구간을 {시작, 끝} 으로 담아둔다. (재귀 없이 반복문으로 처리)
        Deque<int[]> ranges = new ArrayDeque<>();
        if (originalList.size() > 1) {
            ranges.push(new int[]{0, originalList.size() - 1});
        }

        while (!ranges.isEmpty()) {
            int[] range = ranges.pop();
            int low = range[0];
            int high = range[1];

            // 원소가 0개나 1개면 이미 정렬된 것이므로 건너뛴다.
            if (low >= high) {
                continue;
            }

            // --- 해결법 ① : 무작위 3개 위치의 중앙값을 피벗 '값'으로 사용 ---
            int pivotValue = medianOfThree(originalList, low, high);

            // --- 해결법 ② : 3-way 파티션 ---
            // 스캔이 끝나면 구간이 이렇게 정리된다.
            //   [low, lt-1] : 피벗보다 작은 값
            //   [lt, gt]    : 피벗과 같은 값   <- 여기는 자리가 확정되어 다시 안 본다
            //   [gt+1, high]: 피벗보다 큰 값
            int lt = low;    // 작은 값 구역의 다음 자리
            int i = low;     // 현재 보고 있는 자리
            int gt = high;   // 큰 값 구역의 앞 자리

            while (i <= gt) {
                int compared = Integer.compare(originalList.get(i), pivotValue);
                if (compared < 0) {
                    Collections.swap(originalList, i, lt);
                    lt++;
                    i++;
                } else if (compared > 0) {
                    // 뒤에서 가져온 값은 아직 검사 전이므로 i 를 올리지 않는다.
                    Collections.swap(originalList, i, gt);
                    gt--;
                } else {
                    i++;
                }
            }

            System.out.println("originalList = " + originalList
                    + "  (피벗 " + pivotValue + " -> " + lt + "~" + gt + "번 자리 확정)");

            // --- 해결법 ③ : 큰 구간을 먼저 push (= 작은 구간이 먼저 pop 되어 처리됨) ---
            // 스택에 남는 구간이 항상 처리 중인 구간보다 크거나 같아져서 깊이가 O(log n)으로 묶인다.
            int leftSize = lt - low;      // [low, lt-1] 의 길이
            int rightSize = high - gt;    // [gt+1, high] 의 길이
            if (leftSize > rightSize) {
                ranges.push(new int[]{low, lt - 1});
                ranges.push(new int[]{gt + 1, high});
            } else {
                ranges.push(new int[]{gt + 1, high});
                ranges.push(new int[]{low, lt - 1});
            }
        }

        System.out.println("originalList = " + originalList);
    }

    /**
     * [해결법 ①] low~high 안에서 무작위로 세 자리를 골라 그 중앙값을 돌려준다.
     * 어떤 입력이 들어와도 피벗이 한쪽으로 치우칠 확률을 낮춰 O(n log n)을 유지시킨다.
     */
    private static int medianOfThree(List<Integer> list, int low, int high) {
        int length = high - low + 1;
        int a = list.get(low + RANDOM.nextInt(length));
        int b = list.get(low + RANDOM.nextInt(length));
        int c = list.get(low + RANDOM.nextInt(length));
        return Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
    }
}
