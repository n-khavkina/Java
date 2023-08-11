package Exception.Task4;


public class Division {

    public static void main(String[] args) {
        System.out.println("Результат: " + divide("10", "5", "2"));
    }

    public static Double divide(String... arguments) {
        try {
            double result = 0;
            if (arguments.length == 0 || arguments.length == 1) {
                throw new ArithmeticException("В аргументы нужно передать строки с числами! Минимум два числа!");
            } else {
                int[] array = new int[arguments.length];
                int index = 0;
                for (String s : arguments) {
                    if (s.matches("[^\\d]+")) {
                        throw new NumberFormatException("В аргументы нужно передать строки с числами!");
                    } else if (Integer.parseInt(s) == 0) {
                        throw new ArithmeticException("Нельзя делить на 0!");
                    } else {
                        array[index++] = Integer.parseInt(s);
                        result = (double) array[0];
                        for (int i = 1; i < array.length; i++) {
                            result /= array[i];
                        }
                    }
                }
            }
            return result;
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException | NumberFormatException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

