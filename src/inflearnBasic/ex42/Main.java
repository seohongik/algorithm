package inflearnBasic.ex42;

import java.util.*;


//2시간 걸림 continue 때문 해맴
class Solution {

    public int solution(int n, int k ) {
        Deque<Integer> around = new ArrayDeque<>();
        Deque<Integer> defeatList = new ArrayDeque<>();
        int counter = 1;
        for (int i = 1; i <= 1_000; i++) {
            for (int j = 1; j <= n; j++) {
                if(defeatList.contains(j)){
                    continue;
                }
                around.addFirst(j);
                if (counter%k==0) {
                    int defeat = around.removeFirst();
                    defeatList.add(defeat);
                }
                if(defeatList.size()==n){
                    break;
                }
                counter++;
            }
        }
        return defeatList.getLast();

    }
}

// 이게 답
class Solution2 {

    public int solution(int n, int k ){
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()){
            for (int i=1; i<k; i++) { // k-1까지
                queue.offer(queue.poll());
            }
            queue.poll();
            if(queue.size()==1){
                ans = queue.poll();
            }
        }
        return ans;

    }
}

public class  Main {

    public static void main(String[] args) throws NoSuchMethodException {


        Solution2 T = new Solution2();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int k=kb.nextInt();
        System.out.println(T.solution(n,k));





    }
}
