package programus;

import java.util.*;

public class Robbery {
    public int solution(int[][] info, int n, int m) {
        int[] bRobbery = new int[info.length];
        int[] aRobbery = new int[info.length];

        for (int i = 0; i < info.length; i++) {
            bRobbery[i]=(info[i][1]);
            aRobbery[i]=(info[i][0]);
        }

        Set<Integer> bStolen = new HashSet<>();
        permute(bRobbery, 0, m, bStolen);

        Set<Integer> aStolen = new HashSet<>();
        permute(bRobbery, 0, n, aStolen);

        int ans = 0;
        for (int i = 0; i < aRobbery.length; i++) {

            if(!bStolen.contains(i)){
                ans+=aRobbery[i];
            }
        }

        if(ans>=n&& bStolen.isEmpty() ){
            return -1;
        }

        return ans;
    }

    public void   permute(int[] arr, int depth, int max, Set<Integer> set) {
        if (depth == arr.length) {
            int sum =0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
                if(sum <max){
                    set.add(i);
                }
            }
            
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);            // 스왑
            permute(arr, depth + 1, max, set);        // 재귀
            swap(arr, depth, i);            // 원복 (백트래킹)
        }

    }

    // 스왑 함수
    public static void swap(int[] arr, int i, int j) {
        if (i == j){ return;} // 자기 자신끼리는 스왑하지 않음
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

class WrongSolution {
    public int solution(int[][] info, int n, int m) {
        int len = info.length;

        // b도둑이 먼저 훔칠 수 있는 물건 조합 (dp[i]는 금액 i 이하로 훔칠 수 있는 인덱스 집합)
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;

        // b도둑이 가져갈 수 있는 조합 추적
        List<Set<Integer>> selected = new ArrayList<>();
        for (int i = 0; i <= m; i++) selected.add(new HashSet<>());

        for (int i = 0; i < len; i++) {
            int cost = info[i][1];
            for (int j = m; j >= cost; j--) {
                if (dp[j - cost]) {
                    dp[j] = true;

                    // 인덱스 집합 복사 후 추가
                    Set<Integer> newSet = new HashSet<>(selected.get(j - cost));
                    newSet.add(i);
                    selected.set(j, newSet);
                }
            }
        }

        int maxA = -1;

        // b도둑이 가져가는 조합에 대해 a도둑의 최대 훔칠 수 있는 금액 계산
        for (int b = 0; b <= m; b++) {
            if (!dp[b]) continue;

            Set<Integer> bTaken = selected.get(b);
            int total = 0;

            for (int i = 0; i < len; i++) {
                if (bTaken.contains(i)) continue;
                // a도둑이 가져가도 되는 물건
                total += info[i][0];
            }

            maxA = Math.max(maxA, total);
        }

        return maxA >= n ? maxA : -1;
    }
}

class Solution{
    public int solution(int[][] info, int n, int m) {
        int thingCount = info.length;
        int[] dp = new int[m];  // b흔적 총합 j일 때 A흔적 절약합의 최대값 저장

        // A가 훔쳤을 때의 전체 흔적
        int maxATrace = 0;
        for (int i = 0; i < thingCount; i++) {
            maxATrace += info[i][0];
        }

        // knapsack: B가 훔칠 수 있는 조합에서 A 흔적 절약 최대화
        for (int i = 0; i < thingCount; i++) {
            int aTrace = info[i][0];
            int bTrace = info[i][1];
            for (int j = m - 1; j >= bTrace; j--) {
                dp[j] = Math.max(dp[j], dp[j - bTrace] + aTrace);
            }
        }

        int answer = maxATrace - dp[m - 1];
        return answer >= n ? -1 : answer;
    }
}


class Solution2 {
    public int solution(int[][] info, int n, int m) {
        // 전체 A 흔적 총합 계산
        int totalA = 0;
        for (int[] item : info) {
            totalA += item[0];
        }

        // 이분 탐색으로 A가 최소 남길 수 있는 흔적값을 탐색
        int lo = 0;
        int hi = totalA;
        int answer = totalA; // 최대 흔적에서 시작

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (canReduceTo(info, m, mid)) {
                // A의 흔적을 mid 이하로 줄일 수 있다면, 더 줄여본다
                answer = mid;
                hi = mid - 1;
            } else {
                // 못 줄이면, 흔적을 늘린다
                lo = mid + 1;
            }
        }

        // n보다 크거나 같으면 실패
        return answer >= n ? -1 : answer;
    }

    private boolean canReduceTo(int[][] info, int m, int limit) {
        int totalA = 0;
        for (int[] item : info) totalA += item[0];

        // dp[j] = 흔적 j 이하로 B가 훔칠 수 있는 최대 A 절약값
        int[] dp = new int[m + 1];

        // 0-1 Knapsack 알고리즘
        for (int[] item : info) {
            int a = item[0]; // A가 남긴 흔적
            int b = item[1]; // B가 남길 흔적

            // 뒤에서부터 순회해야 같은 물건을 여러 번 선택하지 않음
            for (int j = m; j > b; j--) {
                // 현재 흔적 j에서 이 물건을 선택했을 때 최대 A 절약값을 저장
                dp[j] = Math.max(dp[j], dp[j - b] + a);
            }
        }

        // 가능한 흔적 j에 대해, A의 남은 흔적이 limit 이하인지 확인
        for (int j = 0; j <= m; j++) {
            int remain = totalA - dp[j]; // 절약된 만큼 빼기
            if (remain <= limit) return true;
        }

        return false;
    }

}

