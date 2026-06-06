package easyspub.exemChapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MergeSortList {

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 8, 7, 1, 3, 10, 6, 4));
        System.out.println("sortedList = " + mergeSort(array));

    }

    private static List<Integer> mergeSort(List<Integer> list) {
        // 기저 조건: 리스트의 크기가 1 이하이면 이미 정렬된 것이므로 그대로 반환
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;

        // 좌우로 쪼개기 (새로운 리스트로 독립시킴)
        List<Integer> left = new ArrayList<>(list.subList(0, mid));
        List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));

        // 재귀적으로 각각을 다시 쪼개고 정렬
        left = mergeSort(left);
        right = mergeSort(right);

        // 쪼개진 두 리스트를 하나로 합쳐서 반환
        return merge(left, right);
    }
    private static List<Integer> merge(List<Integer> left, List<Integer> right) {

        System.out.println("left = " + left+" right = " + right);
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // 양쪽 리스트의 요소를 비교하며 작은 순서대로 합침
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // 남은 요소들을 전부 뒤에 붙임
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }


}