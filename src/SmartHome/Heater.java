package SmartHome;

public class Heater implements Device {
    @Override
    public void execute(int value, House house) {
        house.setTemperature(house.getTemperature() + value);
        System.out.println("Текущая температура: " + house.getTemperature());
    }
}
