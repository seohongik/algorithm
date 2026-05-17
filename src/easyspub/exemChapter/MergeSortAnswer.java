package easyspub.exemChapter;

import java.io.*;
import java.util.*;

public class MergeSortAnswer {
    // 매번 새로운 배열을 생성하면 메모리 초과/시간 초과가 나므로,
    // 전역에 임시 배열(tmp)을 한 번만 선언해서 돌려씁니다.
    public static int[] A;
    public static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        tmp = new int[N]; // 원본과 같은 크기로 임시 방 개설

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        // 병합 정렬 시작 (시작 인덱스 0부터 끝 인덱스 N-1까지)
        mergeSort(1, N);

        // 정답 출력 최적화
        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    // 1. 하청 주기 (반으로 쪼개는 분할 메서드)
    private static void mergeSort(int s, int e) {
        // 기저 조건: 데이터가 1개 이하면 더 이상 쪼갤 수 없음
        if (e - s < 1) return;

        int m = s + (e - s) / 2; // 중앙값 계산 (인덱스 오버플로우 방지 공식)

        // 재귀 호출로 왼쪽, 오른쪽을 낱개가 될 때까지 계속 쪼갬
        mergeSort(s, m);
        mergeSort(m + 1, e);

        // 2. 조립하기 (정렬하면서 합치는 병합 메서드)
        // 먼저 현재 구역(s부터 e까지)의 데이터를 임시 배열에 복사해둡니다.
        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }

        int k = s;      // 진짜 원본 배열(A)에 채워 넣을 포인터
        int index1 = s; // 왼쪽 그룹의 시작 포인터
        int index2 = m + 1; // 오른쪽 그룹의 시작 포인터

        // 두 그룹 다 대원이 남아있는 동안 대가리(?)끼리 비교하며 채우기
        while (index1 <= m && index2 <= e) {
            // 임시 배열에 복사해둔 값을 비교해서 작은 놈을 원본 배열(A)에 먼저 넣음
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                index2++; // 오른쪽 대원 골인했으니 다음 대원으로 이동
            } else {
                A[k] = tmp[index1];
                index1++; // 왼쪽 대원 골인했으니 다음 대원으로 이동
            }
            k++;
        }

        // 루프가 끝났는데 왼쪽 그룹에 대원이 남아있다면 마저 싹 털어 넣기
        while (index1 <= m) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        // (오른쪽 그룹이 남은 건 어차피 원래 원본 뒤쪽에 정렬되어 있던 상태라 따로 처리 안 해도 됩니다.)
    }
}