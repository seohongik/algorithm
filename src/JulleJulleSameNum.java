import java.util.*;

public class JulleJulleSameNum {

    public int[]  solution(int []arr) {

        ArrayList<Integer> list=new ArrayList<Integer>();
        Deque<Integer> dq=new LinkedList<>();
        dq.push(-1); // 덱에 임의값 원소의 크기 보다 작은 값 넣고

        for(int i=0; i<arr.length; i++) { // 어레이 길이 만큼 돌리고 덱 사이즈 만큼 돌리면 에러

            dq.add(arr[i]); // -1 이후에 어레이 하나씩 넣고
            if(dq.pollFirst() != arr[i] ) { //-1 부터 하나씩 꺼낸다음

                list.add(arr[i]); //다른걸 리스트에 담고
            }
        }

        return list.stream().mapToInt(Integer::intValue)
                .toArray();
    }

}
