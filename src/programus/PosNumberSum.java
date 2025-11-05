public class PosNumberSum {
    public int solution(int n) {
        int answer = 0;

        String str = String.valueOf(n);
        for (int start = 0,end = str.length()-1; start < str.length()/2; start++, end--) {
            answer +=strToInt(str.charAt(start))+strToInt(str.charAt(end));
        }
        int mid = str.length()%2==1 ? strToInt(str.charAt((str.length())/2)):0;
        return answer+mid;
    }
    private int strToInt(Character s) {
        return Integer.parseInt(String.valueOf(s));
    }

    public static void main(String[] args) {
        PosNumberSum obj = new PosNumberSum();
        System.out.println(obj.solution(123));
        System.out.println("obj = " + obj.solution(987));
        System.out.println("obj = " + obj.solution(1111));
    }
}
