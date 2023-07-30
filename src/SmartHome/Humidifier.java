package SmartHome;

public class Humidifier implements Device {
    @Override
    public void execute(int value, House house){
        house.setHumidity(house.getHumidity()+value);
        System.out.println("Текущая влвжность: " + house.getHumidity() + "%");
    }
}
