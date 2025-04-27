package inflearnBaisc.ex35;

import java.util.*;

class Solution {

    public int solution(String S, String T) {
        int k = T.length()-1;
        int ans = 0;
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < T.length(); i++) {
            tmap.put(T.charAt(i), tmap.getOrDefault(T.charAt(i), 0) + 1);
        }
        for (int i = 0; i < k; i++) {
            smap.put(S.charAt(i), smap.getOrDefault(S.charAt(i), 0) + 1);
        }
        for (int rt = k ,lt=0; rt < S.length(); rt++,lt++) {
            smap.put(S.charAt(rt), smap.getOrDefault(S.charAt(rt), 0) + 1);
            if(smap.equals(tmap)) {
                ans++;
            }
            smap.put(S.charAt(lt), smap.get(S.charAt(lt)) - 1);
            if(smap.get(S.charAt(lt))==0) smap.remove(S.charAt(lt));
        }
        return ans;
    }
}
public class Main {

    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner kb = new Scanner(System.in);
        String  S =kb.next();
        String  T = kb.next();
        System.out.print(solution.solution(S,T));
    }
}
