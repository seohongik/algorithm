import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class HowManyPY {
   public boolean solution(String s) {
       String str=s.toLowerCase(Locale.ROOT);

       if(str.length()<2){

           if(String.valueOf(str.charAt(0)).equals("p")||String.valueOf(str.charAt(0)).equals("y")){
               return false;
           }else {
               return true;
           }
       }

       String [] arr  = new String[str.length()];
       for(int i=0; i<str.length(); i++){
           arr[i] = String.valueOf(str.charAt(i));
       }
       Arrays.sort(arr, (o1, o2) -> {
           return String.valueOf(o2).compareTo(String.valueOf(o1));
       });

       String join=Arrays.asList(arr).stream().collect(Collectors.joining());
       int y1 = join.indexOf("y");
       int y2 = join.lastIndexOf("y");

       int p1 = join.indexOf("p");
       int p2 = join.lastIndexOf("p");

       if(y1==-1 && y2==-1 && p1==-1 && p2==-1){
           return true;
       }
       return isContainsPY( y1,  y2,  p1,  p2,  join);
    }

    private boolean isContainsPY(int y1, int y2, int p1, int p2, String join){
        String strY="";
        String strP="";

        if(y1!=-1 && y2!=-1) {
            strY = join.substring(y1, y2 + 1);
        }

        if(p1!=-1 && p2!=-1) {
            strP = join.substring(p1, p2 + 1);
        }

       if(strY.length()==strP.length()){
            return true;

       }else{
            return false;
       }
    }
}
