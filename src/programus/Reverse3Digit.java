package programus;

public class Reverse3Digit {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        String  digit3 =Integer.toString(n,3);
        sb.append(digit3);
        sb.reverse();
        String str=String.valueOf(Long.valueOf(sb.toString()));
        int ans = 0;
        for (int i = str.length()-1,pos=1; i >=0; i--,pos*=3) {
            int a = str.charAt(i)-48;
            ans+= a * pos;
        }
        return ans;
    }


    public static void main(String[] args) {
        Reverse3Digit solution = new Reverse3Digit();
        System.out.println(solution.solution(45));
        System.out.println(solution.solution(125));
        System.out.println(solution.solution(0));

    }
}
