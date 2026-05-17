package easyspub.exemChapter;

import programus.Possible;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String N = scanner.nextLine();
        int[] array = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            array[i] = Integer.parseInt(N.substring(i, i + 1));
        }

        for (int i = 0; i < N.length(); i++) {

            int max =i;
            for (int j = i+1; j < N.length(); j++) {

                if(array[j] > array[max]) {
                    max = j;
                }
            }
            if(array[i] < array[max]) {
                int temp = array[i];
                array[i] = array[max];
                array[max] = temp;
            }
        }
        System.out.println(Arrays.toString(array));

    }
}
