package easyspub.exemChapter;

import java.util.Arrays;

public class QuickSortSwap {
    public static void main(String[] args) {
        int[] arr = {42, 32, 10, 5, 45, 3, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // [1] 맨 오른쪽 원소(8)를 피벗으로 설정
            int pivot = arr[high];

            // [2] i는 작은 값 구역의 경계선 (처음엔 아무것도 없으니 low - 1)
            int i = low - 1;

            // [3] j 대원이 출발해서 피벗(8)과 하나씩 비교
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) { // 피벗(8)보다 작은 놈을 발견하면!
                    i++; // 1. 작은 놈 구역을 한 칸 넓히고

                    // 2. 그 자리에 있던 큰 놈과 방금 발견한 작은 놈을 바꾼다(Swap)!
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            // [4] j가 끝까지 돌면, 피벗(8)을 작은 놈 구역 바로 다음 칸(i + 1)과 바꾼다.
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;

            // [5] 피벗의 최종 위치 결정
            int pivotIndex = i + 1;

            // [6] 피벗 중심 왼쪽과 오른쪽을 다시 쪼개서 정렬
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
}