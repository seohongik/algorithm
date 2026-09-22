package programus;

import java.util.*;

public class ProcessPriorityQueue {

    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String >() {
            @Override
            public int compare(String o1, String o2) {

                String[] s1 = o1.split(" ");
                String[] s2 = o2.split(" ");

                int o1Pri = Integer.parseInt(s1[0]);
                int o2Pri = Integer.parseInt(s2[0]);

                int o1Index = Integer.parseInt(s1[1]);
                int o2Index = Integer.parseInt(s2[1]);

                // 1. 우선순위(Pri) 내림차순 정렬 (큰 값이 먼저)
                if (o1Pri != o2Pri) {
                    return Integer.compare(o2Pri, o1Pri); // o2 - o1
                }
                else {
                    return Integer.compare(o2Index, o1Index);
                }
            }
        });

        for (int i=0; i<priorities.length; i++){
            priorityQueue.add(priorities[i] + " "+ (  (i) ) ) ;
        }

        System.out.println(priorityQueue);
        int find = -1;
        while (location!=find){
            String first = priorityQueue.poll();
            find = Integer.parseInt(first.split(" ")[1]);
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {

        ProcessPriorityQueue processPriorityQueue = new ProcessPriorityQueue();
        int a=processPriorityQueue.solution(new int[]{2, 1, 3, 2},2);

        System.out.println(a);
        int b = processPriorityQueue.solution(new int[]{1, 1, 9, 1, 1, 1},0);
        System.out.println(b);
    }
}
