package programus;

import java.util.*;

public class DeliveryBox {

    public int solution(int n, int w, int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <n+w; i++) {

            if(i>n){
                list.add(0);
                continue;
            }
            list.add(i);
        }


        Stack<List<Integer>> stacks = new Stack<>();
        for (int i = 0; i <list.size(); i+=w) {
            if(w+i>list.size()){
                stacks.push(list.subList(i,list.size()));
            }else {
                List<Integer> subList=list.subList(i,w+i);
                stacks.push(subList);
            }
        }

        for (int i = 0; i < stacks.size(); i++) {
            List<Integer> stackI=stacks.get(i);
            if(i%2==1){
                Collections.reverse(stackI);
            }
        }

        if(stacks.get(stacks.size()-1).size()!=w){
            stacks.pop();
        }

        int col = 1;
        List<Integer> rowPosition = new ArrayList<>();
        for (int i = stacks.size()-1; i >=0; i--) {

            int row = stacks.get(i).indexOf(num);
            if(row!=-1){
                rowPosition.add(row);
                break;
            }
            col++;
        }

        System.out.println("stacks = " + stacks);

        if(stacks.get(stacks.size()-1).get(rowPosition.get(0))==0){
            col--;
        }

        return col;
    }

}
