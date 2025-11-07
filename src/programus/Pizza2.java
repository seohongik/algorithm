package programus;

public class Pizza2 {
    public int solution(int n) {
        int gcd = gcd(6, n);      // 최대공약수
        int lcm = (6 * n) / gcd;     // 최소공배수
        return lcm / 6;              // 필요한 피자 판 수
    }

    // 최대공약수(GCD) 구하기 (유클리드 호제법)
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        Pizza2 p = new Pizza2();
        //System.out.println(p.solution(6));
        System.out.println(p.solution(10));
        System.out.println(p.solution(4));

    }
}
