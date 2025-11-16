package programus;
import java.util.Arrays;
public class SpanXCountN {

    // 시간 초과
    /*
    public long[] solution(int x, int n) {
        final List<Long> list = new ArrayList<>();

        int a = x>=0 ? x : -x;
        LongStream.range(a, (long) a *n+1).forEach(i -> {
            if(i%x==0){ list.add(i);}
        });
        if(x<0){
           return list.stream().map(i->i*-1).mapToLong(Long::intValue).toArray();
        }
        return list.stream().mapToLong(Long::intValue).toArray();
    }*/

    public long[] solution(int x, int n) {
        long[] ans = new long[n];
        if(x==0){
            return ans;
        }
        int count=0;
        int a = Math.abs(x);
        for (long i = a; i < (long) a *n+1; i+=a) {
            if(a<=i){
                ans[count]=i;
            }
            if(count==n){
                break;
            }
            count++;
        }
        if(x<0){
           return Arrays.stream(ans).map(i->i*-1).toArray();
        }
        return ans;
    }

    public static void main(String[] args) {

        SpanXCountN solution = new SpanXCountN();
        System.out.println(Arrays.toString(solution.solution(2, 5)));
        System.out.println(Arrays.toString(solution.solution(4, 3)));
        System.out.println(Arrays.toString(solution.solution(-4, 2)));
        System.out.println(Arrays.toString(solution.solution(0, 2)));
    }
}
