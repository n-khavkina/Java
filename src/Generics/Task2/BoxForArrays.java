package Generics.Task2;

public class BoxForArrays<T> {
    private final T[] array;

    public BoxForArrays(T[] array) {
        this.array = array;
    }

    public void getElement(int index) {
        if (index < array.length) {
            for (int i = 0; i < array.length; i++) {
                if (index == i) {
                    System.out.println("Элемент массива по индексу " + index + ": " + array[i]);
                }
            }
        } else {
            System.out.println("Элемент под таким индексом не найден");
        }
    }
}
