package Sorting.Task1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SortingStudents {
    public static void main(String[] args) {
        Student student1 = new Student("Екатерина", 1, 4.4);
        Student student2 = new Student("Дмитрий", 4, 4.1);
        Student student3 = new Student("Игорь", 1, 2.8);
        Student student4 = new Student("Мария", 2, 1.9);
        Student student5 = new Student("Павел", 3, 3.8);
        List<Student> list = new LinkedList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);
        System.out.println("Сортировка по имени:\n" + sortByName(list));
        System.out.println("Сортировка по группе:\n" + sortByGroup(list));
        System.out.println("Сортировка по средней оценке:\n" + sortByAvgGrade(list));
        System.out.println("Сортировка по группе, затем в рамках одной группы по средней оценке:\n" +
                sortByGroupAndAvgGrade(list));
    }

    public static List<Student> removeForBadGrade(List<Student> list) {
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getAverageGrade() < 3) {
                iterator.remove();
            }
        }
        return list;
    }

    public static List<Student> sortByName(List<Student> list) {
        list.sort(new ComparatorByName());
        return list;
    }

    public static List<Student> sortByGroup(List<Student> list) {
        list.sort(new ComparatorByGroup());
        return list;
    }

    public static List<Student> sortByAvgGrade(List<Student> list) {
        list.sort(new ComparatorByAvgGrade());
        return list;
    }

    public static List<Student> sortByGroupAndAvgGrade(List<Student> list) {
        list.sort(new ComparatorByGroup().thenComparing(new ComparatorByAvgGrade()));
        return list;
    }
}

