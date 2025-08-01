package inflearnBasic.ex36;

import java.util.*;

//정답 예전에 삼총사 푼거랑 비슷함
class Solution {
    public int solution(int[] arr, int n, int k) {
        int answer = -1;
        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int l = j + 1; l < n; l++) {
                    Tset.add(Integer.valueOf(arr[i] + arr[j] + arr[l]));
                }
            }
        }
        int cnt = 0;

        for (int x : Tset) {
            //System.out.println(x);
            cnt++;
            if (cnt == k) return x;
        }
        return answer;
    }
}

public class Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        System.out.println(T.solution(arr, n, k));
    }
}
