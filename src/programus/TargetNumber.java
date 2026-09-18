package programus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TargetNumber {
    private static int count;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        DFS(numbers,target,0,0);
        answer = count;
        return answer;
    }
    private void DFS(int[] numbers,int target,int index,int sum) {
        if(index == numbers.length){
            if(sum == target){
                count++;
            }
            return;
        }
        DFS(numbers,target,index+1,sum+numbers[index]);
        DFS(numbers,target,index+1,sum-numbers[index]);

    }

    public static void main(String[] args) {
        TargetNumber test = new TargetNumber();
        test.solution(new int[]{1,1,1,1,1}, 3);
        //count=0;
        //test.solution(new int[]{4,1,2,1}, 4);
    }
}
