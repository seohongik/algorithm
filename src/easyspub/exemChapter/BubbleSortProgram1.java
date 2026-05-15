package easyspub.exemChapter;

import java.util.*;

public class BubbleSortProgram1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sortedArray[i] = arr[i];
        }
        Arrays.sort(sortedArray);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < n-1; i++) {

            for (int j = 0; j < n-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }else {
                    map.put(i,map.getOrDefault(i,0)+1);
                }
            }

        }
        int max = Collections.max(map.values());
        System.out.println(max+1);
    }
}
