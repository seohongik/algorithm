package inflearnBaisc.ex47;

import java.util.Arrays;
import java.util.Scanner;


/*
8
20 25 52 30 39 33 43 33
--> D

7
20 25 52 30 39 33 43
--> U
*/

//선택 정렬로 탐색
class Solution {
    public String  solution(int n, int[] student){

        for (int i = 0; i < student.length; i++){
            int idx =i;
            for (int j = i + 1; j < student.length; j++){
                if(student[j] == student[idx]){
                    idx =j;
                    if(idx==i){
                        return "U";
                    }else {
                        return "D";
                    }
                }
            }
        }
        return "U";
    }
}


//스트림 람다로 풀기 ->  요건 시간 초과 남 스트림 느리긴한가보네
class Solution2 {
    public String  solution(int n, int[] student){

        long count = Arrays.stream(student).distinct().count();

        if(count == student.length){
            return "U";
        }else {
            return "D";
        }
    }
}


//이게 답
class Solution3 {
    public String solution(int n, int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                answer = "D";
                break;
            }
        }
        return answer;
    }
}
public class Main {

    public static void main(String[] args){
        Solution2 solution = new Solution2();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();

        int[] student=new int[n];

        for(int i=0;i<n;i++){
            student[i]=kb.nextInt();
        }
        System.out.println(solution.solution(n, student));

    }
}
