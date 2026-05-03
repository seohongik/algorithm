package easyspub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MultipleConditionsComparatorSortingSkills{
    int english;
    int math;

    public MultipleConditionsComparatorSortingSkills(int english, int math) {
        this.english = english;
        this.math = math;
    }


    @Override
    public String toString() {
        return "MultipleConditionsSortingSkills{" +
                "english=" + english +
                ", math=" + math +
                '}';
    }
}

class Main implements Comparator<MultipleConditionsComparatorSortingSkills>{

    public static void main(String[] args) {
        ArrayList<MultipleConditionsComparatorSortingSkills> skills = new ArrayList<>();
        skills.add(new MultipleConditionsComparatorSortingSkills(80, 100));
        skills.add(new MultipleConditionsComparatorSortingSkills(100, 50));
        skills.add(new MultipleConditionsComparatorSortingSkills(70, 100));
        skills.add(new MultipleConditionsComparatorSortingSkills(80, 90));

        Collections.sort(skills,new Main());
        for (MultipleConditionsComparatorSortingSkills skill : skills) {
            System.out.println(skill);
        }

    }

    @Override
    public int compare(MultipleConditionsComparatorSortingSkills o1, MultipleConditionsComparatorSortingSkills o2) {
       if(o1.math == o2.math) {
            return o2.english - o1.english;
        }else {
            return o2.math - o1.math;
        }
    }
}


