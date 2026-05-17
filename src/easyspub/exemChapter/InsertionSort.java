package easyspub.exemChapter;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        answerSolution();
    }

    private static void mySolution() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }else {
                    // 내 왼쪽 놈이 나보다 작거나 같다면 이미 정렬된 구역이므로
                    // 더 이상 왼쪽으로 갈 필요 없이 멈춥니다. (삽입 정렬의 핵심!)
                    break;
                }
            }
        }
        int[] sumArr = new int[N];
        sumArr[0] = arr[0];
        for (int i =1; i <N; i++) {
            sumArr[i] = sumArr[i-1] +arr[i];
        }
        int sum = Arrays.stream(sumArr).sum();
        System.out.println(sum);
    }


    private static void answerSolution() {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 1; i < N; i++) {
            int insert_point = i;
            int insert_value = arr[i];
            for (int j = i-1; j >=0; j--) {
                if(arr[j] <arr[i]) {
                    insert_point = j+1;// 내 앞(j)에 나보다 작은 놈이 있으니, 내 자리는 바로 그 오른쪽(j+1)이다!
                    break;
                }
                if(j==0){
                    insert_point = 0;
                }
            }

            for (int j = i; j >insert_point; j--) {
                arr[j] = arr[j-1]; // 삽입 시켜놓고 데이터 밀기
            }
            arr[insert_point] = insert_value; // 값 넣기
        }
        System.out.println(Arrays.toString(arr));
        int[] sumArr = new int[N];
        sumArr[0] = arr[0];
        for (int i =1; i <N; i++) {
            sumArr[i] = sumArr[i-1] +arr[i];
        }
        int sum = Arrays.stream(sumArr).sum();
        System.out.println(sum);
    }
}
