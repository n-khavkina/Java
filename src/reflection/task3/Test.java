package reflection.task3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Class<? extends Map> mapClass = HashMap.class;
        System.out.println("Class - " + mapClass.getName() + "\n" +
                "Class fields: " + Arrays.toString(mapClass.getDeclaredFields()) + "\n" +
                "Parent class - " + mapClass.getSuperclass() + "\n" +
                "Methods of the class: " + Arrays.toString(mapClass.getDeclaredMethods()) + "\n" +
                "Class constructors: " + Arrays.toString(mapClass.getConstructors()) + "\n" +
                "internal classes: " + Arrays.toString(mapClass.getDeclaredClasses())
        );
    }
}
