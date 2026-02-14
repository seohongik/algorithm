package programus;

import java.util.*;

public class DelFileDesktop {
    public int[] solution(String[] wallpaper) {
        int dragPoint1 = 0;
        int dragPoint2 = 0;
        int dragPoint3 = 0;
        int dragPoint4 = 0;
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();
        for (int i = 0; i < wallpaper.length; i++) {

            for (int k = 0; k < wallpaper[i].length(); k++) {
                if(wallpaper[i].charAt(k)=='#'){
                    dragPoint1 = i;
                    dragPoint2 = k;
                    listX.add(dragPoint1);
                    listY.add(dragPoint2);
                    dragPoint1= Collections.min(listX);
                    dragPoint2= Collections.min(listY);
                    dragPoint3= Collections.max(listX);
                    dragPoint4= Collections.max(listY);

                }
            }
        }

        return new int[]{dragPoint1, dragPoint2, dragPoint3+1, dragPoint4+1};
    }

    public static void main(String[] args) {
        DelFileDesktop delFileDesktop = new DelFileDesktop();
        System.out.println(Arrays.toString(delFileDesktop.solution(new String[]{".#...", "..#..", "...#."}))); //0 1 3 4
        System.out.println(Arrays.toString(delFileDesktop.solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."})));
        System.out.println(Arrays.toString(delFileDesktop.solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
        System.out.println(Arrays.toString(delFileDesktop.solution(new String[]{"..", "#."})));
    }
}
