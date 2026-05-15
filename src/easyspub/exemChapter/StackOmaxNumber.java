package easyspub.exemChapter;

import java.util.*;

public class StackOmaxNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        stack.push(0);
        for (int i = 1; i < n; i++) {
            System.out.println(stack);
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }

        System.out.println("stack..."+stack);
        System.out.println(Arrays.toString(ans));


    }
}
