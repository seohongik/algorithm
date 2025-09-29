package programus;
import java.util.Arrays;

public class BoatPeople {

    public int solution(int[] people, int limit) {
        //구명보트를 최대한 적게 사용하여 모든 사람을 구출하려고 합니다.
        Arrays.sort(people); // 정렬
        int ans = 0;
        int start=0; // 투포인터 시작점 증가 변수
        int end=people.length-1; // 투포인터 엔드 점 증가 변수
        while (start<=end){ //
            if(people[start]+people[end]<=limit) { // 둘이 합쳐서 태울수 있는지
                start++; // 태웠으면 가벼운 사람 증가
            }
            end--; // 무게있는 사람은 무조건 감소
            ans++; // 보트 타기
        }
        return ans;
    }

    public static void main(String[] args) {
        //https://school.programmers.co.kr/learn/courses/30/lessons/42885
        BoatPeople boatPeople = new BoatPeople();
        System.out.println(boatPeople.solution(new int[]{1,2,3,4,5,6,7,8,9,10},10)); // [10] [1,9] [2,8] [3,7] [4,6] [5]
        System.out.println(boatPeople.solution(new int[]{70, 50, 80, 50},100)); //3 -> 50 50 70 80 -> [50 50] [70] [80]
        System.out.println(boatPeople.solution(new int[]{70, 80, 50},100)); //3 -> 50 70 80 [50] [70] [80]
    }
}
