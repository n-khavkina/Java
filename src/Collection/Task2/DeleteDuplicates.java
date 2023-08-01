package Collection.Task2;

import java.util.*;

public class DeleteDuplicates {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            list.add(random.nextInt(1, 10));
        }

        System.out.println("LinkedList до удаления повторяющихся чисел: " + list);
        Set<Integer> set = new HashSet<>(list);
        System.out.println("Hashset: " + set);

        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.set(j, 0);
                }
            }
        }

        while (iterator.hasNext()) {
            if (iterator.next() == 0) {
                iterator.remove();
            }
        }

        System.out.println("LinkedList после удаления повторяющихся чисел: " + list);

    }
}
