package ex20;
import java.util.*;
import java.util.stream.Collectors;


class Solution2{

    public List<Integer> solution(int n, int[] arr) {

        List<Integer> res = new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            int count =0;
            for (int j=0; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    count++;
                }
            }
            res.add(count+1);
        }
        return res;
    }
}

// 자료 구조를 쓰지 말고 풀어 버릇 하자
class Solution{
    public List<Integer> solution(int n, int[] arr) {

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<arr.length; i++){
            list.add(arr[i]);
        }
        list.sort(Collections.reverseOrder());
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<list.size(); i++){
            ans.add(list.indexOf(arr[i])+1);
        }
        return ans;

    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution2 sol= new Solution2();
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        sol.solution(n, arr).forEach(i->System.out.print(i+" "));
    }
}