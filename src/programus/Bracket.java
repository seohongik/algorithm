package programus;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Bracket {
    public int solution(int n, int a, int b){
        double first = a;
        double last = b;
        int count =0;
        while (first!=last){
            first =  Math.ceil( first /2);
            last =  Math.ceil( last /2);

            count++;
        }

        return count;
    }

}
