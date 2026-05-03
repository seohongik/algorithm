package easyspub;

import java.util.Arrays;
import java.util.Collections;

public class VariableSortIngSkills {

    public static void main(String[] args) {
        int[] a = {5,3,2,4,1};
        System.out.println(Arrays.toString(ascendingSort(a)));
        Integer[] b = {5,3,2,4,1};
        System.out.println(Arrays.toString(descendingSort(b)));

        // 부호 반전하고 정렬 후 다시 부호 반전 (내림차순)
        int[] c = {5,3,2,4,1};
        negateDescendingSort(c);
        Arrays.sort(c);
        negateDescendingSort(c);
        System.out.println(Arrays.toString(c));

    }

    public static int[] ascendingSort(int[] a) {
        Arrays.sort(a);
        return a;
    }

    public static Integer[] descendingSort(Integer[] b) {
        Arrays.sort(b, Collections.reverseOrder());
        return b;
    }

    public static void negateDescendingSort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] *=-1;
        }
    }

}
