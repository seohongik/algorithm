package easyspub.exemChapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RadixSortBucketPositiveAndNegative {
    public static void main(String[] args) {

        List<Integer> originalList = new ArrayList<>(List.of(170, -45, 75, -90, 802, 24, -2, 66, 0));

        // ① 음수 / 0 이상 분리   (음수는 절댓값으로 저장)
        List<Long> negatives = new ArrayList<>();
        List<Long> positives = new ArrayList<>();
        for (int value : originalList) {
            if (value < 0) {
                negatives.add(-(long) value);   // -45 -> 45
            } else {
                positives.add((long) value);
            }
        }

        // ③ 그룹별로 각각 기수정렬 (둘 다 0 이상이므로 그냥 돌리면 된다)
        radixSort(negatives, "음수(절댓값)");
        radixSort(positives, "0 이상");

        // ④ 합치기
        int index = 0;
        // 음수: 절댓값이 큰 것부터(= 뒤에서부터) 꺼내고 부호를 되돌린다
        for (int i = negatives.size() - 1; i >= 0; i--) {
            originalList.set(index, (int) -negatives.get(i));
            index++;
        }
        // 0 이상: 그대로 이어 붙인다
        for (long value : positives) {
            originalList.set(index, (int) value);
            index++;
        }

        System.out.println("originalList = " + originalList);
    }

    /**
     * 0 이상의 값들을 0~9 큐 10개로 기수정렬한다.
     *
     * 값끼리 비교하지 않고, "일의 자리 -> 십의 자리 -> 백의 자리" 순으로
     *   ① 분배 : 그 자릿수 숫자(0~9)에 해당하는 큐에 넣고
     *   ② 수집 : 0번 큐부터 순서대로 다시 꺼내온다
     * 이걸 가장 큰 수의 자릿수만큼 반복하면 정렬이 끝난다.
     *
     * 큐(FIFO)를 쓰는 게 핵심이다. 먼저 넣은 게 먼저 나오므로 앞 단계에서 맞춰둔
     * 순서가 그대로 보존된다. (스택으로 하면 순서가 뒤집혀서 정렬이 깨진다)
     */
    private static void radixSort(List<Long> list, String label) {

        // 빈 그룹이면 Collections.max 에서 예외가 나므로 먼저 걸러낸다.
        // (입력이 전부 양수거나 전부 음수면 한쪽 그룹은 비어 있다)
        if (list.isEmpty()) {
            return;
        }

        // 0번~9번 큐 10개를 만든다. (index = 그 자릿수의 숫자)
        List<Queue<Long>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new LinkedList<>());
        }

        // 가장 큰 값의 자릿수만큼만 돌면 된다. (802 면 3번)
        long maxValue = Collections.max(list);

        // exp = 1(일의 자리) -> 10(십의 자리) -> 100(백의 자리) ...
        // exp 가 long 인 이유: int 면 10억을 넘길 때 오버플로로 무한루프가 된다.
        for (long exp = 1; maxValue / exp > 0; exp *= 10) {

            // ① 분배 : 현재 자릿수 숫자에 맞는 큐에 넣는다
            for (long value : list) {
                int digit = (int) ((value / exp) % 10);
                buckets.get(digit).offer(value);
            }

            // ② 수집 : 0번 큐부터 순서대로 전부 꺼내 원래 자리에 덮어쓴다
            int index = 0;
            for (Queue<Long> bucket : buckets) {
                while (!bucket.isEmpty()) {
                    list.set(index, bucket.poll());
                    index++;
                }
            }

            System.out.println("[" + label + "] " + exp + "의 자리 기준 정렬 후 = " + list);
        }
    }
}