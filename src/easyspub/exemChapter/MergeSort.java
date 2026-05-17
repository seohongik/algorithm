package easyspub.exemChapter;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("정렬 전: " + Arrays.toString(arr));

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("정렬 후: " + Arrays.toString(arr));
    }

    // 1. 반으로 쪼개는 메서드 (재귀)
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2; // 정중앙 인덱스 구하기

            mergeSort(arr, left, mid);      // 왼쪽 반 쪼개기
            mergeSort(arr, mid + 1, right); // 오른쪽 반 쪼개기

            merge(arr, left, mid, right);   // 쪼갠 두 동네를 정렬하며 합치기
        }
    }

    // 2. 두 동네의 맨 앞줄끼리 비교하며 합치는 메서드
    private static void merge(int[] arr, int left, int mid, int right) {
        // 원래 데이터를 임시로 복사해둘 임시 방(배열) 생성
        int[] temp = new int[arr.length];
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;    // 왼쪽 동네 출발선
        int j = mid + 1; // 오른쪽 동네 출발선
        int k = left;    // 채워 넣을 진짜 배열의 인덱스

        // 두 동네 다 대원이 남아있을 때 동안 비교하며 채우기
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) { // 왼쪽 대원이 더 작거나 같으면
                arr[k] = temp[i];     // 새 방에 왼쪽 대원 골인
                i++;
            } else {                  // 오른쪽 대원이 더 작으면
                arr[k] = temp[j];     // 새 방에 오른쪽 대원 골인
                j++;
            }
            k++;
        }

        // 왼쪽 동네에 대원이 남았다면 싹 다 털어 넣기
        // (오른쪽 동네가 남은 건 원래 원본 뒤쪽에 퍼져있으므로 처리할 필요 없음)
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}
