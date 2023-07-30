package SmartHome;

import java.util.Scanner;

public class HouseManager {
    static House house = new House(17, 80);
    public static Installing installing;

    public static void doInstalling() {
        installing.doInstalling();
    }

    public static void configureInstallingType(String typeOfEquipment) {
        switch (typeOfEquipment) {
            case "обогреватель":
                System.out.println("Вы выбрали обогреватель. Текущая температура: " + house.getTemperature()
                        + "\nПожалуйста, введите значение на которое нужно " +
                        "изменить температуру в доме:");
                installing = new InstallingHeater();
                break;
            case "увлажнитель":
                System.out.println("Вы выбрали увлажнитель. Текущая влажность: " + house.getHumidity() + "%" +
                        "\nПожалуйста, введите значение на которое нужно " +
                        "изменить влажность в доме:");
                installing = new InstallingHumidifier();
                break;
            default:
                System.out.println("Ошибка!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберете устройство для изменения (обогреватель или увлажнитель) " +
                "и введите его название:");
        String type = scanner.next();
        configureInstallingType(type);
        doInstalling();
    }
}




