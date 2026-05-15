package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/*

8
4
3
6
8
7
5
2
* */
public class StackMakeSequenceNumber {
    public static void main(String[] args) {
        answerSolution();
    }

    private static void answerSolution(){
        Scanner scan = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = scan.nextInt();
        int[] A = new int[n];
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            A[i] = scan.nextInt();
        }

        int order = 1;
        boolean result= true;
        for (int i = 0; i < n; i++) {
            int curr = A[i];
            System.out.println("stack  "+stack+" order   "+order+" A[i]  "+A[i]);
            if(curr>=order){ // 4>=1
                while (curr>=(order)){ // 1 2 3 4
                    stack.push(order++);
                    list.add("+");
                }
                stack.pop();
                list.add("-");
            }else {
                int prev = stack.pop();
                if(prev>curr){
                    System.out.println("NO");
                    result= false;
                    break;
                }else {
                    list.add("-");
                }
            }

        }
        if(result){
            System.out.println(list);
        }
    }


}
