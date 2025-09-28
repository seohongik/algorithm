package programus;

import java.util.*;

public class DuplicatedLine {

    public int solution(int[][] lines) {
        // 라인은 무조건 3개
        List<Integer> line1 = makeLine(lines[0]);
        List<Integer> line2 = makeLine(lines[1]);
        List<Integer> line3 = makeLine(lines[2]);

        List<Integer> first = duplication(line1,line2);
        List<Integer> second = duplication(line1,line3);
        List<Integer> third = duplication(line2,line3);

        Set<Integer> overlapped = new HashSet<>();
        overlapped.addAll(first);
        overlapped.addAll(second);
        overlapped.addAll(third);

        return overlapped.size();
    }

    public List<Integer> makeLine(int[] lines) {

        List<Integer> line = new ArrayList<>();
        for (int i = lines[0]; i < lines[1]; i++) {
            line.add(i);
        }
        return line;
    }

    public List<Integer> duplication(List<Integer> first, List<Integer> second) {

        List<Integer> result1 = new ArrayList<>(first);
        List<Integer> result2 = new ArrayList<>(second);
        result1.retainAll(result2);
        return new ArrayList<>(result1);
    }

    // 다른 사람 풀이
    public int solutionOther(int[][] lines) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] line : lines) {
            int from = Math.min(line[0], line[1]);
            int to = Math.max(line[0], line[1]);
            for (int i = from; i < to; i++) {
                map.merge(i, 1, Integer::sum);
            }
        }

        return (int) map.values().stream().filter(i -> i > 1).count();
    }


    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/120876

        DuplicatedLine duplicatedLine = new DuplicatedLine();
        System.out.println(duplicatedLine.solution(new int[][]{{0, 1}, {2, 5}, {3, 9}}));  //2 [3,5]
        System.out.println(duplicatedLine.solution(new int[][]{{0, 5}, {3, 9}, {1, 10}})); //8 두개이상의 선분이 겹치는 구간 [end -start] [1,9]
    }
}
