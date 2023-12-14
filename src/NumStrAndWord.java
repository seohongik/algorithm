import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumStrAndWord {


    public int solution(String s) {
        Map<Integer,String> map = new HashMap<>();

        String str = "";

        for(int i=0; i<s.length(); i++){
            str+=s.charAt(i);
            map.put(i,str); // key중복 되면 엎어치니까 중복안되게 i 값 담고 replace 엎어처진 str을 계속 담는다.

            if(map.get(i).contains("zero")){

                str=map.get(i).replace("zero","0");
            }else if(map.get(i).contains("one")){

                str=map.get(i).replace("one","1");
            }else if(map.get(i).contains("two")){

                str=map.get(i).replace("two","2");
            }else if(map.get(i).contains("three")){

                str=map.get(i).replace("three","3");
            }else if(map.get(i).contains("four")){

                str=map.get(i).replace("four","4");
            }else if(map.get(i).contains("five")){

                str=map.get(i).replace("five","5");
            }else if(map.get(i).contains("six")){

                str=map.get(i).replace("six","6");
            }else if(map.get(i).contains("seven")){

                str=map.get(i).replace("seven","7");
            }else if(map.get(i).contains("eight")){

                str=map.get(i).replace("eight","8");
            }else if(map.get(i).contains("nine")){

                str=map.get(i).replace("nine","9");
            }
        }

        if(map.get(map.size()-1).contains("zero")){

            str=map.get(map.size()-1).replace("zero","0");
        }else if(map.get(map.size()-1).contains("one")){

            str=map.get(map.size()-1).replace("one","1");
        }else if(map.get(map.size()-1).contains("two")){

            str=map.get(map.size()-1).replace("two","2");
        }else if(map.get(map.size()-1).contains("three")){

            str=map.get(map.size()-1).replace("three","3");
        }else if(map.get(map.size()-1).contains("four")){

            str=map.get(map.size()-1).replace("four","4");
        }else if(map.get(map.size()-1).contains("five")) {

            str = map.get(map.size() - 1).replace("five", "5");
        }else if(map.get(map.size()-1).contains("six")){

            str=map.get(map.size()-1).replace("six","6");
        }else if(map.get(map.size()-1).contains("seven")){

            str=map.get(map.size()-1).replace("seven","7");
        }else if(map.get(map.size()-1).contains("eight")){

            str=map.get(map.size()-1).replace("eight","8");
        }else if(map.get(map.size()-1).contains("nine")){

            str=map.get(map.size()-1).replace("nine","9");
        }

        return Integer.parseInt(str);
    }


}
