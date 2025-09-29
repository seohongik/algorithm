package programus;

import java.util.*;

public class StressedHealthInCave {

    // k = 현재 health
    //dungeons[0]  던전을 탐험하는데 드는 최소 피로도
    //dungeons[0]  던전을 탐험하는데 드는 소모 피로도
    public int solution(int k, int[][] dungeons) {

        List<List<Integer>>  demageList = new ArrayList<>();
        List<List<Integer>>  minCertifiedFightHealthList = new ArrayList<>();

        List<Integer> damages = new ArrayList<>();
        List<Integer> certifiedFight = new ArrayList<>();

        for (int[] dungeon : dungeons) {
            damages.add(dungeon[1]);
            certifiedFight.add(dungeon[0]);
        }

        allPossibleRoot(damages,0, demageList);
        allPossibleRoot(certifiedFight,0, minCertifiedFightHealthList);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < demageList.size(); i++) {
            int currentHealth = k;
            int count = 0;
            int currentCertified = minCertifiedFightHealthList.get(i).get(0);
            if(currentHealth>=currentCertified){
                count++;
            }

            for (int j = 1; j < demageList.get(i).size(); j++) {
                currentHealth = currentHealth - demageList.get(i).get(j-1);
                currentCertified = minCertifiedFightHealthList.get(i).get(j);

                if(currentHealth>=currentCertified){
                    count++;
                }
            }
            result.add(count);
        }

        return Collections.max(result);
    }

    private void allPossibleRoot(List<Integer> arr, int depth, List<List<Integer>> combineNumbers) {
        if(depth == arr.size()) {
            combineNumbers.add(new ArrayList<>(arr));
            return;
        }
        for (int i = depth; i < arr.size(); i++) {
            swap(arr, depth, i);
            allPossibleRoot(arr, depth + 1, combineNumbers);
            swap(arr, depth, i);  // 백트래킹
        }
    }

    private void swap(List<Integer> array, int i, int j) {
        Collections.swap(array, j, i);
    }

}
