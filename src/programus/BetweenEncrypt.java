package programus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BetweenEncrypt {

    final int toZLength = 26;
    final int maxLength = 50;
    public String solution(String s, String skip, int index) {
        List<Character> allCharaterList = getCharacters(skip);
        List<String> resultList = new ArrayList<>();

        for (int sIndex=0; sIndex<s.length(); sIndex++) {
            char result = allCharaterList.get(allCharaterList.indexOf(s.charAt(sIndex)) + index);
            resultList.add(String.valueOf(result));
        }

        return resultList.stream().collect(Collectors.joining());
    }

    private List<Character> getCharacters(String skip) {
        final int fromZToMaxLength = toZLength + maxLength;
        List<Character> allCharaterList = new ArrayList<>();
        int i=0;
        char c = 'a';

        while (i <= fromZToMaxLength) {
            if(c>'z') {
                c = (char) 'a';
            }
            allCharaterList.add((char) (c++));
            i++;
        }
        List<Character> skipsItems = new ArrayList<>();
        for (i = 0; i < skip.length(); i++) {
            skipsItems.add(skip.charAt(i));
        }
        allCharaterList.removeAll(skipsItems);
        return allCharaterList;
    }


    public static void main(String[] args) {
        BetweenEncrypt b = new BetweenEncrypt();
        System.out.println(b.solution("aukks", "wbqd", 5));
        System.out.println(b.solution("happy", "wbgd", 5));
        //System.out.println(b.solution("zzz", "aaaa", 1));
        //"aukks"	"wbqd"	5	"happy"
    }
}
