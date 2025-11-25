package ua.opnu;

/**
 * Завдання 3: Клас з узагальненим методом printArray().
 */
public class Printer {

    /**
     * Узагальнений метод, який може приймати масив будь-якого типу.
     * @param <T> Тип елементів масиву.
     * @param array Масив елементів типу T.
     */
    public <T> void printArray(T[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}