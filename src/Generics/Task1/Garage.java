package Generics.Task1;

public class Garage <T extends Vehicle>{
    private T vehicle;

    public Garage(T vehicle) {
        this.vehicle = vehicle;
    }

    public T getVehicle(){
        return vehicle;
    }

    public void setVehicle(T vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "В гараже хранится " + vehicle.toString();
    }
}
