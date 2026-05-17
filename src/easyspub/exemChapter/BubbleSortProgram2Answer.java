package easyspub.exemChapter;

import java.io.*;
import java.util.*;

public class BubbleSortProgram2Answer {
    public static int[] A;
    public static int[] tmp;
    // ⚠️ Swap 횟수는 최대 N*(N-1)/2번까지 늘어날 수 있으므로 반드시 long을 써야 합니다.
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        tmp = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        result = 0;
        // 병합 정렬 수행 (시작 인덱스 1, 끝 인덱스 N)
        mergeSort(1, N);

        System.out.println(result);
    }

    private static void mergeSort(int s, int e) {
        if (e - s < 1) return;

        int m = s + (e - s) / 2;

        // 분할 (재귀 호출)
        mergeSort(s, m);
        mergeSort(m + 1, e);

        // 현재 구역을 임시 배열에 복사
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;
        int index1 = s;     // 왼쪽 그룹 시작점
        int index2 = m + 1; // 오른쪽 그룹 시작점

        // 병합 시작
        while (index1 <= m && index2 <= e) {
            if (tmp[index1] <= tmp[index2]) {
                A[k] = tmp[index1];
                index1++;
            } else {
                // ⚡ [핵심 치트키] 오른쪽 대원이 새치기해서 먼저 들어가는 순간!
                A[k] = tmp[index2];

                // 왼쪽 그룹에 아직 남아있는 대원 수만큼 Swap 횟수를 누적합니다.
                // 배열 기반 코드에서는 (중앙값 m - 현재 왼쪽 포인터 index1 + 1)이 남은 대원 수입니다.
                result += (m - index1 + 1);

                index2++;
            }
            k++;
        }

        // 남아있는 왼쪽 그룹 대원 마저 채우기
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
    }
}