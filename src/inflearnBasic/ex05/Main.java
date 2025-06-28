package inflearnBasic.ex05;

import java.util.Scanner;

class Solution{

    public String solution(String s) {
        //char[] array = s.toCharArray();
        //StringBuilder sb = new StringBuilder();
       /* for (int i=0;  i<array.length; i++){
            for (int j=i+1; j<array.length; j++) {

                if (String.valueOf(array[i]).matches("[^a-zA-Z]*$")) {
                    continue;
                }

                if (String.valueOf(array[j]).matches("[^a-zA-Z]*$")) {
                    continue;
                }
                if (String.valueOf(array[i]).matches("^[a-zA-Z]*$")
                        || String.valueOf(array[j]).matches("^[a-zA-Z]*$")) {
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            sb.append(array[i]);

        }*/

        String[] array = s.split("");

        // 어떻게 푼거지???
        int start = 0;
        int end = array.length-1;
        while (start <end) {

            if ((array[start]).matches("[a-zA-Z]*") && !(array[end]).matches("[a-zA-Z]*")) {
                end--;
                continue;
            }else if (!(array[start]).matches("[a-zA-Z]*") && (array[end]).matches("[a-zA-Z]*")) {
                start++;
                continue;
            }else if(!(array[start]).matches("[a-zA-Z]*") && !(array[end]).matches("[a-zA-Z]*")) {
                start++;
                end--;
                continue;
            }else if((array[start]).matches("[a-zA-Z]*") && (array[end]).matches("[a-zA-Z]*")) {
                String temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }else {
                String temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
            start++;
            end--;

        }
        return String.join("", array);
    }

}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        String result = solution.solution(sc.nextLine());
        System.out.println(result);

    }
}
