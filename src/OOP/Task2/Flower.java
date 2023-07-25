package OOP.Task2;

import java.time.LocalDate;

public class Flower {
    private double price;
    private LocalDate dateOfReceipt;
    private LocalDate dateWriteOff;
    private String color;
    private String name;

    public Flower(String name, double price, LocalDate dateOfReceipt, LocalDate dateWriteOff, String color) {
        this.name = name;
        this.price = price;
        this.dateOfReceipt = dateOfReceipt;
        this.dateWriteOff = dateWriteOff;
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(LocalDate dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public LocalDate getDateWriteOff() {
        return dateWriteOff;
    }

    public void setDateWriteOff(LocalDate dateWriteOff) {
        this.dateWriteOff = dateWriteOff;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
