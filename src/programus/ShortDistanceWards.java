package programus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class ShortDistanceWards {


    private static class Node {
        String word;
        int count;

        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }


    public int solution(String begin, String target, String[] words) {
        return bfs(begin,target,words);
    }

    private int bfs(String begin,String target,String[] words){

        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];

        queue.add(new Node(begin,0));

        while (!queue.isEmpty()){

            Node curr = queue.poll();

            if (curr.word.equals(target)) {
                return curr.count;
            }

            for (int i=0; i<words.length; i++) {

                if (!visited[i] && isOneLetterDiff(curr.word ,words[i])) {
                    visited[i] = true;
                    queue.offer(new Node(words[i], curr.count + 1));
                }
            }

        }
        return 0;
    }

    private boolean isOneLetterDiff(String w1, String w2) {
        int diff = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diff++;
            }
        }
        return diff == 1;
    }
    

}
