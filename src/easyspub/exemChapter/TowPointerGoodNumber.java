package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TowPointerGoodNumber {
    public static void main(String[] args) {
        mySolution();
    }

    private static void mySolution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int count=0;
        int lt=0;
        int rt=1;
        int start=rt;
        while (lt<n && rt<n) {
            int sum = arr[lt] + arr[start];
            if(rt<=start) {
                rt++;
            }else if(rt>=lt) {
                lt++;
            }
            for (int i=0; i<arr.length; i++) {
                if(sum==arr[i]&&lt!=rt) {
                    count++;
                    start=i;
                    break;
                }
            }
        }
        System.out.println("count ..."+count);
    }

    private static void answerSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count=0;
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);
        for (int k=0; k<N; k++) {
            long find = arr[k];
            int i=0;
            int j=N-1;
            while (i<j) {
                if(arr[i]+arr[j]==find) {
                    if(i!=k && j!=k){
                        count++;
                        break;
                    }else if(i==k){
                        i++;
                    }else if(j==k){
                        j--;
                    }
                }else if(arr[i]+arr[j]<find) {
                    i++;
                }else {
                    j--;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}
