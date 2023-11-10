package builder;

import java.time.LocalDate;

public class PersonBuilder implements Builder {
    private String name;
    private String surname;
    private int yearOfBirth;
    private String address;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Person createPerson() {
        return new Person(name, surname, yearOfBirth, address);
    }
}
