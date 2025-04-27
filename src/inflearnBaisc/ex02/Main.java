package inflearnBaisc.ex02;
import java.util.Arrays;
import java.util.Scanner;

class Solution{

    public int Solution(String string , char ch){
        string = string.toLowerCase();
        String find = String.valueOf(ch).toLowerCase();
        char[] array = string.toCharArray();
        Arrays.sort(array);
        int answer=0;
        for (int i=0; i<array.length; i++){
            if(String.valueOf(array[i]).equals(find)){
                answer++;
            }
        }
        return answer;
    }

}
public class Main {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        Solution s=new Solution();
        String string=in.next();
        int result=s.Solution(string,in.next().charAt(0));
        System.out.println(result);

    }
}
