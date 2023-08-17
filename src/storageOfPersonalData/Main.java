package storageOfPersonalData;

import java.io.File;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBookImpl();
        phoneBook.addUser("Ivan", 123, LocalDate.now());
        phoneBook.addUser("Petr", 345, LocalDate.now());
        phoneBook.storeToFile(new File("src/storageOfPersonalData/phonebook.txt"));
        PhoneBook phoneBook2 = new PhoneBookImpl();
        phoneBook2.loadFromFile(new File("src/storageOfPersonalData/phonebook.txt"));
        try {
            System.out.println(phoneBook.getNumberByName("Petr"));
        } catch (NullPointerException e) {
            System.out.println("Имя не найдено(");
        }
        try {
            System.out.println(phoneBook.getNameByNumber(123).equals("Ivan"));
        } catch (NullPointerException e) {
            System.out.println("Номер не найден(");
        }
        try {
            System.out.println(phoneBook.getNumberByName("Petr") == 345);
        } catch (NullPointerException e) {
            System.out.println("Имя не найдено(");
        }
    }
}
