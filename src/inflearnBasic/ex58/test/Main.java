package inflearnBasic.ex58.test;


class Solution {

    static int count = 0;
    int n;
    boolean[] printable;
    public void  solution(int tree) {


        if(tree<=0) {
            System.out.println("출력으로  " + tree);
            for (int i = 0; i < printable.length; i++) {
               if(printable[i]) {
                   System.out.print((i+1)+ " ");
               }
            }
            System.out.println();

        }else {

            System.out.println( "1스텍 위");
            printable[tree-1] = true;
            solution(tree-1);
            printable[tree-1] = false;
            System.out.println( "1스텍 아래 2스텍 위");
            solution(tree-1);
            System.out.println( "2스텍 아래");

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
        sol.solution(sol.n);


    }
}