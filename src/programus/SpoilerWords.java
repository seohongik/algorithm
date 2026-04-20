package programus;

import java.util.*;
import java.util.stream.Collectors;

public class SpoilerWords {
    public int solution(String message, int[][] spoiler_ranges) {
        String[] mask = new String[message.length()];
        for (int i = 0; i < mask.length; i++) {
            mask[i] = message.substring(i, i + 1);
        }

        for (int i = 0; i < message.length(); i++) {

             for (int j = 0; j < spoiler_ranges.length; j++) {
                 boolean add=spoiler_ranges[j][0]<=i&&i<spoiler_ranges[j][1]+1;
                 if(add) {
                    mask[i] = "*";
                 }
                 if(" ".equals(String.valueOf(message.charAt(i)))){
                     mask[i] = " ";
                 }
            }
        }

        StringBuilder sb = new StringBuilder();
        Arrays.stream(mask).forEach(m->{
            sb.append(m);
        });
        String[] masks = sb.toString().split(" ");
        String[] origin = message.split(" ");
        Map<String, Integer > map = new LinkedHashMap<>();

        for (int i = 0; i < origin.length; i++) {

            map.put(origin[i], map.getOrDefault(origin[i], 0) + 1);
            if (masks[i].contains("*")) {
                map.put(origin[i], map.getOrDefault(origin[i], 0) - 1);
            }
        }
        return (int)map.values().stream().filter(i->i<=0).count();
    }

    public static void main(String[] args) {
        SpoilerWords spoilerWords = new SpoilerWords();
        spoilerWords.solution("here is muzi here is a secret message",new int[][]{{0, 3}, {23, 28}});
        spoilerWords.solution("my phone number is 01012345678 and may i have your phone number",  new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}});
    }
}
