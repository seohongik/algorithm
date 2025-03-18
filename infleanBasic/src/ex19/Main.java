package ex19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Solution2{
    public int solution(int n, int[] arr) {

        int ans = 0 ;
        int cnt = 0 ;
        for (int i=0; i<n; i++){
            if(arr[i]==1){
                cnt++;
                ans+=cnt;
            }else {
                cnt=0;
            }
        }
        return ans;
    }

}

// 포문의 형식을 제대로 모르고 푼 코드 인 것 같다.
class Solution{

    public int solution(int n, int[] arr) {
        List<Integer> list = new ArrayList<>();
        int count =0;
        if(arr[0]==1){
            list.add(1);
            count=1;
        }
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] == arr[i+1] && arr[i]==1 || arr[i+1]==1){
                count++;
                list.add(count);
            }else if(arr[i+1]==0){
                count=0;
            }
        }
        return list.stream().mapToInt(i->i).sum();
    }


}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution2 sol= new Solution2();
        int n=sc.nextInt();
        int[] arr=new int[n+1];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        System.out.print(sol.solution(n, arr));
    }
}
