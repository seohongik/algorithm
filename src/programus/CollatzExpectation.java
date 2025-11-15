package programus;

public class CollatzExpectation {
    public int solution(int num) {
        if(num==1){
            return 0;
        }
        int answer = 0;
        while (num!=1 && answer!=500) {
            if(num % 2 == 0) {
                num /= 2;
            }else if(num % 2==1) {
                num*=3;
                num+=1;
            }
            answer++;
        }
        if(answer==500){
            return -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        CollatzExpectation collatzExpectation = new CollatzExpectation();
        System.out.println(collatzExpectation.solution(6));
        System.out.println(collatzExpectation.solution(16));
        System.out.println(collatzExpectation.solution(626331));

    }
}
