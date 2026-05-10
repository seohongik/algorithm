package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SlidingDNAAnswer {

    // 각 문자의 현재 개수를 저장할 배열 (A, C, G, T 순서)
    static int[] countCheckArray = new int[4];
    // 각 문자가 최소한 가져야 할 개수
    static int[] minArray = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 전체 DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이 (윈도우 크기)

        char[] DNA = br.readLine().toCharArray();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            minArray[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        // 1. 초기 윈도우 설정: 0부터 P-1까지 먼저 담기
        for (int i = 0; i < P; i++) {
            add(DNA[i]);
        }

        // 첫 번째 윈도우 상태 확인
        if (checkStatus()) ans++;

        // 2. 슬라이딩 윈도우: 한 칸씩 밀면서 처리
        // rt는 새로 들어오는 오른쪽 끝, lt는 빠져나가는 왼쪽 끝
        for (int rt = P; rt < S; rt++) {
            int lt = rt - P;

            add(DNA[rt]);    // 오른쪽 끝 문자 추가
            remove(DNA[lt]); // 왼쪽 끝 문자 제거

            if (checkStatus()) ans++; // 업데이트된 윈도우 상태 확인
        }

        System.out.println(ans);
        br.close();
    }

    // 문자 추가 함수
    private static void add(char c) {
        switch (c) {
            case 'A': countCheckArray[0]++; break;
            case 'C': countCheckArray[1]++; break;
            case 'G': countCheckArray[2]++; break;
            case 'T': countCheckArray[3]++; break;
        }
    }

    // 문자 제거 함수
    private static void remove(char c) {
        switch (c) {
            case 'A': countCheckArray[0]--; break;
            case 'C': countCheckArray[1]--; break;
            case 'G': countCheckArray[2]--; break;
            case 'T': countCheckArray[3]--; break;
        }
    }

    // 현재 윈도우가 조건을 만족하는지 확인하는 함수
    private static boolean checkStatus() {
        for (int i = 0; i < 4; i++) {
            if (countCheckArray[i] < minArray[i]) {
                return false; // 하나라도 최소 개수보다 적으면 실패
            }
        }
        return true; // 모든 조건 만족
    }
}