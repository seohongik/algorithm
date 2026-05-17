package easyspub.exemChapter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSortKAnswer2 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // K번째 수는 인덱스로 따지면 K-1 번째입니다.
        quickSelect(A, 0, N - 1, K - 1);

        System.out.println(A[K - 1]);
    }

    public static void quickSelect(int[] A, int S, int E, int K) {
        if (S < E) {
            int pivot = partition(A, S, E);

            if (pivot == K) {
                // 구하고자 하는 K번째 인덱스가 피벗과 일치하면 종료
                return;
            } else if (K < pivot) {
                // 구하고자 하는 K가 피벗보다 왼쪽에 있으면 왼쪽 그룹만 탐색
                quickSelect(A, S, pivot - 1, K);
            } else {
                // 구하고자 하는 K가 피벗보다 오른쪽에 있으면 오른쪽 그룹만 탐색
                quickSelect(A, pivot + 1, E, K);
            }
        }
    }

    public static int partition(int[] A, int S, int E) {
        if (S + 1 == E) {
            if (A[S] > A[E]) swap(A, S, E);
            return E;
        }

        // 중앙값을 피벗으로 설정 (최악의 경우인 O(N^2)을 피하기 위한 팁)
        int M = (S + E) / 2;
        swap(A, S, M); // 중앙값을 맨 앞으로 이동
        int pivot = A[S];

        int i = S + 1;
        int j = E;

        while (i <= j) {
            // 피벗보다 큰 수를 만날 때까지 i 증가
            while (j >= S + 1 && pivot < A[j]) {
                j--;
            }
            // 피벗보다 작은 수를 만날 때까지 j 감소
            while (i <= E && pivot > A[i]) {
                i++;
            }
            if (i <= j) {
                swap(A, i++, j--);
            }
        }

        // 피벗 데이터를 알맞은 위치로 이동
        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
