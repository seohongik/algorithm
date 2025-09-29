package programus;

import java.util.*;

public class JulleJulleSameNum {

    public int[] solution(int[] arr) { // 20250929 기준 지금 보면 이거 왜 이렇게 풀었는지 모르겠음.....

        ArrayList<Integer> list = new ArrayList<Integer>();
        Deque<Integer> dq = new LinkedList<>();
        dq.push(-1); // 덱에 임의값 원소의 크기 보다 작은 값 넣고

        for (int i = 0; i < arr.length; i++) { // 어레이 길이 만큼 돌리고 덱 사이즈 만큼 돌리면 에러

            dq.add(arr[i]); // -1 이후에 어레이 하나씩 넣고
            if (dq.pollFirst() != arr[i]) { //-1 부터 하나씩 꺼낸다음

                list.add(arr[i]); //다른걸 리스트에 담고
            }
        }

        return list.stream().mapToInt(Integer::intValue)
                .toArray();
    }

    public int[] solution2(int[] nums){ // 새로운 풀이

        Stack<Integer> stack = new Stack<>();

        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(stack.peek()!=nums[i]){
                stack.push(nums[i]);
            }
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/12906
        JulleJulleSameNum removeDuplicates = new JulleJulleSameNum();
        System.out.println(removeDuplicates.solution(new int[]{1,2,2,3}));
        System.out.println(removeDuplicates.solution2(new int[]{1,2,2,3}));
    }

}
