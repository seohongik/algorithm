import java.util.*;
import java.util.stream.Collectors;

class ResultOfDeclaration {
    public static int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(report); // 정렬 때리고
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for(int i=0; i<report.length; i++){
            set.add(report[i]); // 동일 신고 건 하나로 만들고
        }

        List<String> setList = set.stream().collect(Collectors.toList());


        // for (int j = 0; j < id_list.length; j++) {

        for (int i = 0; i < setList.size(); i++) {
            String er = setList.get(i).split(" ")[0];
            String ee = setList.get(i).split(" ")[1];
            // if (er.equals(id_list[j])) {
            list.add(ee); // 신고 당한 사람 담고
            //   }
        }
        // }

        list.stream()
                .collect(Collectors.groupingBy(o -> o))
                .forEach((key, value) -> {
                    map.put(key, value.size());
                });

        // 스트림으로 신고 당한 사람 하고 받은 횟수 맵에 담아서

        //Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
        list.clear(); // 리스트 클리어


        map.entrySet().stream().forEach(entry-> {
            Integer val = entry.getValue();

            if (val >= k) {
                String key = entry.getKey();
                list.add(key); // 신고 당한 회수가 k(정지 회수보다 크면) 다시 리스트 담아서
            }
        });



        List<String > listMap = new ArrayList<>();

        for (int i = 0; i < set.size(); i++) {
            String er = setList.get(i).split(" ")[0];
            String ee = setList.get(i).split(" ")[1];

            for (int j = 0; j < list.size(); j++) {
                if(ee.equals(list.get(j))){
                    listMap.add(er); // 다시 신고한 사람 만드려 새로운 리스트 맵 만들고
                }
            }
        }
        map.clear(); // map 클리어

        listMap.stream()
                .collect(Collectors.groupingBy(o -> o)) //그룹바이 때리고
                .forEach((key, value) -> {
                    map.put(key, value.size()); // map에 담고
                });


        for(int i=0; i< id_list.length; i++){
            if(!map.containsKey(id_list[i])){
                map.put(id_list[i],0 );
            }
        } // 만약 id_list 배열에 map이 없을 수 있으니 없으면 회수 0으로 만들고

        List<Integer> returnList = new ArrayList<>();

        for(int i=0; i< id_list.length; i++){
            returnList.add(map.get(id_list[i])); //id_list대로 결과 만들고(정렬)
        }

        return returnList.stream()
                .mapToInt(Integer::intValue)
                .toArray(); //리턴;
    }

}