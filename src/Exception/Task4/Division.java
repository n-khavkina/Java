package Exception.Task4;


public class Division {
    private static Double result = null;

    public static void main(String[] args) {
        try {
            System.out.println(divide("50"));
        } catch (ArithmeticException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println(result);
        }
    }

    public static Double divide(String... arguments) throws ArithmeticException, ArrayIndexOutOfBoundsException,
            NumberFormatException {
        if (arguments.length == 0 || arguments.length == 1) {
            result = null;
            throw new ArrayIndexOutOfBoundsException("В аргументы нужно передать строки с числами! Минимум 2 числа!");
        }
        int[] array = new int[arguments.length];
        int index = 0;
        for (String s : arguments) {
            if (s.matches("[^0-9]+")) {
                result = null;
                throw new NumberFormatException("В аргументы нужно передать строки с числами!");
            }
            if (Integer.parseInt(s) == 0) {
                result = null;
                throw new ArithmeticException("Деление на 0!");
            } else {
                array[index++] = Integer.parseInt(s);
                result = (double) array[0];
                for (int i = 1; i < array.length; i++) {
                    result /= array[i];
                }
            }
        }
        return result;
    }
}

