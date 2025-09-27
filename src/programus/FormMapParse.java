import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class FormMapParse {
    public void solution() {
    
        List<Map<String, List<String>>> data = new ArrayList<>();
        List<String> values = new ArrayList<>(List.of("1","2","3"));
        Map<String, List<String>> map1 = new LinkedHashMap<>();
        map1.put("sn", values);


        List<String> values2 = new ArrayList<>(List.of("4","5","6"));
        Map<String, List<String>> map2 = new LinkedHashMap<>();
        map2.put("yn", values2);

        List<String> values3 = new ArrayList<>(List.of("on","on","on"));
        Map<String, List<String>> map3 = new LinkedHashMap<>();
        map3.put("arr", values3);


        data.add(map1);
        data.add(map2);
        data.add(map3);

        sol1(data);
        sol2(data);
        sol3(data);
        // 만약 AJAX였으면 [{sn=1,yn=4},{sn=2,yn=5},{sn=3,yn=6}]= 으로 넘어왔기에
        // objectMapper 로 keySet().toString(); 받아서 json 파싱하고 걍 for문 돌려서 넣으면됨

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
        List<Map<String, String>> result2 = new ArrayList<>();
        List<String> keys =List.of("sn","yn");
        // value 먼저 파싱하고 인서트 이러려면 filter걸어 줬어야함 inputname 오만가지 다넘어오기때문에 이것때문에 오류

        List<Map<String, List<String>>> data2 = new ArrayList<>();
        data.stream().forEach(linkedHashMap -> {
            linkedHashMap.entrySet().stream().filter(entry -> keys.contains(entry.getKey())).forEach(entry -> {
                data2.add(Map.of(entry.getKey(),entry.getValue()));
            });
        });

        for (int i = 0; i <data2.size(); i++) {
            for (int j = 0; j < data2.get(i).size();j++){
                valuesList.add(data2.get(i).get(keys.get(i)));
            }
        }

        for (int j = 0; j < valuesList.get(0).size(); j++) {
            Map<String, String> parseMap = new LinkedHashMap<>();
            for (int k = 0; k < keys.size(); k++) {
                parseMap.put(keys.get(k), valuesList.get(k).get(j));
            }
            result2.add(parseMap);
        }

        System.out.println("result2 = " + result2);
    }

    public void sol3(List<Map<String, List<String>>> data){

        // Collectors.groupBy는 인덱스 기준으로 안묶임 이건 못해서 다른방법으로 gpt한테 배움
        List<String> keys = List.of("sn","yn");
        int size = data.get(0).get(keys.get(0)).size();

        LinkedHashMap<Integer, Map<String, String>> result3 = IntStream.range(0, size)
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

        System.out.println("result3 = " + result3);

    }
}
class Main {

    public static void main(String[] args) {
        FormMapParse solution = new FormMapParse();
        solution.solution();
    }
}
