import java.util.Arrays;

public class FindDecimal {

    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<=n; i++) {
            answer+=isPrime(i);
        }
        return answer;
    }

    public  int isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return 0;
        }
        return 1;
    }
}
