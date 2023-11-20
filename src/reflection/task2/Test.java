package reflection.task2;

import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HelloWorld hw = new HelloWorld();
        Class<? extends HelloWorld> classObject = hw.getClass();
        classObject.getDeclaredMethod("printHelloWorld").invoke(hw);
    }
}
