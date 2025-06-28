package inflearnBasic.ex15;

import java.util.Scanner;

class Solution{

    public String solution(int n , int[] a, int[] b) {

        StringBuilder wins = new StringBuilder();
        for (int i=0; i<n; i++){

            if(a[i]>b[i] && a[i]-b[i]==1){
                wins.append("A");
            }else if(a[i]<b[i]&& b[i]-a[i]==1){
                wins.append("B");
            }else if(a[i]>b[i]&& a[i]-b[i]==2){
                wins.append("B");
            }else if(a[i]<b[i]&& b[i]-a[i]==2){
                wins.append("A");
            }else if(a[i]==b[i]){
                wins.append("D");
            }
        }
        return wins.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Solution sol = new Solution();
        int n=kb.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0; i<n; i++){
            a[i]=kb.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i]=kb.nextInt();
        }
        for(char x : sol.solution(n, a, b).toCharArray()) System.out.println(x);
    }
}