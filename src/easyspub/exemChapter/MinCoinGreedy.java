package easyspub.exemChapter;

import java.util.Arrays;
import java.util.Scanner;

/*

10 4200
1
5
10
50
100
500
1000
5000
10000
50000

* */


public class MinCoinGreedy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] coin = new int[N];
        for(int i=0;i<N;i++){
            coin[i] = in.nextInt();
        }
        int ans = 0;
        for (int i=coin.length-1;i>=0;i--){
            if(coin[i]>K){
                continue;
            }else {
                ans += (K/coin[i]);
                K =  K%coin[i];
            }
        }

        System.out.println(ans);
    }
}
