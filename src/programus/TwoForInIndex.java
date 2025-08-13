package programus;

import java.util.*;

public class TwoForInIndex {
    // 이거 안되는 이유 설명좀 ??
    public int[] solution(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        Deque<Integer> deque = new ArrayDeque<>();
        if(arr[start]==2){
            deque.addFirst(start);
        }
        while (start < end) {

            if(arr[start]!=2) {
                start++;
            }

            if(arr[end]!=2) {
                end--;
            }
            if(arr[start]==2) {
                deque.add(start);
            }else if(arr[end]==2) {
                deque.add(end);
            }
            start++;
        }
        if(arr[arr.length-1]==2){
            deque.addLast(arr.length-1);
        }

        System.out.println(deque);
        if(deque.isEmpty()){
            return new int[]{-1};
        }

        return Arrays.copyOfRange(arr,deque.getFirst(),deque.getLast()+1);
    }

    public static void main(String[] args) {
        TwoForInIndex twoForInIndex = new TwoForInIndex();
        int[]a=twoForInIndex.solution2(new int[]{1, 2, 1, 4, 5, 9, 2});

        System.out.println(Arrays.toString(a));

    }

    public int[] solution2(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(list.size()>=2){
                break;
            }
            if(arr[i]==2){
                list.add(i);
            }

        }

        Collections.sort(list);

        if(list.isEmpty()){
            return new int[]{-1};
        }
        return Arrays.copyOfRange(arr,list.get(0),list.get(list.size()-1)+1);
    }

}
