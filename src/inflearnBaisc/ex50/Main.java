package inflearnBaisc.ex50;

import java.util.*;
import java.util.stream.Collectors;


/*

8 32
23 87 65 12 57 32 99 81

->3

15 99
73 32 31 49 94 37 40 62 78 66 27 100 99 29 9
-> 14

* */



class Solution {
    public int  solution(int n,int m, int[] array){
        Arrays.sort(array);
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        return list.indexOf(m)+1;
    }
}
// 이건 카운트 몇번만에 찾는지 알려주는 알고리즘
class Solution2 {
    public int  solution(int n,int m, int[] array){
        Arrays.sort(array);
        List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
        int count=0;
        while (count<n) {
            if(list.size()==1){
                break;
            }
            list = list.contains(m) &&list.indexOf(m)<list.size()/2 ? list.subList(0, (list.size()) / 2) : list.subList(list.size()/2, list.size());
            count++;
        }
        return count;
    }

}


// binarySearch 사용해서 풀기
class Solution3 {
    public int  solution(int n,int m, int[] array){
        Arrays.sort(array);
        return Arrays.binarySearch(array,m)+1;
    }

}

// 이게 답
class Solution4 {
    public int  solution(int n,int m, int[] array){
        Arrays.sort(array);

        int lt = 0;
        int rt = array.length-1;
        while (lt<=rt) {
            int mid = (lt + rt) / 2;
            if (array[mid] < m) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return lt+1;
    }

}

//이게 좀더 확실한  답 break 걸었기때문에 좀 더 빠름
class Solution5 {
    public int  solution(int n,int m, int[] array){
        int answer=0;
        Arrays.sort(array);
        int lt=0, rt=n-1;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(array[mid]==m){
                answer=mid+1;
                break;
            }
            if(array[mid]>m) rt=mid-1;
            else lt=mid+1;
        }
        return answer;
    }

}



public class Main {

    public static void main(String[] args){
        Solution4 solution = new Solution4();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[] array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=kb.nextInt();
        }
        System.out.println(solution.solution(n, m, array));

    }
}