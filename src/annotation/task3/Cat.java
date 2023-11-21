package annotation.task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Cat {
    public void eat() {
        System.out.println("Котик ест");
    }

    public void sleep(int hours) {
        System.out.println("Котик спит " + hours + " ч");
    }

    public static Cat catCreator() {
        try {
            Class<Cat> catClass = Cat.class;
            Constructor<Cat> constructor = catClass.getConstructor();
            return constructor.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void catLife() {
        catCreator().eat();
        catCreator().sleep(12);
    }

    public static void main(String[] args) {
        catLife();
    }
}
