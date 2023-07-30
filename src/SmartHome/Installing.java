package SmartHome;

import java.util.Scanner;

public abstract class Installing {
    Scanner scanner = new Scanner(System.in);

    public void doInstalling() {
        Device device = createDevice();
        int value = scanner.nextInt();
        device.execute(value, HouseManager.house);
    }

    public abstract Device createDevice();
}
