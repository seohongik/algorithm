package easyspub.exemChapter;

import java.io.*;

public class RadixSortAnswer {

    public static int[] A;
    public static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        br.close();

        // 기수 정렬 수행 (최대 5 자릿수이므로 5를 전달)
        Radix_Sort(A, 5);

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    // 기수 정렬 알고리즘 함수
    public static void Radix_Sort(int[] A, int max_size) {
        int[] output = new int[A.length]; // 정렬된 결과를 임시로 담을 배열
        int jarisu = 1;                  // 현재 정렬할 자릿수 (1의 자리, 10의 자리...)
        int count = 0;

        // 최대 자릿수만큼 루프를 돕니다 (10,000은 5자리)
        while (count < max_size) {
            int[] bucket = new int[10]; // 10진수이므로 0~9까지의 바구니 개수 세기용 배열

            // 1. 현재 자릿수를 기준으로 각 숫자의 빈도수 계산
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / jarisu) % 10]++;
            }

            // 2. 합배열(누적 합) 만들기 : 안정 정렬(Stable Sort)의 핵심 인덱스 계산
            for (int i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            // 3. 뒤에서부터 순회하며 누적 합 배열을 이용해 정렬된 위치에 데이터 배치
            for (int i = A.length - 1; i >= 0; i--) {
                output[bucket[(A[i] / jarisu) % 10] - 1] = A[i];
                bucket[(A[i] / jarisu) % 10]--;
            }

            // 4. 임시 배열(output)의 결과를 원본 배열(A)로 복사
            for (int i = 0; i < A.length; i++) {
                A[i] = output[i];
            }

            // 다음 자릿수로 이동 (1 -> 10 -> 100 -> 1000 -> 10000)
            jarisu = jarisu * 10;
            count++;
        }
    }
}
