package programus;

import java.util.*;

public class SetAndQueries {

    // 로직은 맞는거 같은데 시간 초과 때문에 중단
    public String[] solution(int n, int[][] queries) {
        List<String> results = new ArrayList<>();

        List<Set<Integer>> lists = new ArrayList<>();
        for (int i=0; i<n; i++) {
            Set<Integer> list = new HashSet<>();
            for (int j=0; j<1; j++){
                list.add(i);
            }
            lists.add(list);
        }

        for (int i=0; i<queries.length; i++) {
            int firstValue = queries[i][0];
            int x  =  queries[i][1];
            int y  =  queries[i][2];

            for (int j = 0; j < lists.size(); j++) {
                 if(firstValue==3) {
                     boolean found = false;
                     for (Set<Integer> s : lists) {
                         if (s.contains(x) && s.contains(y)) {
                             results.add("Yes");
                             found = true;
                             break;
                         }
                     }
                     if (!found) results.add("No");
                     break;
                 }else if (firstValue == 2) {
                     int size = lists.size();

                     // x와 y가 속한 집합 찾기
                     Set<Integer> targetSet = null;
                     for (int k = 0; k < size; k++) {
                         Set<Integer> s = lists.get(k);
                         if (s.contains(x) && s.contains(y)) {
                             targetSet = s;
                             break;
                         }
                     }

                     if (targetSet != null) {
                         // 새로운 집합 생성
                         Set<Integer> newSet = new HashSet<>();

                         // 임시 리스트로 원소 이동
                         Set<Integer> toRemove = new HashSet<>();
                         for (int val : targetSet) {
                             // x와 y 포함한 범위 원소 선택
                             if (val == x || val == y) {
                                 newSet.add(val);
                                 toRemove.add(val);
                             }
                         }

                         // 기존 집합에서 제거
                         targetSet.removeAll(toRemove);

                         // 새로운 집합 리스트 끝에 추가
                         lists.add(newSet);
                     }
                     break;

                 }else if(firstValue==1) {

                     int size = lists.size();
                     for (int k = 0; k < size; k++) {
                         for (int t = 0; t < size; t++) {
                             if (k == t) continue; // 같은 집합이면 skip
                             Set<Integer> stackX = lists.get(k);
                             Set<Integer> stackY = lists.get(t);

                             if (stackX.contains(x) && stackY.contains(y)) {
                                 stackX.addAll(stackY);
                                 stackY.clear();
                             }
                         }
                     }
                     break;
                 }

                lists.removeIf(Set::isEmpty);   // 제거된 빈 스택 삭제
            }

        }

        return results.toArray(new String[0]);
    }


    // 인공지능 코드 // 일반 링크드해쉬맵으로 짜줬는데 -> 서브맵 사용을 위한 트리맵으로 변경 -> 그리고 다시 set이용 방식으로 그러나 시간초과
    public String[] solution2(int n, int[][] queries) {
        List<Set<Integer>> sets = new ArrayList<>();
        Map<Integer, Integer> insertedAt = new HashMap<>(); // 원소 -> 삽입 쿼리 번호
        for (int i = 0; i < n; i++) {
            Set<Integer> s = new HashSet<>();
            s.add(i);
            sets.add(s);
            insertedAt.put(i, 0); // 초기 원소는 쿼리 0번 시점
        }

        List<String> results = new ArrayList<>();
        int queryIndex = 0;

        for (int[] q : queries) {
            queryIndex++;
            int type = q[0];
            int x = q[1];
            int y = q[2];

            if (type == 1) { // union
                Set<Integer> setX = null, setY = null;
                for (Set<Integer> s : sets) {
                    if (s.contains(x)) setX = s;
                    if (s.contains(y)) setY = s;
                }
                if (setX != null && setY != null && setX != setY) {
                    setX.addAll(setY);
                    sets.remove(setY);
                }
                insertedAt.put(y, queryIndex);

            } else if (type == 2) { // split (구간 필터링)
                Set<Integer> target = null;
                for (Set<Integer> s : sets) {
                    if (s.contains(x) && s.contains(y)) {
                        target = s;
                        break;
                    }
                }
                if (target != null) {
                    int t1 = insertedAt.get(x);
                    int t2 = insertedAt.get(y);
                    int left = Math.min(t1, t2);
                    int right = Math.max(t1, t2);

                    Set<Integer> newSet = new HashSet<>();
                    Iterator<Integer> it = target.iterator();
                    while (it.hasNext()) {
                        int val = it.next();
                        int t = insertedAt.getOrDefault(val, 0);
                        if (t >= left && t <= right) {
                            newSet.add(val);
                            it.remove();
                        }
                    }
                    if (!newSet.isEmpty()) {
                        sets.add(newSet);
                    }
                }

            } else if (type == 3) { // check
                boolean found = false;
                for (Set<Integer> s : sets) {
                    if (s.contains(x) && s.contains(y)) {
                        found = true;
                        break;
                    }
                }
                results.add(found ? "Yes" : "No");
            }
        }

        return results.toArray(new String[0]);
    }

    public static void main(String[] args) {
        SetAndQueries setAndQueries = new SetAndQueries();
        int[][] queries = {{3, 2, 3}, {1, 3, 2}, {3, 2, 3}, {1, 2, 0}, {3, 0, 1}, {2, 2, 0}, {3, 2, 3}, {3, 0, 2}};
        String[] result = setAndQueries.solution(4, queries);

        System.out.println(Arrays.toString(result));//["No", "Yes", "No", "No", "Yes"]

    }

}
