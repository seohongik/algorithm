package easyspub.exemChapter;

import java.util.*;

public class BubbleSortProgram2 {

    /*
    *
    * 8
      3 2 8 1 7 4 5 6
    * */
    int index;
    int value;
    public static long swapCount = 0;

    BubbleSortProgram2() {}

    BubbleSortProgram2(int value, int index) {
        this.value = value;
        this.index = index;
    }

    @Override
    public String toString() {
        return "BubbleSortProgram2{" +
                "index=" + index +
                ", value=" + value +
                '}';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<BubbleSortProgram2> list = new ArrayList<>();
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            list.add(new BubbleSortProgram2(arr[i], i));
        }
        partition(list);

        System.out.println("swapCount = " + swapCount);


    }

    private static List<BubbleSortProgram2> partition(List<BubbleSortProgram2> list) {
        if(list.size() <= 1) {
            return list;
        }

        int middle = list.size() / 2;
        List<BubbleSortProgram2> left = partition(new ArrayList<>(list.subList(0, middle)));
        List<BubbleSortProgram2> right = partition(new ArrayList<>(list.subList(middle, list.size())));

        return mergeSort(left,right);
    }

    private static List<BubbleSortProgram2> mergeSort(List<BubbleSortProgram2> left,List<BubbleSortProgram2> right) {
        List<BubbleSortProgram2> result = new ArrayList<>();
        int lt= 0;
        int rt= 0;

        while (lt < left.size() && rt < right.size()) {
            if (left.get(lt).value < right.get(rt).value) {
                result.add(left.get(lt));
                lt++;
            }else {
                result.add(right.get(rt));
                rt++;
                swapCount+=(left.size() - lt);
            }
        }

        while (lt < left.size()) {
            result.add(left.get(lt));
            lt++;
        }
        while (rt < right.size()) {
            result.add(right.get(rt));
            rt++;
        }

        return result;
    }

}
