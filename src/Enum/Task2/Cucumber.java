package Enum.Task2;

public class Cucumber extends Food {
    private String name = "Огурец";

    @Override
    public FoodType getFoodType() {
        return FoodType.VEGETABLE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
