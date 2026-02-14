package programus;

import java.util.*;


public class TwoNumberPrimeEqual {

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0]=getDivisors(n,m);
        answer[1]=getCommonMulti(n,m);
        return answer;
    }
    private int getDivisors(int n,int m) {

        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 1; i <=Math.sqrt(n); i++) {
            if(n%i==0) {
                map.put(i,map.getOrDefault(i,0)+1);
                map.put(n/i,map.getOrDefault(n/i,0)+1);
            }
        }

        for (int i = 1; i <=Math.sqrt(m); i++) {
            if(m%i==0) {
                map.put(i,map.getOrDefault(i,0)+1);
                map.put(m/i,map.getOrDefault(m/i,0)+1);
            }
        }
        System.out.println(map);
        return map.entrySet().stream().filter(e -> e.getValue() == 2).max(Map.Entry.comparingByKey()).map(Map.Entry::getKey)
                .map(Integer::intValue)
                .orElse(1);

    }
    private int getCommonMulti(int n , int m) {

        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int i = m*n; i >=1; i--) {
            list.add(i*m);
            list2.add(i*n);
        }
        list.retainAll(list2);
        return list.get(list.size()-1);
    }

    public static void main(String[] args) {
        TwoNumberPrimeEqual solution = new TwoNumberPrimeEqual();
        int[] answer = solution.solution(3, 12);
        System.out.println(Arrays.toString(answer));
        int[] answer2 = solution.solution(10, 10);
        System.out.println(Arrays.toString(answer2));

        int[] answer3 = solution.solution(1, 1);
        System.out.println(Arrays.toString(answer3));

    }
}
