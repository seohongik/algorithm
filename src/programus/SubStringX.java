package programus;

import java.util.*;

public class SubStringX {
    public int solution(String s) {
        Deque<Character> queue = new LinkedList<>();
        int xCount = 0;
        int nonXcount=0;
        List<Deque<Character>> list = new ArrayList<>();
        for (int rt=0; rt<s.length(); rt++){

            queue.add(s.charAt(rt));
            char x= queue.peek();
            if (queue.getLast() != x) {
                nonXcount++;
            } else {
                xCount++;
            }
            if(nonXcount==xCount){
                list.add(queue);
                queue.clear();
                xCount=0;
                nonXcount=0;
            }
        }
        if(!queue.isEmpty()) {
            list.add(queue);
        }
        return list.size();
    }

    public static void main(String[] args) {
        SubStringX s = new SubStringX();
        System.out.println(s.solution("banana"));
        System.out.println(s.solution("abracadabra"));
        System.out.println(s.solution("aaabbaccccabba"));
    }
}
