package programus;

public class Pizza3 {

    public int solution(int slice, int n) {


        System.out.println(gcd(2, n)+" "+gcd(10, n));
        return -1;
    }
    // 최대공약수(GCD)를 구하는 유클리드 호제법 함수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수(LCM)를 구하는 함수
    public static int lcm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0; // 두 수 중 하나라도 0이면 LCM은 0입니다.
        }
        // LCM(a, b) = (a * b) / GCD(a, b)
        return Math.abs(a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        Pizza3 p = new Pizza3();
        System.out.println(p.solution(7, 10));
        System.out.println(p.solution(4, 12));
        //System.out.println(p.solution(3, 2));
    }
}
