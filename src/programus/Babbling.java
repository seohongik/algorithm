package programus;

import java.util.ArrayList;
import java.util.List;


public class Babbling {
    public int solution(String[] babbling) {
        String[] babblingAvailable = new String[]{"aya", "ye", "woo", "ma"};
        List<String> babblingList = new ArrayList<>();
        for (int i = 0; i < babblingAvailable.length; i++) {
            char[] babblingChars = babblingAvailable[i].toCharArray();
            babblingList.add(String.valueOf(babblingChars));
        }

        int counter = 0;
        for (int i = 0; i < babbling.length; i++) {
            char[] chars = babbling[i].toCharArray();
            String babblingString = new String(chars);
            for (int j = 0; j < babblingList.size(); j++) {

                if(babblingString.contains(babblingList.get(j))) {
                    babblingString=babblingString.replaceAll(babblingList.get(j), String.valueOf((i+j)));
                }else {
                    continue;
                }
                if(babblingString.chars().allMatch(Character::isDigit)) {
                    counter++;
                }

            }

        }
        return counter;
    }
    public static void main(String[] args) {
        Babbling babbling = new Babbling();
        System.out.println(babbling.solution(new String[]{"aya", "yee", "u", "maa", "wyeoo"})); //1
        System.out.println("---------------");
        System.out.println(babbling.solution(new String[]{"ayaye", "uuuma", "ye", "yemawoo", "ayaa"})); //3

    }
}
