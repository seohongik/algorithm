package programus;

public class TowSum2 {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if ((nums[i] + nums[j]) == target&& i!=j) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }
        return answer;

    }
}
