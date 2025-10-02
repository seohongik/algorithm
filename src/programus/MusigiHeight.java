package programus;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MusigiHeight{
    public int solution(int[] array, int height) {// 그냥 이분탐색이지 뭐
        // 머쓱이 height보다 큰 사람 구하기
        Arrays.sort(array);
        int start =0;
        int end =array.length-1;
        while (start <= end){
            int mid = (start + end)/2;
            if(array[mid] <= height){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        if(start>=array.length){
            return 0;
        }else {
            return Arrays.copyOfRange(array,start,array.length).length;
        }

    }

    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/120585
        MusigiHeight m = new MusigiHeight();
        System.out.println(m.solution(new int[]{149, 180, 192, 170}, 167	)); //3
        System.out.println(m.solution(new int[]{180, 120, 140}, 190	)); //0
        System.out.println(m.solution(new int[]{200}, 200	)); //0
    }

}
