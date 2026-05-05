package easyspub.exemChapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumSpanMatrixValue {
    public static void main(String[] args) throws IOException {
        //mySumMatrix(); //시간복잡도 높음
        answerSumMatrix(); // 정석
    }

    public static void mySumMatrix() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] sumMatrix = new long[N+1][N+1];

        /*
        for (int i = 0; i <N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N; j++) {
                long curr = Long.parseLong(st.nextToken());
                sumMatrix[i][j] =  sumMatrix[i][j-1]+curr;
            }
        }*/

        //리펙 (이러면 마지막에서 중첩문 돌릴수 밖에 없다 한번에 계산하는게 낫다

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                // 인덱스의 의미를 변수로 정의
                int aboveRow = i - 1;      // 바로 위 행
                int leftCol = j - 1;       // 바로 왼쪽 열
                // (현재까지의 합) = (위쪽 합) + (왼쪽 합) - (중복된 대각선 합) + (현재 값)
                sumMatrix[i][j] = sumMatrix[aboveRow][j]
                        + sumMatrix[i][leftCol]
                        - sumMatrix[aboveRow][leftCol]
                        + val;
            }
        }

        /*
        for (int i=0; i<M; i++) {
            long sum = 0;
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1 - 1; j < x2; j++) {
                long partialSum = sumMatrix[j][y2];
                partialSum -= sumMatrix[j][y1 - 1];
                sum += partialSum;
            }
            System.out.println(sum);
        }*/

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 구하려는 영역의 시작점 바로 '전' 인덱스들
            int rowBefore = x1 - 1;
            int colBefore = y1 - 1;

            // (전체 영역 합) - (위쪽 영역 제거) - (왼쪽 영역 제거) + (중복 제거된 공통 부분 복구)
            long result = sumMatrix[x2][y2]
                    - sumMatrix[rowBefore][y2]
                    - sumMatrix[x2][colBefore]
                    + sumMatrix[rowBefore][colBefore];

            sb.append(result).append("\n");
        }
    }

    public static void answerSumMatrix() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Using N+1 to handle 1-based indexing easily
        long[][] sumMatrix = new long[N + 1][N + 1];

        // 1. Build the 2D Prefix Sum Matrix
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                // 2D Prefix Sum Formula
                sumMatrix[i][j] = sumMatrix[i - 1][j] + sumMatrix[i][j - 1] - sumMatrix[i - 1][j - 1] + val;
            }
        }

        // 2. Answer Queries in O(1)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // Query Formula
            long result = sumMatrix[x2][y2] - sumMatrix[x1 - 1][y2] - sumMatrix[x2][y1 - 1] + sumMatrix[x1 - 1][y1 - 1];
            sb.append(result).append("\n");
        }

        // Faster output for large M
        System.out.print(sb);
    }
    /**공식 =>  $S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + A[i][j]$
     *  1. 전제 조건 (초기값과 패딩)
         그림에서 보시는 것처럼, 계산의 편의를 위해 0행과 0열은 모두 0으로 채워진 상태입니다(회색 패딩 영역).
    * sumMatrix[0][j] = 0
    * sumMatrix[i][0] = 0

        2. 첫 번째 칸 계산 ($i=1, j=1$)
    원본 행렬 $A[1][1]$의 값이 1일 때를 가정해 봅시다.
    * 공식: $S[1][1] = S[0][1] + S[1][0] - S[0][0] + A[1][1]$
    * 계산: $0 + 0 - 0 + 1$
    * 결과: 1 (이 값이 $S[1][1]$에 저장됩니다)
        3. 두 번째 칸 계산 ($i=1, j=2$)
    원본 행렬 $A[1][2]$의 값이 2일 때입니다.
    * 공식: $S[1][2] = S[0][2] + S[1][1] - S[0][1] + A[1][2]$
    * 계산: $0 + 1 - 0 + 2$
    * 결과: 3 (그림의 $S[1][2]$ 위치에 있는 값입니다)
        4. 세 번째 칸 계산 ($i=2, j=1$)
    원본 행렬 $A[2][1]$의 값이 4일 때입니다.
    * 공식: $S[2][1] = S[1][1] + S[2][0] - S[1][0] + A[2][1]$
    * 계산: $1 + 0 - 0 + 4$
    * 결과: 5 (그림의 $S[2][1]$ 위치에 있는 값입니다)
        5. 핵심 예시 칸 계산 ($i=2, j=2$)
    질문하신 그림에서 노란색으로 강조된 $S[2][2]$를 채우는 과정입니다.
    * 공식: $S[2][2] = S[1][2] + S[2][1] - S[1][1] + A[2][2]$
    * 대입: 앞서 구한 $S[1][2]=3$, $S[2][1]=5$, 그리고 중복 영역인 $S[1][1]=1$을 사용합니다.
    * 계산: $3 + 5 - 1 + 1$ (여기서 마지막 $1$은 $A[2][2]$의 값입니다)
    * 결과: 8
     * */
}
