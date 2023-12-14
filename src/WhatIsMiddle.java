public class WhatIsMiddle {

        public String solution(String s) {
            int i=0;
            int j=0;
            switch (s.length()%2){
                case 0: i= s.length()/2-1;
                        j=  s.length()/2;
                        break;

                case 1: i = s.length()/2;
                        break;
            }
            if(j==0){
                return String.valueOf(s.charAt(i));
            }else {
                return s.charAt(i)+""+s.charAt(j);
            }
        }
}
