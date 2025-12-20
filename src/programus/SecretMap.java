package programus;

import java.util.*;

public class SecretMap {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        Deque<String> list1 = getBinaryStrings(arr1,n);
        Deque<String> list2 = getBinaryStrings(arr2,n);

        int index=0;
        while (!list1.isEmpty() && !list2.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            String block1 = list1.poll();
            String block2 = list2.poll();

            for (int i = 0; i < block1.length(); i++) {
                if (block1.charAt(i) == ('1') || block2.charAt(i) == ('1')) {
                    sb.append("#");
                } else if (block1.charAt(i) == ('0') && block2.charAt(i) == ('0')) {
                    sb.append(" ");
                }
            }
            answer[index]=sb.toString();
            index++;
        }

        return answer;
    }

    private Deque<String> getBinaryStrings(int[] arr,int n) {
        Deque<String> answer = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            StringBuilder binary= new StringBuilder(Integer.toString(arr[i], 2));
            while(binary.length()<n) {
                binary.insert(0, "0");
            }
            answer.add(binary.toString());
        }
        return answer;
    }


    public static void main(String[] args) {

        SecretMap secretMap = new SecretMap();
        System.out.println(Arrays.toString(secretMap.solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(secretMap.solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10})));
    }
}
