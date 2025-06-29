package inflearnBasic.ex58;


import java.util.Arrays;

class Solution {

    static int count = 0;
    int n;
    boolean[] printable;
    public void  solution(int tree) {


        if(tree == n+1) {
            System.out.println("출력으로  " + tree);
            for (int i = 0; i < printable.length; i++) {
               if(printable[i]) {
                   System.out.print((i+1)+ " ");
               }
            }
            System.out.println();

        }else {

            System.out.println( "1스텍 위  "+tree+"  "+  printable[tree-1] +" " +"안 찍히는 값 :: "+tree);
            printable[tree-1] = true;
            System.out.println( "상태 값 변경 "+  printable[tree-1] +" 변경 인덱스  "+ tree);
            solution(tree+1);
            printable[tree-1] = false;
            System.out.println( "1스텍 아래 2스텍 위  "+tree+"  "+  printable[tree-1] +" " +"찍히는 값 :: "+tree);
            System.out.println( "상태  값 변경 "+  printable[tree-1] +" 변경 인덱스  "+ tree);
            solution(tree+1);
            System.out.println( "2스텍 아래  "+tree+"  "+  printable[tree-1]);

        }
        count++;
        System.out.println("count = " + count);

        System.out.println("출발점은" );
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