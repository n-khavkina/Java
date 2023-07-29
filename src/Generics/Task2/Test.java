package Generics.Task2;

public class Test {
    public static void main(String[] args) {
        System.out.println("Первый массив");
        String[] strings = {"cat", "dog", "bird"};
        BoxForArrays<String> array1 = new BoxForArrays<>(strings);
        array1.getElement(0);
        System.out.println();

        System.out.println("Второй массив");
        Integer[] integers = {1,2,3,4,5};
        BoxForArrays<Integer> array2 = new BoxForArrays<>(integers);
        array2.getElement(3);
    }
}
