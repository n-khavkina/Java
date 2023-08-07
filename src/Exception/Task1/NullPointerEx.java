package Exception.Task1;

public class NullPointerEx {
    private static String string;

    public static void main(String[] args) {
        try {
            String newString = string.toLowerCase();
            System.out.println(newString);
        } catch (NullPointerException e) {
            System.out.println("Переменная string = null!");
        }
    }
}
