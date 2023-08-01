package Map.Task1;

public class Toy {
    private String name;
    private int atWhatAge;
    private int price;

    public Toy(String name, int atWhatAge, int price) {
        this.name = name;
        this.atWhatAge = atWhatAge;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtWhatAge() {
        return atWhatAge;
    }

    public void setAtWhatAge(int atWhatAge) {
        this.atWhatAge = atWhatAge;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Игрушка предназначена для детей с " + getAtWhatAge() + " лет, стоимость " + getPrice() + " р.";
    }
}
