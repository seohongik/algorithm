package easyspub.exemChapter;

import java.io.*;
import java.util.*;

public class QuickSortKAnswer {

    public static void main(String[] args) throws IOException {
        // 데이터가 많으므로 Scanner 대신 BufferedReader 사용 권장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 우리가 찾고 싶은 순서 (1번째, 2번째...)

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 처음엔 무조건 전체 범위(0 ~ N-1) 대원을 다 소집해야 합니다!
        // 구하고자 하는 인덱스는 K - 1 입니다.
        quickSelect(array, 0, N - 1, K - 1);

        System.out.println(array[K - 1]);
    }

    private static void quickSelect(int[] array, int left, int right, int K) {
        if (left < right) {
            // [피벗 분리수거 로직 - 기존과 동일]
            int pivot = array[right];
            int i = left - 1;
            for (int j = left; j < right; j++) {
                if (array[j] <= pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            int temp = array[i + 1];
            array[i + 1] = array[right];
            array[right] = temp;

            int pivotIndex = i + 1; // 피벗의 최종 절대 위치 결정!

            // --- [여기서부터 퀵 선택의 핵심 치트키] ---
            if (pivotIndex == K) {
                // 대박! 피벗의 위치가 딱 우리가 찾던 K번째 인덱스라면 정렬을 즉시 종료합니다.
                return;
            } else if (K < pivotIndex) {
                // 우리가 찾고 싶은 K가 피벗보다 왼쪽에 있다면, 왼쪽 동네만 정렬하러 갑니다.
                quickSelect(array, left, pivotIndex - 1, K);
            } else {
                // 우리가 찾고 싶은 K가 피벗보다 오른쪽에 있다면, 오른쪽 동네만 정렬하러 갑니다.
                quickSelect(array, pivotIndex + 1, right, K);
            }
        }
    }
}
