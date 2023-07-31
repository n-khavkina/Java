package Collection.Task1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class StudentGrades {
    public static void main(String[] args) {
        List<Integer> grades = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            grades.add(random.nextInt(1, 6));
        }
        System.out.println("Список до удаления неудовлетворительных оценок: " + grades);
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 3) {
                iterator.remove();
            }
        }
        Iterator<Integer> iterator2 = grades.iterator();
        int max = grades.get(0);
        while (iterator2.hasNext()) {
            if (iterator2.next() > max) {
                max = iterator2.next();
            }
        }
        System.out.println("Список после удаления неудовлетворительных оценок: " + grades);
        System.out.println("Самая высокая оценка: " + max);


    }
}
