package easyspub.exemChapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EasyMergeSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(38, 27, 43, 3);
        System.out.println("정렬 전: " + list);

        List<Integer> sortedList = mergeSort(list);
        System.out.println("정렬 후: " + sortedList);
    }

    // [1단계: 재귀적으로 쪼개는 메서드]
    public static List<Integer> mergeSort(List<Integer> list) {
        // 기저 조건(탈출 조건): 데이터가 1개 이하면 정렬할 필요가 없으니 그냥 돌려보냄
        if (list.size() <= 1) {
            return list;
        }

        // 반으로 가르기 위한 중간 지점 계산
        int mid = list.size() / 2;

        // 쪼개기 실행 (0부터 mid 직전까지, mid부터 끝까지)
        List<Integer> leftHalf = list.subList(0, mid);
        List<Integer> rightHalf = list.subList(mid, list.size());

        // ★★★ 재귀의 핵심 ★★★
        // 자기가 직접 정렬 안 함. "정렬된 왼쪽 조각"과 "정렬된 오른쪽 조각"을 받아옴
        List<Integer> sortedLeft = mergeSort(leftHalf);
        List<Integer> sortedRight = mergeSort(rightHalf);

        // 정렬되어 돌아온 두 조각을 이쁘게 합쳐서 최종 반환!
        return merge(sortedLeft, sortedRight);
    }

    // [2단계: 두 개의 정렬된 리스트를 하나로 이쁘게 조립하는 메서드]
    public static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();
        int i = 0; // 왼쪽 리스트용 포인터
        int j = 0; // 오른쪽 리스트용 포인터

        // 둘 다 대원이 남아있을 때, 맨 앞 대가리(?)끼리 비교해서 작은 놈 먼저 새 방에 넣기
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        // 혹시 왼쪽 동네에 잔바리(?)들이 남았다면 몽땅 털어 넣기
        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        // 혹시 오른쪽 동네에 잔바리들이 남았다면 몽땅 털어 넣기
        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }
}