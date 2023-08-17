package storageOfPersonalData;

import java.time.LocalDate;

public class User {
    private String name;
    final private LocalDate createdDate;
    private int number;

    public User(String name, LocalDate createdDate, int number) {
        this.name = name;
        this.createdDate = createdDate;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", number=" + number +
                '}';
    }
}
