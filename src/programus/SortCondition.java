package programus;

import java.util.*;

public class SortCondition  {

    /*
    정렬한 데이터들이 담긴 이차원 정수 리스트 data와 어떤 정보를 기준으로 데이터를 뽑아낼지를 의미하는 문자열 ext, 뽑아낼 정보의 기준값을 나타내는 정수 val_ext, 정보를 정렬할 기준이 되는 문자열 sort_by가 주어집니다.
    data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬하여 return 하도록 solution 함수를 완성해 주세요. 단, 조건을 만족하는 데이터는 항상 한 개 이상 존재합니다.
    * */

    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

        List<int[]> list = new ArrayList<>();
        //System.out.println("Arrays.deepToString(data) = " + Arrays.deepToString(data));

        //ext 값이 val_ext보다 작은 데이터만 뽑은 후
        // 한번에 다 가져올 것인가 해쉬로 풀것인가? 객체지향으로 풀것인가?
        int pickup = pickUpDate(ext);
        int[][] temp = new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            if(data[i][pickup]<val_ext) {
                temp[i] = data[i];
            }
        }

        Arrays.stream(temp).filter(i->i[0]!=0).forEach(list::add);

        for (int i = 0; i < temp.length; i++) {

            list.sort(new Comparator<int[]>() {

                @Override
                public int compare(int[] a, int[] b) {

                    if (a[sortBy(sort_by)] < b[sortBy(sort_by)]) {
                        return -1;
                    } else if (a[sortBy(sort_by)] > b[sortBy(sort_by)]) {
                        return 1;
                    } else {
                        // If first elements are equal, sort based on the second element
                        return Integer.compare(b[sortBy(sort_by)],a[sortBy(sort_by)]);
                    }

                }
            });

        }

        int[][] answer = new int[list.size()][list.get(0).length];

        for (int i = 0; i < list.size(); i++) {

            if(list.get(i)[0]!=0) {
                answer[i] = list.get(i);
            }
        }
        return answer;
    }

    private int pickUpDate(String ext){
        //code	date	maximum	remain
        int standard = -1;
        switch (ext){
            case "code": standard = 0; break;
            case "date": standard = 1; break;
            case "maximum": standard = 2; break;
            case "remain": standard = 3; break;

        }
        return standard;
    }

    private int sortBy(String sort_by){
        //code	date	maximum	remain
        int standard = -1;
        switch (sort_by){
            case "code": standard = 0; break;
            case "date": standard = 1; break;
            case "maximum": standard = 2; break;
            case "remain": standard = 3; break;

        }
        return standard;
    }

}
