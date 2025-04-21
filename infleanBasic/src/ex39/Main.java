package ex39;
import java.util.*;

class Solution {

    public int solution(int[][] board, int[] moves){

        List<Queue<Integer>> queues = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i< board.length; i++) {
            Queue<Integer> list = new LinkedList<>();
            for (int j = 0; j < board[i].length; j++) {
                if(board[j][i]!=0){
                    list.add(board[j][i]);
                }
            }
            queues.add(list);
        }
        int cnt = 0;
        for (int i = 0; i < moves.length; i++) {
            Queue<Integer> queue = queues.get(moves[i] - 1);
            if(queue.peek()!=null) {
                stack.push(queue.poll());
            }
            if(stack.size()<2){
                continue;
            }
            if(stack.get(stack.size()-2)==stack.peek().intValue()){
                stack.pop();
                stack.pop();
                cnt+=2;
            }
        }
        return cnt;
    }
}
/* 좀 더 깔 끔한 정답*/
class Solution2{
    public int solution(int[][] board, int[] moves) {
        int answer=0;
        Stack<Integer> stack = new Stack<>();
        for(int pos : moves){
            for(int i=0; i<board.length; i++){
                if(board[i][pos-1]!=0){
                    int tmp=board[i][pos-1];
                    board[i][pos-1]=0;
                    if(!stack.isEmpty() && tmp==stack.peek()){
                        answer+=2;
                        stack.pop();
                    }
                    else stack.push(tmp);
                    break;
                }
            }
        }
        return answer;
    }
}

public class Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[][] board=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j]=kb.nextInt();
            }
        }
        int m=kb.nextInt();
        int[] moves=new int[m];
        for(int i=0; i<m; i++) moves[i]=kb.nextInt();
        System.out.println(T.solution(board, moves));
    }
}
