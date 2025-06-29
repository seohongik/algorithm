package inflearnBasic.ex48;
import java.util.*;

class Solution {
    public int[] solution(int n, int[] student){
        int[] answer = new int[2];
        int peerIdx = 0;
        for (int j = 1; j < student.length-1; j++){
            if(student[j-1] >= student[j]){
                peerIdx = j;
                if(student[j-1] == student[j]){
                    peerIdx++;
                }
            }
        }
        int pear = student[peerIdx];
        answer[1] = peerIdx+1;
        int cholIdx = 0;
        for (int i = 0; i < peerIdx; i++){
            if(student[i] >= pear){
                cholIdx = i;
                if(student[i]==pear){
                    cholIdx++;
                }
                break;
            }
        }
        answer[0]=cholIdx+1;

        return answer;
    }
}

class Solution2 {
    public int[] solution(int n, int[] student){
        List<Integer> answer = new ArrayList<>();
        int[] temp = new int[student.length];
        System.arraycopy(student, 0, temp, 0, student.length);
        Arrays.sort(temp);
        for (int i = 0; i < student.length; i++){

            if(student[i]!=temp[i]){
                answer.add(i+1);
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }

}

public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int[] student=new int[n];
        for(int i=0;i<n;i++){
            student[i]=kb.nextInt();
        }
        for (int x:solution.solution(n, student)) System.out.print(x+" ");
    }
}