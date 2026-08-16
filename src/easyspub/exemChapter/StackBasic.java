package easyspub.exemChapter;

import java.util.Scanner;
import java.util.Stack;


/*
8
4
3
6
8
7
5
2
1
* */
public class StackBasic {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println("solve(A,N) = " + solve(A,N));
    }
    
    public static String solve(int[] A,int N) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb=new StringBuilder();
        int i=1;
        for (int j = 0; j < N; j++) {

            while (i <= A[j]) {
                stack.push(i++);
                sb.append("+");
            }

            if (!stack.isEmpty() && stack.peek() == A[j]) {
                stack.pop();
                sb.append("-");
            } else {
                return "NO";
            }
        }

        return sb.toString();
    }
}
