package programus;


public class MinModNumber {
    public int solution(int n) {
        int answer = 0;
        for (int i = 1; i <Integer.MAX_VALUE; i++) {
            if(n%i==1){
                return i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        MinModNumber minModNumber = new MinModNumber();
        System.out.println(minModNumber.solution(10));
        System.out.println(minModNumber.solution(12));
    }
}
