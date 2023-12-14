import java.util.*;
import java.util.stream.Collectors;

public class Tangerine {

    public  int solution(int k, int[] tangerine) {

        List<Integer> list = Arrays.stream(tangerine).boxed().collect(Collectors.toList()); //리스트로 바꾸고
        Map<Integer, List<Integer>> map = list.stream().collect(Collectors.groupingBy(i->i.intValue())); //그룹핑 맵 한다음
        List<Integer> results = new ArrayList<>();

        map.forEach((key,val)->{
            results.add(val.size()); // 사이즈 만큼 담고
        });

        int sum=0; //썸 할건데 투썸 플레이스 에서 썸타고 싶다

        Collections.sort(results, Collections.reverseOrder()); //역순 정렬해서 큰거 부터 더할거야

        int count=0; //인덱스 0부터 시작할건데
        while (sum<k){ //sum < k 보다 작을때 까지 돌린건데

            sum+=results.get(count); //가장 큰거부터 더할거야

            if(sum>k){
                results.remove(count); //만약 더하는 와중에 k를 넘어서면 그 인덱스 지워
            }
            count++; //인덱스 ++
        }

        return count; // 걍 인덱스 리턴해 그럼 최소값
    }

}
