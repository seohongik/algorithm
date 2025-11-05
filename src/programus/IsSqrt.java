public class IsSqrt {

    public long solution(long n) {
        double n1= (double) Math.sqrt(n);
        String b1Str =String.valueOf(n1);
        String b1Decimal = b1Str.substring(b1Str.indexOf(".")+1);
        if(!b1Decimal.equals("0")){
            return -1;
        }

        long n1Plus1 = (long) n1+1;
        double ans = Math.pow(n1Plus1, 2);
        return (long) ans;
    }

    public static void main(String[] args) {
        IsSqrt isSqrt = new IsSqrt();
        long answer = isSqrt.solution(121);
        System.out.println(answer);
        long anser2 =isSqrt.solution(3);
        System.out.println(anser2);
    }
}
