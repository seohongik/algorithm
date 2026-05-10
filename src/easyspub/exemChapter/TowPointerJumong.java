package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TowPointerJumong {

    public static void main(String[] args) throws IOException {
        // 성능을 위해 BufferedReader와 StringTokenizer를 통일하여 사용하는 것이 좋습니다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 재료의 개수
        int m = Integer.parseInt(br.readLine()); // 갑옷이 되는 번호의 합
        int[] A = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            A[i] = Integer.parseInt(st.nextToken());
        }
        int lt = 0;
        int rt = A.length - 1;
        int count=0;
        Arrays.sort(A);

        while (lt < rt) {
            if(A[lt]+A[rt]==m){
                count++;
                lt++;
                rt--;
            }else if(A[lt]+A[rt]<m){
                lt++;
            }else if(A[lt]+A[rt]>m){
                rt--;
            }
        }
        System.out.println(count);
    }
}
