package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SlidingMinValue {
    /*
    12 3
    1 5 2 3 6 2 3 7 3 5 2 6
    * */
    public static void main(String[] args) throws IOException {
        myListLoginMain(); // 시간 복잡도 상당함 Collections.min() 때문에 remove로직도 그렇고..
    }

    private static void myListLoginMain() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int[] minValueArray = new int[N];

        int[] calcArray = new int[L];

        for (int i = 0; i < L; i++) {
            calcArray[i] = array[i];
            minValueArray[i] = Math.min(calcArray[0], calcArray[i]);
        }
        int last = L;
        List<Integer> slidingList =new ArrayList<>();
        for (int rt=L; rt <N+L-1; rt++) {
            int lt = last-2;
            myListLogic(array[lt],slidingList,L,minValueArray,lt);
            last++;
        }
        System.out.println(Arrays.toString(minValueArray));
    }

    private static void myListLogic(int item, List<Integer> list,int limit,int[] minValueArray,int lt) {
        list.add(item);
        if(list.size()==limit) {
            minValueArray[lt]=Collections.min(list);
        }
        if(list.size()>=limit) {
            list.remove(0);
        }
    }

}