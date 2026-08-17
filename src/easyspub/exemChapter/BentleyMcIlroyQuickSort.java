package easyspub.exemChapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BentleyMcIlroyQuickSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(5, 1, 3, 5, 2, 5, 4));

        quickSort(list, 0, list.size() - 1);

        System.out.println("정렬 결과 = " + list);
    }

    public static void quickSort(List<Integer> list, int l, int r) {
        if (r <= l) return;

        int i = l - 1, j = r;
        int p = l - 1, q = r;
        int pivot = list.get(r); // 피벗 선택

        // 1. 3-Way Partitioning 진행
        while (true) {
            while (list.get(++i) < pivot);
            while (pivot < list.get(--j)) if (j == l) break;
            if (i >= j) break;

            Collections.swap(list, i, j);

            // 피벗과 같은 값은 양 끝(p, q)으로 이동
            if (list.get(i) == pivot) { p++; Collections.swap(list, p, i); }
            if (list.get(j) == pivot) { q--; Collections.swap(list, j, q); }
        }
        Collections.swap(list, i, r);

        // 2. 양 끝에 치워둔 피벗과 같은 값들을 가운데로 이동
        j = i - 1;
        i = i + 1;
        for (int k = l; k < p; k++, j--) Collections.swap(list, k, j);
        for (int k = r - 1; k > q; k--, i++) Collections.swap(list, i, k);

        // 3. 피벗과 같은 중앙 구역을 제외하고 좌우 구역만 재귀 정렬
        quickSort(list, l, j);
        quickSort(list, i, r);
    }
}