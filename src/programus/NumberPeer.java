package programus;
import java.util.*;

public class NumberPeer {
    public String solution(String X, String Y) {

        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        int len = Math.max(X.length(), Y.length());

        for (int i = X.length()-1; i < len; i++) {
            X=X.concat("A");
        }
        for (int i = Y.length()-1; i < len; i++) {
            Y=Y.concat("A");
        }

        for (int i = 0; i < len; i++) {
            if (Character.isDigit(X.charAt(i))) {
                xMap.put((int) X.charAt(i) - 48, xMap.getOrDefault((int) X.charAt(i) - 48, 0) + 1);
            }
            if (Character.isDigit(Y.charAt(i))) {
                yMap.put((int) Y.charAt(i) - 48, yMap.getOrDefault((int) Y.charAt(i) - 48, 0) + 1);
            }
        }

        StringBuilder res = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            if(xMap.containsKey(i) && yMap.containsKey(i)) {
               int count=Math.min(xMap.get(i), yMap.get(i));
               for (int j = 0; j < count; j++) {
                   res.append(i);
               }
            }
        }

        if(res.toString().isEmpty()) {
            return "-1";
        }else if(res.toString().startsWith("0")){
            return "0";
        }
        return res.toString();

    }

    public static void main(String[] args) {
        NumberPeer numberPeer = new NumberPeer();
        System.out.println(numberPeer.solution("100","2345"));
        System.out.println(numberPeer.solution("100","203045"));
        System.out.println(numberPeer.solution("100","123450"));
        System.out.println(numberPeer.solution("12321","42531"));
        System.out.println(numberPeer.solution("55255","12552"));
    }
}
