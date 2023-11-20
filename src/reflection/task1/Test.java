package reflection.task1;

import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Man man = new Man("Alex", "Li", 29);
        Class<? extends Man> manClassObject = man.getClass();
        manClassObject.getDeclaredMethod("printClassInformation").invoke(man);
    }
}
