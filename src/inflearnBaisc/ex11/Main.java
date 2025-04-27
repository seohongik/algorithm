package inflearnBaisc.ex11;

import java.util.*;

class Solution{

    public String solution(String s) {
        List<String> list = Arrays.asList(s.split(""));
        List<String> jugmentList = new ArrayList();
        StringBuilder  stringBuilder = new StringBuilder();

        jugmentList.add(list.get(0));
        jugmentList.add(list.get(1));

        int size=1;
        if(jugmentList.get(jugmentList.size()-2).equals( jugmentList.get(jugmentList.size()-1) )  ){
            size++;
        }else{
            stringBuilder.append(jugmentList.get(jugmentList.size()-2));
        }
        for(int i=2; i<list.size(); i++){
            jugmentList.add(list.get(i));
            if(jugmentList.get(jugmentList.size()-2).equals( jugmentList.get(jugmentList.size()-1) )  ){
                size++;
            }else{
                stringBuilder.append(jugmentList.get(jugmentList.size()-2)).append(size);
                size=1;
            }
        }
        if(jugmentList.get(jugmentList.size()-2).equals( jugmentList.get(jugmentList.size()-1) )  ){
            stringBuilder.append(jugmentList.get(jugmentList.size()-1)).append(size);
        }else{
            stringBuilder.append(jugmentList.get(jugmentList.size()-1));
        }
        return stringBuilder.toString().replace("1","");
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