package easyspub.exemChapter;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> lotto1=  List.of(7,12,26,35,37,40);
        List<Integer> lotto2=  List.of(34, 14, 42, 43, 2 ,12);
        List<Integer> lotto3 = List.of(5, 7, 12, 14, 19, 23);
        List<Integer> lotto4 = List.of(1, 2,  3,  5, 7, 8 );

        List<Integer> lottoAll = new ArrayList<>();
        lottoAll.addAll(lotto1);
        lottoAll.addAll(lotto2);
        lottoAll.addAll(lotto3);
        lottoAll.addAll(lotto4);

        Map<Integer,Integer> result = new TreeMap<>();
        for (int i = 0; i < lottoAll.size(); i++) {
            result.put(lottoAll.get(i), result.getOrDefault(lottoAll.get(i), 0) + 1);
        }
        System.out.println("result = " + result);





    }
}
