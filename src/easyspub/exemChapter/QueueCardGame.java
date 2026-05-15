package easyspub.exemChapter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class QueueCardGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }
        System.out.println(queue);


        while (queue.size()!=1) {
            queue.removeFirst();
            int goToTop = queue.removeFirst();
            queue.addLast(goToTop);
        }
        System.out.println(queue);




    }
}
