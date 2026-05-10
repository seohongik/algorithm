package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SlidingDNA {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(sc.readLine());
        int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분문자열 길이

        char[] DNA = new char[S];
        int [] minArray = new int[4];
        DNA = sc.readLine().toCharArray();
        st = new StringTokenizer(sc.readLine());
        for (int i = 0; i < 4; i++) {
            minArray[i] = Integer.parseInt(st.nextToken());
        }
        int ans=0;
        int lt = 0;
        int [] countCheckArray = new int[4];
        for (int rt = 0; rt < DNA.length; rt++) {
            if(lt<=rt+P) {
                add(DNA[rt], countCheckArray,minArray);
                ans+=status(countCheckArray,minArray);
            }else {
                lt++;
            }
            if(rt>=1) {
                remove(DNA[rt - 1], countCheckArray);
            }
        }
        System.out.println(ans);
    }
    private static void add(char DNA,int[] countCheckArray,int[] minArray) {
        switch (DNA) {
            case 'A':
                countCheckArray[0]++;
                break;
            case 'C':
                countCheckArray[1]++;
                break;
            case 'G':
                countCheckArray[2]++;
                break;
            case 'T':
                countCheckArray[3]++;
                break;
        }
    }

    private static int status(int[] countCheckArray,int[] minArray) {
        int ans=0;
        if(countCheckArray[0]>=minArray[0]&&countCheckArray[1]>=minArray[1]&&countCheckArray[2]>=minArray[2]&&countCheckArray[3]>=minArray[3]) {
            ++ans;
        }
        return ans;
    }

    private static void remove(char DNA,int[] countCheckArray){
        switch (DNA) {
            case 'A':
                countCheckArray[0]--;
                break;
            case 'C':
                countCheckArray[1]--;
                break;
            case 'G':
                countCheckArray[2]--;
                break;
            case 'T':
                countCheckArray[3]--;
                break;
        }

    }
}
