package Exception.Task2;

public class Test {
    public static void main(String[] args) {
        try {
            validateEmail("abc@mail.ruu");
        } catch (InvalidEmailException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Верный email");
        }
    }

    public static void validateEmail(String email) throws InvalidEmailException {
        if (!email.matches("[\\w\\.\\-]+@[A-z]{2,6}\\.(ru|com|org|net)")) {
            throw new InvalidEmailException("Неверный email");
        }

    }
}
