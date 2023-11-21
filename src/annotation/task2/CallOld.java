package annotation.task2;

public class CallOld {
    @SuppressWarnings("deprecation")
    public static void call() {
        System.out.println(AnnotationTest.old());
    }

    public static void main(String[] args) {
        call();
    }
}
