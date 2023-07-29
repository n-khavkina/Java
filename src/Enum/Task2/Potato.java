package Enum.Task2;

public class Potato extends Food {
    private String name = "Картофель";

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
