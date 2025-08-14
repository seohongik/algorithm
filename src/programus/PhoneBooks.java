package programus;

import java.util.*;

public class PhoneBooks {

    //예전에 통과했지만 지금 테케 추가로 인한 실패 처음번호 -> 어떤 번호 던지 ..
    public boolean solution(String[] phone_book) {
        if(phone_book.length==1){
            return true;
        }
        String prefix = phone_book[0];
        Map<String,Integer> map = new TreeMap<>();

        for(int i=1; i<phone_book.length; i++) {
            if(phone_book[i].contains(prefix)){
                prefix= phone_book[i];

            }
            String str= phone_book[i].replaceAll("\\s","").replaceAll(prefix,"A,");
            if(str.contains(String.valueOf("A,"))){

                String[] a = str.split(",");
                map.put(a[0],i);
                break;
            }
        }
        if(map.get("A")!=null){
            return false;
        }
        return true;
    }

    /*
    전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
    전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

    구조대 : 119
    박준영 : 97 674 223
    지영석 : 11 9552 4421
    전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
    어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
    * */
    public boolean solution2(String[] phone_book) {

        if(phone_book.length==1){
            return false;
        }

        /*
        Arrays.sort(phone_book, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.length()-o1.length();
            }
        });*/

        Arrays.sort(phone_book, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(Arrays.toString(phone_book));

        for (int i = 0,j=1; j < phone_book.length; i++, j++) {

            String prefix = phone_book[i];
            String others = phone_book[j];
            boolean startsWith = others.startsWith(prefix);

            if(startsWith){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PhoneBooks p = new PhoneBooks();
        String[] phone_book = {"119", "97674223", "1195524421"};
        boolean result =p.solution2(phone_book);
        System.out.println(result);
    }
}
