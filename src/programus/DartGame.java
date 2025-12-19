package programus;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DartGame {

    public int solution(String dartResult) {
        List<Integer> list = new ArrayList<>();
        int score = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            if (Character.isDigit(dartResult.charAt(i))) {
                score = (int) (dartResult.charAt(i)) - 48;

            }
            if (i >= 1) {
                if (dartResult.charAt(i - 1) == '1' && dartResult.charAt(i) == '0') {
                    score = 10;
                }
            }

            if (dartResult.charAt(i) == '*') {
                list.add(Integer.MAX_VALUE);
            }
            if (dartResult.charAt(i) == '#') {
                list.add(Integer.MIN_VALUE);
            }

            if (dartResult.charAt(i) == 'S') {
                list.add((int) Math.pow(score, 1));
            } else if (dartResult.charAt(i) == 'D') {
                list.add((int) Math.pow(score, 2));
            } else if (dartResult.charAt(i) == 'T') {
                list.add((int) Math.pow(score, 3));
            }
        }
        int index = 0;
        if (list.get(1) == Integer.MAX_VALUE) {
            list.set(0, list.get(0) * 2);
            list.remove(1);
            index = 2;
        }

        while (index < list.size()) {


            if (list.get(index) == Integer.MAX_VALUE) {
                list.set(index - 2, list.get(index - 2) * 2);
                list.set(index - 1, list.get(index - 1) * 2);
                list.remove(index);
                index = 0;
            }

            if (list.get(index) == Integer.MIN_VALUE) {
                list.set(index - 1, list.get(index - 1) * -1);
                list.remove(index);
                index = 0;
            }

            index++;
        }

        return list.stream().mapToInt(i -> i).sum();
    }


    public static void main(String[] args) {
        DartGame game = new DartGame();
        System.out.println(game.solution("1S2D*3T"));
        System.out.println(game.solution("1D2S#10S"));
        System.out.println(game.solution("1D2S0T"));
        System.out.println(game.solution("1S*2T*3S"));
        System.out.println(game.solution("1D#2S*3S"));
        System.out.println(game.solution("1T2D3D#"));
        System.out.println(game.solution("1D2S3T*"));
        System.out.println(game.solution("10D4S10D")); //204
    }

}
