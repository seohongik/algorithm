package programus;

import java.util.*;
import java.util.stream.Collectors;

public class MakePrimeNumber {
    public int solution(String numbers) {
        int answer = 0;

        Set<Integer> box = new HashSet<>();
        int[] array = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            array[i] = numbers.charAt(i)-48;
            box.add(array[i]);
        }
        Set<List<Integer>> combineNumbers = new HashSet<>();
        permute(array, 0, combineNumbers);

        for (List<Integer> list : combineNumbers) {
            for (int i = 0; i < list.size(); i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = i; j < list.size(); j++) {
                    sb.append(list.get(j));
                }
                box.add(Integer.parseInt(sb.toString()));
            }
        }

        for (Integer combinationNumbers : box) {

            boolean prime= isPrime(combinationNumbers);

            if (prime) {
                answer++;
            }
        }

        return answer;
    }

    private   boolean isPrime(int n) {
        if (n <= 1) {
            return false; // 1 이하의 숫자는 소수가 아님
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false; // 나누어 떨어지면 소수가 아님
            }
        }
        return true; // 나누어 떨어지지 않으면 소수
    }

    private void permute(int[] arr, int depth, Set<List<Integer>> combineNumbers) {
        if(depth == arr.length) {
            combineNumbers.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1, combineNumbers);
            swap(arr, depth, i);  // 백트래킹
        }
    }

    // 배열의 두 값을 바꾸는 메서드
    private void swap(int[] arr, int i, int j) {
        int  temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        MakePrimeNumber m = new MakePrimeNumber();
        System.out.println(m.solution("17"));
        System.out.println("==================");
        System.out.println(m.solution("011"));

        System.out.println("==================");
        System.out.println(m.solution("1233"));
    }

}
