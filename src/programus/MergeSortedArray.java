package programus;

import java.util.*;

public class MergeSortedArray {


    /*https://leetcode.com/problems/merge-sorted-array/description/*/

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] temp = new int[m + n];

        int i = 0; // nums1용 포인터
        int j = 0; // nums2용 포인터
        int k = 0; // temp용 포인터

        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                i++; // nums1에서 가져왔으니 i만 전진! (j는 그대로 대기)
            } else {
                temp[k] = nums2[j];
                j++; // nums2에서 가져왔으니 j만 전진! (i는 그대로 대기)
            }
            k++; // temp는 매번 한 칸씩 채워지니까 전진
        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }
        // nums2에 숫자가 남은 경우
        while (j < n) {
            temp[k++] = nums2[j++];
        }

        System.arraycopy(temp, 0, nums1, 0, m + n);

    }

    public static void main(String[] args) {
        MergeSortedArray sol = new MergeSortedArray();

        // 테스트 케이스 1
        int[] nums1_1 = {1, 2, 3, 0, 0, 0};
        int m1 = 3;
        int[] nums2_1 = {2, 5, 6};
        int n1 = 3;
        sol.merge(nums1_1, m1, nums2_1, n1);
        System.out.println("Test Case 1: " + Arrays.toString(nums1_1));
        //[1,2,2,3,5,6]


        /*
        // 테스트 케이스 2
        int[] nums1_2 = {1};
        int m2 = 1;
        int[] nums2_2 = {};
        int n2 = 0;
        sol.merge(nums1_2, m2, nums2_2, n2);
        System.out.println("Test Case 2: " + Arrays.toString(nums1_2));
        //[1]


        // 테스트 케이스 3
        int[] nums1_3 = {0};
        int m3 = 0;
        int[] nums2_3 = {1};
        int n3 = 1;
        sol.merge(nums1_3, m3, nums2_3, n3);
        System.out.println("Test Case 3: " + Arrays.toString(nums1_3));
        //[1]


        // 테스트 케이스 4
        int[] nums1_4 = {1,2,4,5,6,0};
        int m4 = 5;
        int[] nums2_4 = {3};
        int n4 = 1;
        sol.merge(nums1_4, m4, nums2_4, n4);
        System.out.println("Test Case 3: " + Arrays.toString(nums1_4));
        //[1,2,3,4,5,6]
        */


    }

}
