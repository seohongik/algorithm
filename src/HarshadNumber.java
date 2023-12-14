import com.sun.security.auth.UnixNumericGroupPrincipal;

public class HarshadNumber {
    int sum;
    public boolean solution(int x) {
        String str = String.valueOf(x);

        if(str.length()==1){
            return true;
        }

        for(int i = 0, j = i ; j<str.length(); i++,j++){
            sum+=((str.charAt(i)-48)+(str.charAt(i)-48));
        }

        System.out.println(sum);
        if(x%(sum/2)==0){
            return true;
        }else{
            return false;
        }
    }
}
