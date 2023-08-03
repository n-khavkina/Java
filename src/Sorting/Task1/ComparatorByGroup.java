package Sorting.Task1;

import java.util.Comparator;

public class ComparatorByGroup implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getGroup(), o2.getGroup());
    }
}

