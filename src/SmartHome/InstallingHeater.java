package SmartHome;

public class InstallingHeater extends Installing {
    @Override
    public Device createDevice() {
        return new Heater();
    }
}
