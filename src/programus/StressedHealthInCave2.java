package programus;

public class StressedHealthInCave2 {
    int maxCount = 0;
    boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        // DFS 탐색 시작 (현재 피로도, 탐험한 던전 수, 던전 정보)
        dfs(k, 0, dungeons);

        return maxCount;
    }

    private void dfs(int currentK, int count, int[][] dungeons) {
        // 매 순간 탐험한 최대 던전 수를 갱신
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            // 1. 아직 방문하지 않았고
            // 2. 최소 필요 피로도를 충족하는 경우
            if (!visited[i] && currentK >= dungeons[i][0]) {
                visited[i] = true; // 방문 처리

                // 다음 던전 탐색 (피로도 차감, 던전 수 + 1)
                dfs(currentK - dungeons[i][1], count + 1, dungeons);

                visited[i] = false; // 백트래킹 (원상복구)
            }
        }
    }
}