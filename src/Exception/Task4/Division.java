package Exception.Task4;


public class Division {

    public static void main(String[] args) {
        try {
            System.out.println(divide("50", "10", "0"));
        } catch (ArithmeticException | NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Double divide(String... arguments) throws ArithmeticException, ArrayIndexOutOfBoundsException,
            NumberFormatException {
        Double res = null;
        if (arguments.length == 0 || arguments.length == 1) {
            throw new ArrayIndexOutOfBoundsException("В аргументы нужно передать строки с числами! Минимум 2 числа!");
        }
        int[] array = new int[arguments.length];
        int index = 0;
        for (String s : arguments) {
            if (Integer.parseInt(s) == 0) {
                throw new ArithmeticException("Деление на 0!");
            } else if (s.matches("[^0-9]+")) {
                throw new NumberFormatException("В аргументы нужно передать строки с числами!");
            } else {
                array[index++] = Integer.parseInt(s);
                res = (double) array[0];
                for (int i = 1; i < array.length; i++) {
                    res /= array[i];
                }
            }
        }
        return res;
    }
}
