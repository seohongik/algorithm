package inflearnBasic.ex58.test;


class Solution {

    public void  solution(int tree) {


        if(tree<=0) {

            System.out.println("4    tree " + tree );

        }else {

            System.out.println("1    tree " + tree );
            solution(tree-1);
            System.out.println("2    tree " + tree );
            solution(tree-1);
            System.out.println("3    tree " + tree );
            System.out.println();

        }
        return;
    }

}

class Main{

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.solution(3);


    }
}