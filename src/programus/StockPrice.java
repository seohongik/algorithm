package programus;

import java.util.*;

public class StockPrice {
    // 효율성 테스트 fail
    public int[] solution(int[] prices) {
        List<List<Integer>> results = new ArrayList<>();

        for (int i = 0; i < prices.length; i++) {
            List<Integer> result = new ArrayList<>();
            for (int j = i+1; j <prices.length; j++) {
                if(prices[i]<=prices[j]) {
                    result.add(prices[i]);
                }else {
                    result.add(prices[i]);
                    break;
                }
            }
            results.add(result);
        }

        return results.stream().mapToInt(i -> i.size()).toArray();
    }

    // 속도 효율성에서 월등히 앞서 있다.
    public int[] solution2(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i+1; j < n; j++) {
                count++;
                if (prices[j] < prices[i]) {
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        System.out.println(Arrays.toString(stockPrice.solution(new int[]{1, 2, 3, 3, 2, 3})));// 5, 4, 2, 1, 1, 0
        System.out.println(Arrays.toString(stockPrice.solution(new int[]{1, 2, 3, 2, 3}))); //4, 3, 1, 1, 0
        System.out.println(Arrays.toString(stockPrice.solution(new int[]{1, 2, 3, 4, 5}))); //4, 3, 2, 1, 0
        System.out.println(Arrays.toString(stockPrice.solution(new int[]{5, 4, 3, 2, 1}))); //1, 1, 1, 1, 0
        System.out.println(Arrays.toString(stockPrice.solution(new int[]{3, 3, 3, 2}))); //3, 2, 1, 0
        System.out.println(Arrays.toString(stockPrice.solution(new int[]{1, 2, 3, 2, 3}))); //4, 3, 1, 1, 0
    }
}
