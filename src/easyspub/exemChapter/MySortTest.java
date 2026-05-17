package easyspub.exemChapter;

import java.util.Arrays;

public class MySortTest {

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, 4, 2, 3};
        int size = 0;
        mySelectionSort(array, size+1,0,array.length-1);
        System.out.println(Arrays.toString(array));


    }

    private static void mySelectionSort(int[] array,int mid,int left,int right) {

        if(mid>array.length-1) {
            return;
        }
        boolean swapped = false; // 추가
        for (int i = 0; i <mid; i++) {
            if(array[i]>array[mid]) {
                int change = array[i];
                array[i] = array[mid];
                array[mid] = change;
                swapped = true; // 추가
            }
        }
        // 한 번도 swap 안 됐으면 이미 정렬된 상태
        if (!swapped && mid < right) { // 추가
            return;
        }
        if(mid<right){
            mySelectionSort(array,mid+1,left,right);
        }
    }
}
