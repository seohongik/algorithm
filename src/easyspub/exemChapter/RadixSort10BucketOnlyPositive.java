package easyspub.exemChapter;

import java.util.*;

public class RadixSort10BucketOnlyPositive {
    public static void main(String[] args) {
        // 0번~9번 큐 10개 (index = 그 자릿수의 숫자)
        List<Queue<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new LinkedList<>());
        }

        List<Integer> originalList = new ArrayList<>(List.of(10, 1, 444, 39, 11, 50));

        int maxValue = Collections.max(originalList);   // 가장 큰 값의 자릿수만큼만 돌면 됨

// exp = 1(일의 자리) → 10(십의 자리) → 100(백의 자리) ...
        for (int exp = 1; maxValue / exp > 0; exp *= 10) {

            // ① 분배 : 현재 자릿수 숫자에 맞는 큐에 넣는다
            for (int value : originalList) {
                int digit = (value / exp) % 10;
                buckets.get(digit).offer(value);
            }

            // ② 수집 : 0번 큐부터 순서대로 전부 꺼내 원래 자리에 덮어쓴다
            int index = 0;
            for (Queue<Integer> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    originalList.set(index, bucket.poll());
                    index++;
                }
            }
        }
    }
}
