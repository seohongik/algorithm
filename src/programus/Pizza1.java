package programus;

public class Pizza1 {
    public int solution(int n) {
        return (int) Math.ceil((double) n /7);
    }

    public static void main(String[] args) {
        Pizza1 p = new Pizza1();
        System.out.println(p.solution(15));
    }
}
