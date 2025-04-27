package programus;

public class TowSum3 {

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
        int each = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {

            each = makeRealEnd(each);

            if (nums[each] + nums[start] == target && start != each) {

                answer[0] = start;
                answer[1] = each;

                if (answer[0] == answer[1]) {
                    answer[1] = each + 1;
                }

                return answer;
            }

            if (each >= nums.length - 1) {
                start++;
                each = 0;
                i = 0;
            }

        }
        return answer;
    }

    private int makeRealEnd(int each) {
        return ++each;
    }

}
