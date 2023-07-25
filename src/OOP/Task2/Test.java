package OOP.Task2;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Tulip tulip = new Tulip("Тюльпан", 100, LocalDate.of(2023, 7, 25),
                LocalDate.of(2023, 7, 30), "красный");
        Gerbera gerbera = new Gerbera("Гербера", 110, LocalDate.of(2023, 7, 24),
                LocalDate.of(2023, 7, 28), "розовый");
        Lily lily = new Lily("Лилия", 120, LocalDate.of(2023, 7, 23),
                LocalDate.of(2023, 7, 27), "розовый");
        Rose rose = new Rose("Роза", 115, LocalDate.of(2023, 7, 25),
                LocalDate.of(2023, 7, 31), "красная");
        Gypsophila gypsophila = new Gypsophila("Гипсофила", 105, LocalDate.of(2023, 7, 25),
                LocalDate.of(2023, 8, 1), "белый");

        Flower[] flowers = {tulip, gerbera, lily, rose, gypsophila};

        Bouquet bouquet = new Bouquet();
        System.out.println(bouquet.collectBouquet(flowers));
    }
}
