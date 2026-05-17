package easyspub.exemChapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyQuickSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(42, 32, 10, 5, 45, 3, 8);

        System.out.println("정렬 전: " + list);
        List<Integer> sortedList = quickSort(list);
        System.out.println("정렬 후: " + sortedList);
    }

    public static List<Integer> quickSort(List<Integer> list) {
        // [재귀 탈출 조건] 더 이상 쪼갤 데이터가 없거나 1개뿐이면 정렬할 필요 없음
        if (list.size() <= 1) {
            return list;
        }

        // 1. 기준값(Pivot)은 편하게 맨 첫 번째 원소로 선택!
        int pivot = list.get(0);

        // 2. 피벗보다 작은 값과 큰 값을 담을 가상의 방(리스트) 준비
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        // 3. 피벗(0번 인덱스)을 제외한 나머지 숫자들을 분리수거하기
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            if (current <= pivot) {
                less.add(current);    // 피벗보다 작거나 같으면 왼쪽 방으로
            } else {
                greater.add(current); // 피벗보다 크면 오른쪽 방으로
            }
        }

        // 4. [핵심] 각각의 방을 똑같은 방법으로 다시 정렬(재귀)한 뒤, 하나로 합치기
        List<Integer> sorted = new ArrayList<>();
        sorted.addAll(quickSort(less));    // 작은 놈들 동네 정렬해와라!
        sorted.add(pivot);                 // 가운데에 기준값 딱 세우고
        sorted.addAll(quickSort(greater)); // 큰 놈들 동네 정렬해와라!

        return sorted;
    }
}