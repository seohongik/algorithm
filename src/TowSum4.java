public class TowSum4 {

    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        //첫 인덱스 마지막 인덱스  얼리 리턴
        if (nums[0] + nums[nums.length - 1] == target) {
            answer[0] = 0;
            answer[1] = nums.length - 1;
            return answer;
        }

        if (nums[0] + nums[1] == target) {
            answer[0] = 0;
            answer[1] = 1;
            return answer;
        }

        if (nums[nums.length - 1] + nums[nums.length - 2] == target) {
            answer[0] = nums.length - 1;
            answer[1] = nums.length - 2;
            return answer;
        }

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }

            }
        }

        return answer;

    }

}