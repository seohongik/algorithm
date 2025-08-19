package programus;

import java.util.*;
import java.util.stream.Collectors;

public class HIndex {

    /*
    어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.

    한두 편이 매우 많이 인용돼도, 나머지가 거의 인용되지 않으면 연구 전반의 “지속적인 영향력”을 보여주진 못해요.
    H-Index는 폭발적인 한 편보다 꾸준히 인용되는 여러 편을 높게 평가합니다.
    예: 인용수가 [100, 1, 1]이면 H=1 (많이 인용된 1편 + 그 다음이 못 받침)
    인용수가 [5, 5, 5]이면 H=3 (3편 모두 5회 이상)
    * */
    public  int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int candidate = n - i;
            int cited = citations[i];

            if (cited >= candidate) {
                h = candidate;
                break;
            }
        }
        return h;
    }

    public int solution2(int[] citations) {
        int n = citations.length;

        Map<Integer, Long> cited = Arrays.stream(citations)
                .boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        int h = 0;
        for (int cand = 1; cand <= n; cand++) {
            int finalCandidate = cand;

            long count = cited.entrySet().stream()
                    .filter(e -> e.getKey() >= finalCandidate)
                    .mapToLong(Map.Entry::getValue)
                    .sum();

            if (count >= cand) {
                h = cand;
            }
        }
        return h;
    }


    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
        System.out.println(hIndex.solution(new int[]{3, 0, 6, 1, 5})); //3
        System.out.println(hIndex.solution(new int[]{100,2,2})); //2

        System.out.println(hIndex.solution(new int[]{5,5,5})); //3

        System.out.println(hIndex.solution(new int[]{5,5,5,1,1,1,1})); //3
    }
}
