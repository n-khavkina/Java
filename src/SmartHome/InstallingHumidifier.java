package SmartHome;

public class InstallingHumidifier extends Installing {
    @Override
    public Device createDevice() {
        return new Humidifier();
    }
}
