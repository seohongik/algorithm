package programus;

public class Distance {

    // 빈 수레로는 하루에 60리를 가고 짐을 가득 싫었을 때는 하루에 40리를 갈 수 있다. 곡식을 가득 싣고 창고까지 3일 동안 2번 다녀왔다면 창고까지의 거리는 얼마일까?

    public int solution(int X,int a, int b) {
        while (true){

            if(((double) (2 * X) /a)+((double) (2 * X) / b)==3.0){
                break;
            }
            X++;
        }
        return X;
    }


    public static void main(String[] args) {

        Distance d = new Distance();
        System.out.println(d.solution(1,60,40));
    }
}
