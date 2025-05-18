package inflearnBaisc.ex44;

import java.util.*;

class Solution {

    public int solution(int n, int m,int[] petitions ){

        Deque<String> seeDoctor = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            seeDoctor.add(petitions[i]+" "+i);
        }

        String meWithTurn = petitions[m]+" "+m;

        int count = 0;

        if(!seeDoctor.isEmpty()) {
            while (true) {

                String firstWithTurn = seeDoctor.removeFirst();
                int first = Integer.parseInt(firstWithTurn.split(" ")[0]);
                List<String> otherPetitions = new ArrayList<>(seeDoctor);

                boolean isHurry= new ArrayList<>(otherPetitions)
                        .stream()
                        .anyMatch(otherPetition ->Integer.parseInt(otherPetition.split(" ")[0])>first);

                if(isHurry){
                    seeDoctor.addLast(firstWithTurn);
                }else {
                    count++;
                }

                if(!seeDoctor.contains(meWithTurn)){
                    break;
                }
            }
        }

        return count;
    }
}

// 이게 답
class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id=id;
        this.priority=priority;
    }
}
// 이게 답
class Solution2{
    public int solution(int n, int m, int[] arr){
        int answer=0;
        Queue<Person> Q=new LinkedList<>();
        for(int i=0; i<n; i++){
            Q.offer(new Person(i, arr[i]));
        }
        while(!Q.isEmpty()){
            Person tmp=Q.poll();
            for(Person x : Q){
                if(x.priority>tmp.priority){
                    Q.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null){
                answer++;
                if(tmp.id==m) return answer;
            }
        }
        return answer;
    }
}

public class  Main {

    public static void main(String[] args){
        Solution T = new Solution();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();
        int[] petitions = new int[n];
        for (int i = 0; i < n; i++) {
            petitions[i] = kb.nextInt();
        }
        System.out.println(T.solution(n,m,petitions));
    }
}
