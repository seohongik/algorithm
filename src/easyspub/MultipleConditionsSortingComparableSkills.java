package easyspub;

import java.util.ArrayList;
import java.util.Collections;

public class MultipleConditionsSortingComparableSkills implements Comparable<MultipleConditionsSortingComparableSkills> {

    int english;
    int math;

    public MultipleConditionsSortingComparableSkills(int english, int math) {
        this.english = english;
        this.math = math;
    }


    @Override
    public int compareTo(MultipleConditionsSortingComparableSkills o) {
        if(this.english == o.english) {return o.math - this.math;}
        return o.english - english;
    }

    @Override
    public String toString() {
        return "MultipleConditionsSortingSkills{" +
                "english=" + english +
                ", math=" + math +
                '}';
    }

    public static void main(String[] args) {
        ArrayList<MultipleConditionsSortingComparableSkills> skills = new ArrayList<>();
        skills.add(new MultipleConditionsSortingComparableSkills(80, 100));
        skills.add(new MultipleConditionsSortingComparableSkills(100, 50));
        skills.add(new MultipleConditionsSortingComparableSkills(70, 100));
        skills.add(new MultipleConditionsSortingComparableSkills(80, 90));

        Collections.sort(skills);
        for (MultipleConditionsSortingComparableSkills skill : skills) {
            System.out.println(skill.toString());
        }
    }
}
