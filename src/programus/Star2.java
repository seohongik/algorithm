package progamus;
public class Star2 {

    public static void main(String[] args) {

        /*
         데이터 아래와 같이 만들기
         *****
         ****
         ***
         **
         *

         */
        for (int i = 0; i <5 ; i++) {

            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("=============================");

        /*

         데이터 아래와 같이 만들기
         *
         **
         ***
         ****
         *****

         */

        for (int i = 0; i <5 ; i++) {

            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("=============================");

        /*
        데이터 아래와 같이 만들기
         * * * * *
          * * * *
         * * * * *
          * * * *
         * * * * *

        */


        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 9; j++) {
                if(i%2==0) {
                    if(j%2==0) {
                        System.out.print("*");
                    }else {
                        System.out.print(" ");
                    }
                }else {
                    if(j%2==0) {
                        System.out.print(" ");
                    }else  {
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("=============================");
        /*

        데이터 아래와 같이 만들기
        "*** * ***"
           * * *
             *
        */
        for (int i=1; i <=3 ; i++) {
            for (int j=1; j<=9; j++){
                if(i==1&& (j==4 || j==6)){
                    System.out.print(" ");
                }else if(i==1) {
                    System.out.print("*");
                }else if(i==2&& (j==3 || j==5 || j==7)){
                    System.out.print("*");
                }else if(i==2) {
                    System.out.print(" ");
                }else if(j == 5){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        /*

             *
            ***
           *****
          *******
         *********

         000010000
         000111000
         001111100
         011111110
         111111111

       */
        System.out.println("=============================");
        int back = 10/2;
        int prev = 10/2;
        for (int i = 1; i <=5 ; i++) {
            for (int j =1; j <= 9; j++) {
                /* 1 2 3 4  6 7 8 9
                   1 2 3      7 8 9
                   1 2          8 9
                   1              9
                */
                if(back<=j&&j<=prev) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            back--;
            prev++;
            System.out.println();

        }
        System.out.println("=============================");
        // 이런 방식도 있다. 이게 오히려 수학적 사고를 해게해서 더 좋은 코드인거 같다.(인터넷 펌)
        // 1. 총 몇 줄 돌리나? 5줄!
        for (int i=0; i<5; i++) {

            // 2. 공백의 변화 : 4-3-2-1-0
            for (int j=0; j<5-i ; j++) {
                System.out.print(" ");
            }

            // 3. 별표의 변화 : 1-3-5-7-9
            for (int k=0; k< 2*i +1; k++) {
                System.out.print("*");
            }

            //공백과 별표가 한 차례씩 찍히고 나면 줄바꿈을 해야 한다.
            System.out.println();

        } // 1번 for문 닫음 

    }

}
