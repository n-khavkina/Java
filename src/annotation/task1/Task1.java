package annotation.task1;

import java.lang.reflect.Method;

public class Task1 {
    @AcademyInfo(year = 1)
    public static void method1() {
    }

    public static void method2() {
    }

    public static void main(String[] args) {
        Method[] methods = Task1.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(AcademyInfo.class)) {
                System.out.println(method.getName());
            }
        }
    }
}
