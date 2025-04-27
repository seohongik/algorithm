package programus;

import java.util.*;
public class Trio {


    public int solution(int[] number) {
        int first = 0;
        int second = 0;
        Set<List<Integer>> set = new HashSet<>();

        for (int  i = 0; i < number.length; i++) {
            List<Integer> list = new ArrayList<>();
            second = makeEachPlus(second);
            int towSum = number[second] + number[first];
            list.add(towSum);

            List<Integer> listWhereTrio = new ArrayList<>();
            for(int j=first; j<=second; j++) {
                if (((list.get(0) + number[j]) == 0)  && second!=j&& j!=first && first!=second) {

                    listWhereTrio.add(first);
                    listWhereTrio.add(second);
                    listWhereTrio.add(j);

                    Collections.sort(listWhereTrio);
                    set.add(listWhereTrio);
                }
            }
            if (second == number.length - 1) {
                second = i=0;
                first++;
            }

            if (first == number.length - 1) {
                break;
            }
        }

        return set.size();
    }

    private int makeEachPlus(int each) {
        return ++each;
    }
}
