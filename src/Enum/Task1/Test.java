package Enum.Task1;

import Enum.Task1.Seasons;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Seasons.printSeasons();
        System.out.println();
        System.out.println("Введите время года:");
        String name = scanner.nextLine().toUpperCase().trim().replaceAll("[\\W\\d\\_ ]+", "");
        System.out.println("Следующее время года - " + Seasons.getNextSeason(Seasons.valueOf(name)));
    }
}
