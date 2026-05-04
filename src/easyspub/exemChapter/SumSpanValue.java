package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SumSpanValue {
    public static void main(String[] args) throws IOException {
        mySpanSum();
        answerSpanSum(); //입 출력 면에서 bufferd가 압도
    }

    private static void mySpanSum() throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] sumArray = new long[N+1];
        /*
        int[] arr = new int[N+1];
        int sum = 0;
        for (int i = 1; i < N+1; i++) {
            arr[i] = sc.nextInt();
            if(i>=2){
                sum=sum+arr[i];
            }else {
                sum+=arr[i];
            }
            sumArray[i] = sum;
        }
        */
        // 리펙 여기서 배워야할 점 쓸데없이 분기 하지 않는다.
        for (int i = 1; i <= N; i++) {
            long curr = sc.nextLong();
            sumArray[i] = sumArray[i-1]+curr;
        }
        System.out.println(Arrays.toString(sumArray));
        int cnt=0;
        while (cnt<=M) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            long spanSum= sumArray[end]-sumArray[start-1];
            System.out.println(spanSum);
            cnt++;
        }
    }

    private static void answerSpanSum() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());
        long[] S = new long[suNo+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i-1]+Long.parseLong(st.nextToken());
        }

        for (int q = 0; q <quizNo; q++) {
            st = new StringTokenizer(br.readLine());
            int i=Integer.parseInt(st.nextToken());
            int j=Integer.parseInt(st.nextToken());
            System.out.println(S[j]-S[i-1]);
        }
    }

}
