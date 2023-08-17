package storageOfPersonalData;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhoneBookImpl implements PhoneBook {
    private static final List<User> USERS = new ArrayList<>();

    @Override
    public void addUser(String name, int number, LocalDate createdDate) {
        USERS.add(new User(name, createdDate, number));
    }

    @Override
    public int getNumberByName(String name) {
        int result = 0;
        for (User user : USERS) {
            if (user.getName().equals(name)) {
                result = user.getNumber();
            }
        }
        if (result == 0) {
            throw new NullPointerException();
        }
        return result;
    }

    @Override
    public String getNameByNumber(int number) {
        String result = null;
        for (User user : USERS) {
            if (user.getNumber() == number) {
                result = user.getName();
            }
        }
        if (result == null) {
            throw new NullPointerException();
        }
        return result;
    }

    @Override
    public void storeToFile(File phoneBookFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(phoneBookFile))) {
            for (User user : USERS) {
                bufferedWriter.write(user.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка! Невозможно записать в файл!");
        }
    }

    @Override
    public void loadFromFile(File phoneBookFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(phoneBookFile))) {
            String result = bufferedReader.readLine();
            while (result != null) {
                System.out.println(result);
                result = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл не найден!");
        } catch (IOException e) {
            System.out.println("Ошибка! Некорректный формат файла при чтении");
        }
    }
}
