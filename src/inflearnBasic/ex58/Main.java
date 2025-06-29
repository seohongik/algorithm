package inflearnBasic.ex58;


import java.util.Arrays;

class Solution {

    int n;
    boolean[] printable;
    public void  solution(int tree) {

        if(tree == n+1) {

           for (int i = 0; i < printable.length; i++) {
               if(printable[i]) {
                   System.out.print((i+1)+ " ");
               }
           }
           System.out.println();

        }else {
            printable[tree-1] = true;

            System.out.println( "첫번째 사이클 "+tree+"  "+  printable[tree-1] +" " +"찍히는 값 :: "+tree);

            solution(tree+1);

            System.out.println( "두번째 사이클 "+tree+"  "+  printable[tree-1] +" " +"찍 찍히는 값 :: "+tree);

            printable[tree-1] = false;

            System.out.println( "셋번째 사이클 "+tree+"  "+  printable[tree-1] +" " +"안 찍히는 값 :: "+tree);

            solution(tree+1);

            System.out.println( "넷번째 사이클 "+tree+"  "+  printable[tree-1] +" " +"안 찍히는 값 :: "+tree);

        }

        return;
    }

}

class Main{

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.n = 3;
        sol.printable = new boolean[sol.n];
        sol.solution(1);


    }
}