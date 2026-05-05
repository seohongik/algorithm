package easyspub.exemChapter;

import java.util.Scanner;

public class TowPointerSeqSum {
    public static void main(String[] args) {
        // myTowPointer(); // 백트레킹때문에 복잡도 증가
        answerTowPointer();

    }

    private static void  myTowPointer() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = 0;
        int lt = 0;
        int rt = 0;
        int ans = 0;
        while (rt<n) {
            sum +=rt;
            if(sum==n){
                ans++;
            }
            if(sum>=n){
                sum = 0;
                lt++;
                rt=lt-1;
            }

            rt++;
        }
        System.out.println(ans);
    }

    private static void answerTowPointer() {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int ans = 1; // n하나만 뽑는 경우
        int start = 1;
        int end = 1;
        int sum = 1;

        while (end!=n) {

            if(sum==n){ // 같으면
                ans++;
                end++;
                sum = sum+end;
            }else if(sum>n){
                sum = sum-start; // 지워주고
                start++; // 스타트 증가
            }else {
                end++; // 올려주고
                sum = sum+end; //계산
            }

        }

        System.out.println(ans);

    }
}
