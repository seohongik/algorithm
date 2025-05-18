package inflearnBaisc.ex45;

import java.util.*;


class Solution {

    public int[]  solution(int n, int[] array ){

        for (int i=0; i<array.length; i++){
            for (int j=i+1; j<array.length; j++){
                int max = Math.max(array[i], array[j]);
                if(max>array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}


// 선택정렬로 풀려면...
class Solution2 {
    public int[]  solution(int n, int[] array ){
        int minIdx, temp =0;

        for (int i=0; i<array.length; i++){
            minIdx = i;
            for (int j=i+1; j<array.length; j++){
                if(array[j]<array[minIdx]){
                    minIdx = j;
                }

            }
            temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }

        return array;
    }
}

// 버블 정렬로 풀려면...
class Solution3 {

    public int[]  solution(int n, int[] array ){

        for(int i=0; i<array.length; i++){

            for(int j= i+1; j<array.length; j++){

                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                }
            }
        }
        return array;
    }
}


// 삽입 정렬로 풀려면...
class Solution4 {

    public int[]  solution(int n, int[] array ){
        for (int i=0; i<array.length; i++){
            int target = array[i];
            for (int j=array.length-1; j>=0; j--){
                if(i>=1 &&array[i - 1] > target){
                    array[i] = array[i - 1];
                    array[i - 1] = target;
                    i--;

                }else {
                    break;
                }
            }
        }
        return array;
    }
}

// 일반적 삽입 정렬로 풀려면
class Solution5 {

    public int[]  solution(int n, int[] array ){

        for(int i=1; i<array.length; i++) { //두번째 원소부터 원소의 위치 찾기

            int temp = array[i]; //위치찾을 값 저장
            int prev = i-1; //바로 이전 인덱스

            //i번째 이전 값들과 비교
            //prev가 0이 되거나 temp가 크기 전까지 반복
            while(prev>=0 && array[prev]>temp) {
                array[prev+1] = array[prev];//한칸씩 뒤로 이동
                prev--;

            }

            //temp가 크다면 arr[prev] < temp가 되므로
            //prev다음인 arr[prev+1]가 temp의 위치가 된다.
            array[prev+1] = temp; //삽입 위치에 삽입값 저장
        }
        return array;
    }
}


public class  Main {

    public static void main(String[] args){
        Solution solution1 = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = kb.nextInt();
        }
        int[] result=solution1.solution(n,array);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] +" ");
        }

    }
}
