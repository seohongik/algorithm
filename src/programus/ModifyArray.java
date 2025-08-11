package programus;

import java.util.Arrays;

public class ModifyArray {

    public int solution(int[] arr) {
        int x = arr.length;
        int index  =0;
        while (true) {

            int[] array = Arrays.copyOf(arr, x);

            for (int i = 0; i < x; i++) {
                if (arr[i] % 2 == 0 && arr[i] >= 50) {
                    arr[i] = arr[i] / 2;
                } else if (arr[i] % 2 != 0 && arr[i] < 50) {
                    arr[i] = arr[i] * 2 + 1;
                }
            }

            int[] array2 = Arrays.copyOf(arr, x);

            if(Arrays.equals(array, array2)){
                break;
            }

            index++;
        }

        return index;
    }

}
