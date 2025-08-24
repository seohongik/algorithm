package programus;

import java.util.HashMap;
import java.util.Map;

public class PyCount {

    boolean solution(String s) {
        s = s.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int pCount = map.getOrDefault('p',-1);
        int yCount = map.getOrDefault('y',-1);

        if(pCount == -1 || yCount == -1){
            return false;
        }

        if(pCount==yCount){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PyCount p = new PyCount();
        System.out.println(p.solution("pPoooyY"));

        System.out.println(p.solution("Pyy"));
        System.out.println(p.solution("o"));
    }
}

