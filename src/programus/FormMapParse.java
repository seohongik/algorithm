package programus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FormMapParse {
    public void solution(List<Map<String, List<String>>> data) {
        // 만약 value size가 다르면 여기서 temp값 padding처서 가공해서 각 사이즈 똑같이 만들어 주면 됨
        
        sol1(data);
        sol2(data);
        sol3(data);
        sol4(data);
        sol5(data);
        // 만약 AJAX였으면 [{sn=1,yn=4},{sn=2,yn=5},{sn=3,yn=6}]= 으로 넘어왔기에
        // objectMapper 로 keySet().toString(); 받아서 json 파싱하고 걍 for문 돌려서 넣으려고 함.

        return;
    }

    public void sol1(List<Map<String, List<String>>> data){
        List<Map<String, String>> result1 = new ArrayList<>();

        String[] keys2 = new String[]{"sn","yn"};
        for (int i = 0; i<data.get(0).get(keys2[0]).size();i++) {
            Map<String, String> map = new LinkedHashMap<>();
            for (int j =0; j<keys2.length; j++){

                String value = data.get(j).get(keys2[j]).get(i);
                map.put(keys2[j],value);
            }
            result1.add(map);
        }

        System.out.println("result1 = " + result1);
    }

    public void sol2(List<Map<String, List<String>>> data){

        List<List<String>> valuesList = new ArrayList<>();
        List<Map<String, String>> result = new ArrayList<>();
        List<String> keys =List.of("sn","yn"); // value 먼저 파싱하고 인서트 이러려면 filter걸어 줬어야함 inputname 필요한 값만 처리하려고 했습니다.

        List<Map<String, List<String>>> parseMapList = new ArrayList<>();
        data.stream().forEach(linkedHashMap -> {
            linkedHashMap.entrySet().stream().filter(entry -> keys.contains(entry.getKey())).forEach(entry -> {
                parseMapList.add(Map.of(entry.getKey(),entry.getValue())); // 불변
            });
        });

        for (int i = 0; i <parseMapList.size(); i++) {
            for (int j = 0; j < parseMapList.get(i).size();j++){
                valuesList.add(parseMapList.get(i).get(keys.get(i)));
            }
        }

        for (int j = 0; j < valuesList.get(0).size(); j++) {
            Map<String, String> map = new LinkedHashMap<>();
            for (int k = 0; k < keys.size(); k++) {
                map.put(keys.get(k), valuesList.get(k).get(j));
            }
            result.add(map);
        }

        System.out.println("result2 = " + result);
    }

    public void sol3(List<Map<String, List<String>>> data){

        // Collectors.groupBy는 인덱스 기준으로 안묶임 이건 못해서 다른방법으로 gpt한테 배움
        List<String> keys = List.of("sn","yn");
        int size = data.get(0).get(keys.get(0)).size();

        LinkedHashMap<Integer, Map<String, String>> result = IntStream.range(0, size)
                .boxed()
                .collect(Collectors.toMap(
                        i -> i,
                        i -> {
                            Map<String, String> innerMap = new LinkedHashMap<>();
                            innerMap.put("sn", data.get(0).get(keys.get(0)).get(i));
                            innerMap.put("yn", data.get(1).get(keys.get(1)).get(i));
                            return innerMap;
                        },
                        (a, b) -> a,  // 병합 함수 (중복키 없으니 무의미)
                        LinkedHashMap::new  // 결과로 LinkedHashMap 생성
                ));

        System.out.println("result3 = " + result);

    }

    public void sol4(List<Map<String, List<String>>> data){
        // 반대로 풀어보기 key 먼저 value 나중에
        Stack<Integer> stack = new Stack<>();
        List<String> keys = List.of("sn","yn");
        for (int i=0; i<keys.size(); i++){
            int count = 0;
            for (int j =0; j<data.get(0).get(keys.get(0)).size();j++) {
                stack.push(count);
                count++;
            }
        }
        stack.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        List<Map<String,String>> list = new ArrayList<>();
        while(!stack.isEmpty()){
            Map<String,String> map = new LinkedHashMap<>();
            for (int i=0; i<keys.size(); i++) {
                String key = keys.get(i);
                String value = data.get(i).get(key).get(stack.pop());
                map.put(key,value);
            }
            list.add(map);
        }
        System.out.println("result4 = "+list);
    }
    
    public void sol5(List<Map<String, List<String>>> data){

        List<Map<String, String>> result = new ArrayList<>();
        List<String> keyList = List.of("sn","yn");
        List<List<String>> values = new ArrayList<>();
        List<String> keys = data.stream().map(Map::keySet).flatMap(Collection::stream).collect(Collectors.toList());
        
        for (int i=0; i<keys.size(); i++) {
            List<List<String>> tempValue = new ArrayList<>(data.get(i).values());
            values.addAll(tempValue);
        }
        for (int i = 0; i < values.get(0).size(); i++) {
            Map<String, String> map = new LinkedHashMap<>();
            for (int j = 0; j < keys.size(); j++) {
                if(keyList.contains(keys.get(j))) {
                    map.put(keys.get(j), values.get(j).get(i));
                }
            }
            result.add(map);
        }

        System.out.println("result5 = " + result);
        
    }


    public static void main(String[] args) {
        List<Map<String, List<String>>> data = new ArrayList<>();
        List<String> values = List.of("1","2","3","4");
        Map<String, List<String>> map1 = new LinkedHashMap<>();
        map1.put("sn", values);

        List<String> values2 = List.of("5","6","7","8");
        Map<String, List<String>> map2 = new LinkedHashMap<>();
        map2.put("yn", values2);

        List<String> values3 = List.of("on","on","on","on");
        Map<String, List<String>> map3 = new LinkedHashMap<>();
        map3.put("on", values3);

        data.add(map1);
        data.add(map2);
        data.add(map3);
        Solution solution = new Solution();
        solution.solution(data);
    }
}

