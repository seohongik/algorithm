package easyspub.exemChapter;

import java.util.*;

public class LastCard {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            stack.push(i);
        }


        while (stack.size() > 1) {
            stack.removeLast();
            int pop = stack.removeLast();
            stack.addFirst(pop);

        }
        System.out.println("stack = " + stack);
    }

}
