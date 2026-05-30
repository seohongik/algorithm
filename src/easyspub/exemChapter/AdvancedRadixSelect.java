package easyspub.exemChapter;


import java.util.ArrayList;
import java.util.List;

public class AdvancedRadixSelect {
    public static int findKthWithNegative(int[] sliced, int k) {
        int currentBit = 31; // 부호 비트(31번째)부터 검사 시작

        List<Integer> candidates = new ArrayList<>();
        for (int num : sliced) candidates.add(num);

        while (currentBit >= 0 && candidates.size() > 1) {
            List<Integer> zeros = new ArrayList<>();
            List<Integer> ones = new ArrayList<>();

            for (int num : candidates) {
                // 부호 비트(31번째 비트)를 검사할 때만 특별히 0과 1의 판정을 뒤집어줍니다.
                // 또는 모든 가동 전에 num ^ 0x80000000 처리를 해도 됩니다.
                int bitValue = (num >> currentBit) & 1;

                if (currentBit == 31) {
                    // 최상위 부호 비트라면: 1(음수)을 zeros로, 0(양수)을 ones로 보냄
                    if (bitValue == 1) zeros.add(num);
                    else ones.add(num);
                } else {
                    // 일반 자릿수 비트라면: 원래대로 0은 zeros, 1은 ones로 보냄
                    if (bitValue == 0) zeros.add(num);
                    else ones.add(num);
                }
            }

            int zeroCount = zeros.size();

            if (k <= zeroCount) {
                candidates = zeros;
            } else {
                k = k - zeroCount;
                candidates = ones;
            }

            currentBit--;
        }

        return candidates.get(0);
    }

    public static void main(String[] args) {
        // 음수가 뒤섞인 널뛰기 배열
        int[] data = {-5, 44444, 2, -34444, 0, 2};
        int targetK = 2; // 2번째로 작은 수 찾기 (정렬하면 -34444, -5, 0, 2, 2, 44444 이므로 정답은 -5)

        int result = findKthWithNegative(data, targetK);
        System.out.println("음수 포함 비트 추적 결과: " + result); // 출력: -5
    }
}
