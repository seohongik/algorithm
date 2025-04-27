package inflearnBaisc.ex34;

import java.util.*;

// 타임 리밋
class Solution {

    public List<Integer> solution(int n, int k, int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= n-k; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < k; j++) {
                set.add(arr[i+j]);
            }
            list.add(set.size());
        }
        return list;
    }
}

class Solution2 {

    public List<Integer> solution(int n, int k, int[] arr) {
       Map<Integer, Integer> map = new HashMap<>();
       List<Integer> list = new ArrayList<>();
       int lt = -k+1;
       for (int rt = 0; rt < arr.length; rt++) {
           map.put(arr[rt], map.getOrDefault(arr[rt], 0) +1);
           if(lt>=0){
               list.add(map.size());
               map.put(arr[lt], map.get(arr[lt])-1);
               if(map.get(arr[lt])==0){
                   map.remove(arr[lt]);
               }
           }
           lt++;
       }
       return new ArrayList<>(list);
    }
}

//정답
class Solution3 {

    public List<Integer> solution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();
		for(int i=0; i<k-1; i++){
            HM.put(arr[i], HM.getOrDefault(arr[i], 0)+1);
        }
        int lt=0;
		for(int rt=k-1; rt<n; rt++){
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0)+1);
            answer.add(HM.size());
            HM.put(arr[lt], HM.get(arr[lt])-1);
            if(HM.get(arr[lt])==0) HM.remove(arr[lt]);
            lt++;
        }
        return answer;
    }
}

public class Main {

    public static void main(String[] args){
        Solution2 T = new Solution2();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        for(int x : T.solution(n, k, arr)) System.out.print(x+" ");
    }
}
