import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        nums=Arrays.stream(nums).filter(i->i>0).boxed().mapToInt(i->i).toArray();
        Arrays.sort(nums);

        if(nums.length==0){
            return 1;
        }
        int result = 0;
        for(int i=0; i<nums.length; i++){

            queue.add(i+1);

            if(nums[i]==queue.peek()){
                queue.poll();
            }

            if(queue.isEmpty()){
                result = nums[i]+1;
            }else {
                result = queue.peek();
            }
        }
        return result;
    }

}
