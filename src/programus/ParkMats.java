package programus;
import java.util.*;

public class ParkMats {

    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;

        // mats 배열을 내림차순 정렬 — 큰 매트부터 시도
        Arrays.sort(mats);
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int size = mats[idx];

            // park 내부에서 이 size × size 매트를 깔 수 있는 위치 탐색
            for (int i = 0; i <= n - size; i++) {
                for (int j = 0; j <= m - size; j++) {
                    boolean can = true;

                    // 이 위치에서 size × size 전체가 "-1" 인지 확인
                    for (int x = i; x < i + size; x++) {
                        for (int y = j; y < j + size; y++) {
                            if (!park[x][y].equals("-1")) {
                                can = false;
                                break;
                            }
                        }
                        if (!can) break;
                    }

                    if (can) {
                        return size; // 이 매트 깔 수 있으면 바로 반환 (가장 큰 것 먼저 시도)
                    }
                }
            }
        }

        // 어떤 매트도 깔 수 없으면 –1 반환
        return -1;
    }


    public static void main(String[] args) {
        ParkMats parkMats = new ParkMats();
        System.out.println("결과: " + parkMats.solution(
                new int[]{5, 3, 2},
                new String[][]{
                        {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                        {"A", "A", "-1", "B", "-1", "-1", "B", "-1"},
                        {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "-1", "-1"},
                        {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                        {"D", "D", "-1", "-1", "-1", "-1", "-1", "-1"}
                }
        ));
    }
}
