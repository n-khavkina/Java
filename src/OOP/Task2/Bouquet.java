package OOP.Task2;

import java.time.LocalDate;

public class Bouquet {

    public String collectBouquet(Flower[] bouquet) {
        int totalPrice = 0;
        String result1 = "";
        StringBuilder result2 = new StringBuilder("");
        LocalDate maxDateWriteOff = bouquet[0].getDateWriteOff();
        for (int i = 1; i < bouquet.length; i++) {
            if (bouquet[i].getDateWriteOff().isAfter(maxDateWriteOff)) {
                maxDateWriteOff = bouquet[i].getDateWriteOff();
            }
            result1 = "Весь букет завянет " + maxDateWriteOff;
        }
        for (Flower flower : bouquet) {
            totalPrice += flower.getPrice();
            result2.append("Цветок - ").append(flower.getName()).append(", цвет: ").append(flower.getColor()).
                    append("\n");
        }
        String result3 = "Итоговая стоимость букета: " + totalPrice + " рублей.";
        return result2 + "\n" + result3 + "\n" + result1;
    }
}
