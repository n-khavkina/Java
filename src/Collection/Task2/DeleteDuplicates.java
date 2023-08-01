package Collection.Task2;

import java.util.*;

public class DeleteDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 6; i++) {
            list.add(random.nextInt(1, 3));
        }

        System.out.println("LinkedList до удаления повторяющихся чисел: " + list);

        Collections.sort(list);
        Iterator<Integer> iterator = list.iterator();
        Integer lastElement = iterator.next();
        while (iterator.hasNext()) {
            Integer nextElement = iterator.next();
            if (lastElement.equals(nextElement)) {
                iterator.remove();
            }
            lastElement = nextElement;
        }

        System.out.println("LinkedList после удаления повторяющихся чисел: " + list);
    }
}




