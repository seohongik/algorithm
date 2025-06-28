package inflearnBasic.ex13;

import java.util.*;

class Solution{

    public String solution(int n,String s) {

        String decryptStr=s.replaceAll("#","1").replaceAll("[*]","0");
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0, j=7; i<decryptStr.length(); i+=7,j+=7){

            if(j>decryptStr.length()){
                break;
            }
            String substring=decryptStr.substring(i,j);
            char hexa= (char)Integer.parseInt(substring,2);
            stringBuilder.append(hexa);
        }
        return stringBuilder.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        int n = Integer.parseInt(sc.nextLine());
        String result=solution.solution(n,sc.nextLine());
        System.out.println(result);
    }
}
