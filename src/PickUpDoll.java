
import java.util.*;
import java.util.stream.Collectors;

public class PickUpDoll {
    public  int solution(int[][] board, int[] moves) {
        int answer = 0;
        Map<Integer, Deque<Integer>> map = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            Deque<Integer> deque = new LinkedList<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] != 0) { // 0을 없는거니까 빠빠이

                    deque.add(board[j][i]); // 행렬 바꿔서 즉 가로를 세로로 마방진에 인형들을 바꿔 담는다. => 기본적으로 i,j로 하면 가로로 되기 때문에 j, i로 만든다.
                }
            }
            map.put(i + 1, deque); // 담을거야 맵에 뭘?? 무브스를 키로 잡고 마방진에 담았던 인형을
        }

        List<Integer> keyList = map.keySet().stream().collect(Collectors.toList());
        List<Integer> reslt = new LinkedList<>();

        for (int i = 0; i < moves.length; i++) { //무브스 만큼 돌리는데
            for (int j = 0; j < map.size(); j++) {
                if (moves[i] == keyList.get(j)) { // 무브스와 맵의 키 즐 무브스가 같으면
                    Deque<Integer> pickUpStack = map.get(keyList.get(j));
                    if (pickUpStack.isEmpty()) { //만약 비워져 있으면 패스
                        continue;
                    }
                    reslt.add(pickUpStack.getFirst());  //픽업 해서 결과(바스켓)에 담을거야
                    pickUpStack.poll();
                }
            }
        }

        int idx = 1;
        if(reslt.size()<=2){ //결과(바스켓)이 2개면 다른게 두개인거니까 두개가 터질게 없으니까 0
            return 0;
        }

        while (idx < reslt.size()) { //idx는 두번재 (1)부터 결과(바스켓)사이즈 만큼 돌릴건데
            if (reslt.indexOf(reslt.get(idx - 1)) == reslt.indexOf(reslt.get(idx))) { // 전 거랑 지금꺼 2개씩 비교해서 인덱스 가 같다는건 연달아 있는거니 터트릴거야

                reslt.remove(idx);  //같은거면 양쪽 지우고 터진개수 2개추가
                reslt.remove(idx - 1);
                answer += 2;
                idx = 0; //다시 0으로
            }
            reslt = reslt.stream().mapToInt(i -> i).boxed().collect(Collectors.toList());// 그 터진 리절트를 (그런 사이즈가 다시 작겠지?) 엎어치나 매치나 엎어쳐서 돌릴거야
            idx++;
        }

        if(reslt.size()<=2){ // 와일 빠져나고 2개거나 이하면 리턴 증가시켰던 엔서 리턴
            return answer;
        }


        if ((reslt.get(reslt.size() - 2)) == reslt.get(reslt.size() - 1)) { // 다돌고 잔량처리 해서 앞뒤가 같으면 터르림
            answer += 2; //터졌으니까 두개 증가
        }
        return answer;
    }


}
