package easyspub.exemChapter;

import java.util.*;

public class BentleyMcllroy3wayPartitioningBasic {
    public static void main(String[] args) {

        //List<Integer> originalList = new ArrayList<>(List.of(10, 1, 444, 39, 11, 50));
        //List<Integer> originalList = new ArrayList<>(List.of(50, 10, 20,50,50,50,50,30,100));
        List<Integer> originalList = new ArrayList<>(List.of(5, 1, 3, 2));
        sort(originalList);
    }


    private static List<Integer> sort(List<Integer> originalList) {
        Deque<int[]> ranges = new ArrayDeque<>();
        ranges.push(new int[]{0, originalList.size() - 1});

        while (!ranges.isEmpty()) {
            int[] range = ranges.pop();
            int low = range[0], high = range[1];
            if (low >= high) continue;          // 원소 0~1개면 이미 정렬됨

            int pivotValue = originalList.get(high);   // 인덱스가 아니라 '값'
            int startIndex = low;
            int endIndex = high - 1;

            while (startIndex <= endIndex) {
                if (originalList.get(startIndex) < pivotValue) {
                    startIndex++;
                } else if (originalList.get(endIndex) >= pivotValue) {
                    endIndex--;
                } else {
                    // 왼쪽에 큰 값 + 오른쪽에 작은 값이 동시에 걸렸을 때만 교환
                    Collections.swap(originalList, startIndex, endIndex);
                    startIndex++;
                    endIndex--;
                }
            }
            Collections.swap(originalList, startIndex, high);  // 피벗 자리 확정
            int pivotIndex = startIndex;

            ranges.push(new int[]{low, pivotIndex - 1});       // 왼쪽
            ranges.push(new int[]{pivotIndex + 1, high});      // 오른쪽 ← 원본에 없던 부분
        }

        System.out.println("originalList = " + originalList);
        return originalList;
    }
}
