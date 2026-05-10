package easyspub.exemChapter;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/*
   12 3
   1 5 2 3 6 2 3 7 3 5 2 6
   * */
public class SlidingMinValueAnswer {
    public static void main(String[] args) throws IOException {
        // 자동 정렬 효과도 볼수 있고 최소값은 언제나 앞의 수이기때문에 시간복잡도 줄음
        // 1. 빠른 입출력을 위한 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 데이터 개수
        int L = Integer.parseInt(st.nextToken()); // 윈도우 크기

        // 2. 덱(Deque) 생성 (인덱스와 값을 함께 저장)
        // 값만 저장하면 범위를 벗어났는지 확인하기 어렵기 때문에 객체나 배열을 담습니다.
        Deque<Node> deque = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 핵심 로직 1: 나보다 큰 값은 뒤에서 다 제거한다.
            // (새로 들어온 나보다 크면, 어차피 최솟값이 될 가능성이 0%이기 때문)
            while (!deque.isEmpty() && deque.peekLast().value > now) {
                deque.removeLast();
            }

            // 핵심 로직 2: 현재 값을 덱의 뒤에 추가한다.
            deque.addLast(new Node(i, now));

            // 핵심 로직 3: 윈도우 범위를 벗어난 값(오래된 값)을 앞에서 제거한다.
            // 현재 인덱스(i)에서 윈도우 크기(L)를 뺀 것보다 작거나 같은 인덱스는 버림
            if (deque.peekFirst().index <= i - L) {
                deque.removeFirst();
            }

            // 핵심 로직 4: 덱의 맨 앞(First)은 항상 현재 윈도우의 최솟값이다.
            bw.write(deque.peekFirst().value + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 데이터를 저장할 클래스 (인덱스와 값을 한 쌍으로 묶음)
    static class Node {
        int index;
        int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
