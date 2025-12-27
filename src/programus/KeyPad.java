package programus;

import java.util.*;

public class KeyPad {

    public String solution(int[] numbers, String hand) {
        String[][] keys = new String[][]{
                                         {"1", "2", "3"}
                                        ,{"4", "5", "6"}
                                        ,{"7", "8", "9"}
                                        ,{"*", "0", "#"}
                                        };
        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < keys.length; i++) {
            for (int j = 0; j < keys[i].length; j++) {
                map.put(keys[i][j], i + "," + j);
            }
        }
        String lt = "*";
        String rt = "#";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {

            String key = ""+numbers[i];

            if(key.equals("1") || key.equals("4") || key.equals("7") ) {
                builder.append("L");
                lt = String.valueOf(numbers[i]);
            }
            if(key.equals("3") || key.equals("6") || key.equals("9") ) {
                builder.append("R");
                rt= String.valueOf(numbers[i]);
            }
            if(key.equals("2") || key.equals("5") || key.equals("8") || key.equals("0") ) {
                String leftHand=map.get(lt);
                String rightHand=map.get(rt);
                String number=map.get(key);
                int leftX1 = Integer.parseInt(leftHand.split(",")[0]);
                int rightX1 = Integer.parseInt(rightHand.split(",")[0]);
                int leftY1 = Integer.parseInt(leftHand.split(",")[1]);
                int rightY1 = Integer.parseInt(rightHand.split(",")[1]);
                int numberX1 = Integer.parseInt(number.split(",")[0]);
                int numberY1 = Integer.parseInt(number.split(",")[1]);
                int leftDistance = (int)Math.ceil(Math.hypot(numberX1 - leftX1, numberY1 - leftY1));
                int rightDistance = (int)Math.ceil(Math.hypot(rightX1 - numberX1, rightY1 - numberY1));

                if(leftDistance<rightDistance) {
                    builder.append("L");
                    lt= String.valueOf(numbers[i]);
                }else if(leftDistance>rightDistance) {
                    builder.append("R");
                    rt= String.valueOf(numbers[i]);
                }else {
                    if("left".equals(hand)) {
                        builder.append("L");
                        lt= String.valueOf(numbers[i]);
                    }else if("right".equals(hand)) {
                        builder.append("R");
                        rt= String.valueOf(numbers[i]);
                    }
                }
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {

        KeyPad keyPad = new KeyPad();

        System.out.println(keyPad.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},"right"));
        System.out.println(keyPad.solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left"));
        System.out.println(keyPad.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},"right"));
        System.out.println(keyPad.solution(new int[]{0,0},"right"));
        System.out.println(keyPad.solution(new int[]{0, 5, 8, 2},"left"));
        System.out.println(keyPad.solution(new int[]{2,8,2},"right"));
        System.out.println(keyPad.solution(new int[]{5,5,5,5},"left"));


    }
}
