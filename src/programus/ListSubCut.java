package programus;

import java.util.ArrayList;
import java.util.List;

public class ListSubCut {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] slice = getStartAndEndIndexes(n,slicer,num_list);
        List<Integer> list = new ArrayList<>();
        for (int i= slice[0]; i<=slice[1]; i+=slice[2]) {
            list.add(num_list[i]);
        }

        return list.stream().mapToInt(i->i).toArray();
    }

    private int[] getStartAndEndIndexes(int number, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        return switch (number) {
            case 1 -> new int[]{0, b, 1};
            case 2 -> new int[]{a, num_list.length - 1, 1};
            case 3 -> new int[]{a, b, 1};
            case 4 -> new int[]{a, b, c};
            default -> new int[0];
        };
    }

    public static void main(String[] args) {
        ListSubCut listSubCut = new ListSubCut();
        listSubCut.solution(3,new int[]{1,5,2},new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}
