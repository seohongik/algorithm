package easyspub.exemChapter;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortK {

    public static void main(String[] args) {
        // 다 정렬시키고 찾기
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();
        int K= scanner.nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
        }
        quickSort(array, 0, array.length - 1);
        System.out.println(array[K-1]);

    }

    private static void quickSort(int[] array, int left, int right) {

        if(left < right) {
            int pivot = array[right];
            int i = left-1;
            for (int j = left; j < right; j++) {
                if (array[j] <= pivot) {
                    i++;
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            int temp = array[i+1];
            array[i+1] = array[right];
            array[right] = temp;

            int pivotIndex = i + 1;
            quickSort(array, left, pivotIndex-1);
            quickSort(array, pivotIndex+1, right);
        }
    }

}
