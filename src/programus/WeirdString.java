public class WeirdString {
    public String solution(String s) {
        s = s.replaceAll(" ", ",");
        String[] split = s.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<split.length; i++) {
            String word = split[i];
            for (int j = 0; j < word.length(); j++) {

                if(j%2==0){
                    sb.append(Character.toUpperCase(word.charAt(j)));
                }else {
                    sb.append(Character.toLowerCase(word.charAt(j)));
                }

            }

        }

        for (int i=0; i<s.length(); i++){
            if(s.charAt(i)==','){
                sb.insert(i, " ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        WeirdString weirdString = new WeirdString();
        String ans =weirdString.solution("try hello world");
        System.out.println("ans = " + ans);
        System.out.println("ans2 = " + weirdString.solution(" read the explanation carefully  ")); // ReAd ThE ExPlAnAtIoN CaReFuLlY
    }
}
