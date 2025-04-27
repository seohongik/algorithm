package inflearnBaisc.ex03;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution{

    public String  solution(String string){
        String[] arr=string.split(" ");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o2.length()==o1.length()){
                    return 0;
                }
                return o2.length()-o1.length();
            }
        });

        return arr[0];
    }

}
public class Main {


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Solution s=new Solution();
        String string=in.nextLine();
        String result=s.solution(string);
        System.out.println(result);

    }
}
