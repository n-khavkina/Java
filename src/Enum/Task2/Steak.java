package Enum.Task2;

public class Steak extends Food {
    private String name = "Стейк";

    @Override
    public FoodType getFoodType() {
        return FoodType.MEAT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
