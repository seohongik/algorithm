package programus;


import java.util.Arrays;

public class EntryScreening2 {
    public long solution(int n, int[] times) {

        /* n=7 */
        /*times = 7,10;*/
        int max = Arrays.stream(times).max().getAsInt(); // 시간상 최대값 구함
        long lt = 1; // 최소 1
        long rt = (long) max*n; // 최대 시간 * 인원수 예시는 10*6  = 60

        long ans =rt;
        while (lt <= rt) {

            long mid = (lt + rt) / 2; // 1~60 중 중간값 1.] 61/2 = 30 에서 시작 가변함 2.] (1+31)/2 = 16    3.] (17 + 31) /2 = 24

            long count =Arrays.stream(times).mapToLong(x -> mid/x).sum();  // 1.] x = 30/7 + 30/10 = 4+ 3 = 7  2.] 16/7+ 16/10 = 2+1 =3  3.] 24/7 + 24/10 = 3 +2  = 5


            // 1.] 7 < 7 false  rt= 31   2.]  3 < 7 true = lt = mid+1 = 17
            if (count < n) {
                lt = mid + 1;
            } else {
                ans = mid;
                rt = mid - 1;
            }
        }


        return ans;
    }

    public static void main(String[] args) {
        EntryScreening2 entryScreening = new EntryScreening2();
        System.out.println(entryScreening.solution(6, new int[]{7,10}));
    }

}