package easyspub.exemChapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryRadixSortUniversal {
    public static void radixSortBinaryAll(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        // 자바의 int는 32비트(0번째부터 31번째 비트까지) 고정이므로
        // 음수와 양수를 모두 아우르기 위해 32번의 루프를 고정으로 돕니다.
        for (int bit = 0; bit < 32; bit++) {
            List<Integer> bucket0 = new ArrayList<>();
            List<Integer> bucket1 = new ArrayList<>();

            for (int num : arr) {
                if (((num >> bit) & 1) == 0) {
                    bucket0.add(num);
                } else {
                    bucket1.add(num);
                }
            }

            int index = 0;

            // 🔥 [핵심 치트키] 맨 마지막 31번째 비트(부호 비트)를 정렬할 때만 순서를 뒤집습니다!
            if (bit == 31) {
                // 부호 비트가 1인 음수들(bucket1)이 수학적으로 더 작으므로 앞으로 와야 합니다.
                for (int num : bucket1) arr[index++] = num;
                for (int num : bucket0) arr[index++] = num;
            } else {
                // 0번째부터 30번째 비트까지는 원래대로 양수 순서로 채웁니다.
                for (int num : bucket0) arr[index++] = num;
                for (int num : bucket1) arr[index++] = num;
            }
        }
    }

    public static void main(String[] args) {
        // 음수, 양수, 0, 중복값이 마구 섞인 배열
        int[] data = {1, -3, 5, -4, 0, 21, -90, 100, -3};

        radixSortBinaryAll(data);
        System.out.println("음수 커버 정렬 결과: " + Arrays.toString(data));
    }
}