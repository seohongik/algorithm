package inflearnBaisc.star;

import java.util.Random;

interface Process {
    public void run();
}

class Solution  {

    public void Hello(Process process) {
        System.out.println("Hello");
        process.run();
        System.out.println("World");
    }
}

class Dice implements Process {

    @Override
    public void run() {
        System.out.println(new Random().nextInt(6)+1);
    }
}

class Sum implements Process {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Solution solution = new Solution() ;
        solution.Hello(new Dice());
        solution.Hello(new Sum());

    }
}

