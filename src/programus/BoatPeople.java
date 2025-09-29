import java.util.Arrays;

public class BoatPeople {

    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 정렬
        int ans = 0;
        int start=0; // 투포인터 시작점 증가 변수
        int end=people.length-1; // 투포인터 엔드 점 증가 변수
        while (start<=end){ //
            if(people[start]+people[end]<=limit) { // 둘이 합쳐서 테울수 있는지
                start++; // 테웠으면 가벼운 사람 증가
            }
            end--; // 무게있는 사람은 무조건 감소
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/42885
        BoatPeople boatPeople = new BoatPeople();
        boatPeople.solution(new int[]{1,2,3,4,5,6,7,8,9,10},10);
        boatPeople.solution(new int[]{70, 50, 80, 50},100); //3
        boatPeople.solution(new int[]{70, 80, 50},100); //3
    }
}
