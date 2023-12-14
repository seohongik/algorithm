public class AttractionPrice {
    public long solution(int price, int money, int count) {
        long answer = 0L;
        int sum=0;
        for(int i=1; i<=count; i++){

            sum+=(price);
            answer+=sum;
        }

        if (answer==money){
            return answer;
        }

        answer = answer-money;

        if(answer<0){
            return 0;
        }

        return answer;
    }
}
