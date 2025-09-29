package progamus;
public class Star2 {
    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            for (int j = i; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("=============================");
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j < i+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println("=============================");
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
        데이터 아래와 같이 만들기
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
    }
}
