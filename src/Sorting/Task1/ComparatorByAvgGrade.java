package Sorting.Task1;

import java.util.Comparator;

public class ComparatorByAvgGrade implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.getAverageGrade(), o2.getAverageGrade());
    }
}
