import java.util.*;
import java.util.stream.Collectors;

public class MakeDecimal {

    public int solution(int[] nums) {
        int answer = 0;

        if(nums.length<3){
            return answer;
        }
        Set<String > set=new LinkedHashSet<>();

        for(int i=0; i<nums.length; i++){

            for(int j=1; j<nums.length; j++){

                for(int k=2; k<nums.length; k++){

                    int[] arr = new int[]{nums[i], nums[j], nums[k]};

                    Arrays.sort(arr);

                    if(arr[0]!=arr[1]&& arr[1]!=arr[2]&& arr[0]!=arr[2]) {

                        //System.out.println(arr[0]+","+arr[1]+","+arr[2]);
                        set.add(arr[0]+","+arr[1]+","+arr[2]);
                    }
                }

            }

        }
        Iterator<String > itr = set.iterator();

        while (itr.hasNext()){
            String[] x = itr.next().split(",");

            int n = Integer.parseInt(x[0])+Integer.parseInt(x[1])+Integer.parseInt(x[2]);

            answer+=isPrime(n);

        }
        return answer;
    }

    public  int isPrime(int num){
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return 0;
        }
        return 1;
    }

}
