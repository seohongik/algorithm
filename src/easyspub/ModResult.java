package easyspub;

public class ModResult {

    private static final int  MOD_NUMBER = 10_007;

    public static void main(String[] args) {
        System.out.println(wrong()); // long 자료형을 초과해서 오류 오퍼플로우 발생
        System.out.println(right());
    }

    private static long wrong(){
        long answer = 1;
        for (int i = 1; i <=50; i++) {
            answer *=i;
        }
        return answer%MOD_NUMBER;
    }

    private static long right(){
        // 곱셈 법칙을 이용
        long answer = 1;
        for (int i = 1; i <=50; i++) {
            answer =(answer * i)%MOD_NUMBER;
            // 또는 answer= ((answer%MOD_NUMBER) * (i%MOD_NUMBER))%MOD_NUMBER;
        }
        // 위의 로직은 합 차 곱 모두 됨( 단 나누기만 안됨);
        return answer;
    }

}
