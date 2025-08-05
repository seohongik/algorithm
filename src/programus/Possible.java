package programus;

public class Possible {

    static int count = 0;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        permute(nums, 0);
        System.out.println("조건을 만족하는 경우의 수: " + count);
    }

    // 순열을 생성하는 메서드
    public static void permute(int[] arr, int depth) {
        if (depth == arr.length) {
            int sumFront = arr[0] + arr[1] + arr[2];
            int sumBack = arr[3] + arr[4] + arr[5];
            if (sumFront > sumBack) {
                count++;
            }
            return;
        }

        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            permute(arr, depth + 1);
            swap(arr, depth, i);  // 백트래킹
        }
    }

    // 배열의 두 값을 바꾸는 메서드
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}


