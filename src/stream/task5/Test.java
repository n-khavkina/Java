package stream.task5;

import java.util.*;

public class Test {
    private static Random random = new Random();
    private static List<String> names = List.of("Ben", "Jack", "Harry", "George",
            "Albert", "Lola", "Mary", "Olivia", "Mia", "Ruby");
    private static List<String> surnames = List.of("Evans", "Adamson", "Gilbert",
            "Davies", "Taylor", "Brown", "Walker", "Smith", "Harris", "King");

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            list.add(new Person(names.get(random.nextInt(0, 10)),
                    surnames.get(random.nextInt(0, 10)), random.nextInt(15, 31)));
        }
        for (Person p : list) {
            System.out.println(p);
        }
        System.out.println("---------------------------------");
        list.stream().filter(person -> person.getAge() < 21).
                peek(person -> System.out.println(person)).
                sorted(Comparator.comparing(Person::getSurname).thenComparing(Person::getName)).
                limit(4).map(Person::getSurname).toList().
                forEach(System.out::println);
    }
}
