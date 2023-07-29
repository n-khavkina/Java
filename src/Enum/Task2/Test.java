package Enum.Task2;

public class Test {
    public static void main(String[] args) {
        Cucumber cucumber = new Cucumber();
        Steak steak = new Steak();
        Dill dill = new Dill();
        Potato potato = new Potato();

        System.out.println("Набор 1: ");
        Food[] set1 = {cucumber, dill};
        System.out.println(cucumber.getName() + ", " + dill.getName());
        System.out.println("Данный набор ингридиентов подходит вегетарианцам? " + isVegetarian(set1));
        System.out.println();
        
        System.out.println("Набор 2: ");
        Food[] set2 = {potato, steak};
        System.out.println(potato.getName() + ", " + steak.getName());
        System.out.println("Данный набор ингридиентов подходит вегетарианцам? " + isVegetarian(set2));
    }

    public static boolean isVegetarian(Food[] foods) {
        boolean result = true;
        for (Food food : foods) {
            if (food.getFoodType().equals(FoodType.MEAT)) {
                result = false;
                break;
            }
        }
        return result;
    }
}

