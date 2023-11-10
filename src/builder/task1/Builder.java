package builder.task1;

public interface Builder {
    void setName(String name);
    void setSurname(String surname);
    void setYearOfBirth(int yearOfBirth);
    void setAddress(String address);
    Person createPerson();
}
