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
    public int solution(int[][] info, int n, int m) {// 결정 알고리즘 적용 + DP
        int totalA = 0;
        for (int[] item : info) {
            totalA += item[0];
        }

        int lo = 0;
        int hi = totalA;
        int answer = totalA;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (canReduceTo(info, m, mid)) {
                answer = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return answer >= n ? -1 : answer;
    }

    private boolean canReduceTo(int[][] info, int m, int limit) {
        int totalA = 0;
        for (int[] item : info) totalA += item[0];

        int[] dp = new int[m + 1];  // dp[j]: 흔적 j 이하로 B가 훔칠 때 절약 가능한 최대 A 흔적

        for (int[] item : info) {
            int a = item[0], b = item[1];
            for (int j = m; j > b; j--) { // j>=b 에서 j>b 로 하니까 통과
                dp[j] = Math.max(dp[j], dp[j - b] + a);
            }
        }

        // 모든 가능한 흔적 합 j에 대해 검사
        for (int j = 0; j <= m; j++) {
            int remain = totalA - dp[j];
            if (remain <= limit) return true;
        }

        return false;
    }
}

