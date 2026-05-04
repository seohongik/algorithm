package easyspub.priorChapter;

import java.io.*;
import java.util.StringTokenizer;

public class CountingSort {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(bufferedReader.readLine());
        int[] count= new int[1001];
        StringTokenizer line = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(line.nextToken());
            count[number]++;
        }
        bufferedReader.close();
        for (int i = 0; i <= 1000; i++) {
            if(count[i]!=0) { //count[i]==1인것만 출력
                for (int j=0; j<count[i]; j++){
                    bufferedWriter.write(String.valueOf(i)+" ");
                }
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

}
