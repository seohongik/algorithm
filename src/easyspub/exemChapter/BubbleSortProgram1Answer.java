package easyspub.exemChapter;


import java.io.*;
import java.util.*;

public class BubbleSortProgram1Answer {
    public static void main(String[] args) throws IOException {
        // Scanner보다 빠른 BufferedReader 사용 (데이터가 많을 때 필수)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Data[] arr = new Data[n];
        for (int i = 0; i < n; i++) {
            // 값과 원래 위치(index)를 함께 저장
            arr[i] = new Data(Integer.parseInt(br.readLine()), i);
        }

        // 1. 값(value)을 기준으로 오름차순 정렬
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int max = 0;
        for (int i = 0; i < n; i++) {
            // 2. 원래 인덱스 - 정렬 후 인덱스 (왼쪽으로 이동한 거리)
            // i는 정렬 후의 인덱스가 됩니다.
            int sortedAfter = arr[i].index;
            int sortedBefore = i;
            if (max < sortedAfter - sortedBefore) { // 4 0 1 2 3
                max = sortedAfter - sortedBefore;
            }
        }

        // 3. 최댓값 + 1 출력 (정렬 완료 확인을 위한 마지막 1회전 포함)
        System.out.println(max + 1);
    }

    // 값과 원래 위치를 기억하기 위한 클래스
    static class Data implements Comparable<Data> {
        int value;
        int index;

        public Data(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Data o) {
            // 값 기준 오름차순 정렬
            if (this.value == o.value) {
                return this.index - o.index; // 값이 같으면 원래 앞에 있던 것 우선 (안정 정렬)
            }
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "value=" + value +
                    ", index=" + index +
                    '}';
        }
    }
}