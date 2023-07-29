package Enum.Task2;

public class Dill extends Food {
    private String name = "Укроп";

    @Override
    public FoodType getFoodType() {
        return FoodType.GREENS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
