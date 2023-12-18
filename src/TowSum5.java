import java.util.*;

public class TowSum5 {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        //첫 인덱스 마지막 인덱스  얼리 리턴
        if (nums[0] + nums[nums.length - 1] == target) {
            answer[0] = 0;
            answer[1] = nums.length - 1;
            return answer;
        }
        int i = 0;
        int j = 1;

        while (true) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(nums[i]);

            Deque<Integer> deque = new LinkedList<>();
            deque.add(nums[j]);
            int frontier = queue.peek();
            int rear = deque.pollLast();
            if (frontier + rear == target&& i!=j) {

                answer[0] = i;
                answer[1] = j;
                break;
            }
            if (!queue.isEmpty()) {
                deque.push(frontier);
            }

            if (j == nums.length - 1) {
                j = i;
                i++;
            }
            j++;

        }

        return answer;

    }

}