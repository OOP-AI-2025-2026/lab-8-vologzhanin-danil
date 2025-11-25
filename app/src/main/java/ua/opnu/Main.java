package ua.opnu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    // =================================================================
    // ЗАВДАННЯ 4: Узагальнена версія методу filter()
    // =================================================================
    /**
     * Узагальнений метод фільтрації масиву об'єктів типу T.
     *
     * @param <T> Тип об'єктів у масиві.
     * @param input Вхідний масив об'єктів.
     * @param p Предикат (умова фільтрації).
     * @return Відфільтрований масив об'єктів.
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        List<T> resultList = new ArrayList<>();

        for (T item : input) {
            if (p.test(item)) {
                resultList.add(item);
            }
        }

        // Створення масиву узагальненого типу
        T[] resultArray = (T[]) Array.newInstance(input.getClass().getComponentType(), resultList.size());

        return resultList.toArray(resultArray);
    }


    // =================================================================
    // ЗАВДАННЯ 5: Узагальнена версія методу contains() з обмеженням
    // =================================================================
    /**
     * Узагальнений метод перевірки входження елемента в масив.
     *
     * @param <T> Тип елементів масиву, який повинен бути Comparable.
     * @param <V> Тип елемента, що шукається (повинен бути T або його підкласом).
     */
    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            // Використовуємо метод compareTo(), наданий інтерфейсом Comparable
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    // =================================================================
    // МЕТОД MAIN (Точка входу та перевірка всіх завдань)
    // =================================================================
    public static void main(String[] args) {

        // --- 1. ПЕРЕВІРКА ЗАВДАННЯ 1: MyOptional<T> ---
        System.out.println("--- 1. MyOptional<T> Test ---");
        MyOptional<String> middleName = new MyOptional<>();
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(middleName);
        System.out.println("isPresent: " + username.isPresent());
        System.out.println("orElse: " + middleName.orElse("немає"));

        // Перевірка get() на порожньому об'єкті
        try {
            middleName.get();
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // Перевірка, що конструктор не приймає null
        try {
            new MyOptional<>(null);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }

        System.out.println("-----------------------------------------\n");


        // --- 2. ПЕРЕВІРКА ЗАВДАННЯ 2: Comparable<BookData> ---
        System.out.println("--- 2. BookData Comparable Test ---");
        BookData book1 = new BookData("Java Core", "B. J. H.", 100, 910.0); // Рейтинг 9.1
        BookData book2 = new BookData("Effective Java", "J. B.", 50, 480.0); // Рейтинг 9.6
        BookData book3 = new BookData("Java Puzzlers", "J. B.", 50, 480.0); // Рейтинг 9.6

        List<BookData> books = Arrays.asList(book1, book2, book3);
        books.sort(Comparator.naturalOrder()); // Сортуємо за природним порядком (compareTo)

        System.out.println("Книги відсортовано (вищий рейтинг = менше):");
        for (BookData book : books) {
            System.out.println(book);
        }

        System.out.println("-----------------------------------------\n");


        // --- 3. ПЕРЕВІРКА ЗАВДАННЯ 3: Узагальнений метод printArray<T>() ---
        System.out.println("--- 3. printArray<T> Test ---");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};

        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);

        System.out.println("-----------------------------------------\n");


        // --- 4. ПЕРЕВІРКА ЗАВДАННЯ 4: Узагальнений метод filter<T>() ---
        System.out.println("--- 4. filter<T> Test (String) ---");
        String[] names = {"Alice", "Bob", "Anna", "Charlie"};
        Predicate<String> startsWithA = s -> s.startsWith("A");

        String[] filteredNames = filter(names, startsWithA);
        System.out.println("Filtered: " + Arrays.toString(filteredNames));

        System.out.println("-----------------------------------------\n");


        // --- 5. ПЕРЕВІРКА ЗАВДАННЯ 5: Узагальнений метод contains<T, V>() ---
        System.out.println("--- 5. contains<T, V> Test ---");
        Integer[] numberArray = {10, 20, 30, 40};

        System.out.println("Contains 30: " + contains(numberArray, 30));
        System.out.println("Contains 50: " + contains(numberArray, 50));

        System.out.println("-----------------------------------------\n");


        // --- 6. ПЕРЕВІРКА ЗАВДАННЯ 6: Generic Tuples ---
        System.out.println("--- 6. Generic Tuples Test ---");

        // GenericTwoTuple<String, Integer>
        GenericTwoTuple<String, Integer> personAge = new GenericTwoTuple<>("Alex", 30);
        System.out.println("TwoTuple: " + personAge);

        // GenericThreeTuple<BookData, Double, Boolean>
        GenericThreeTuple<BookData, Double, Boolean> bookSale =
                new GenericThreeTuple<>(book2, 50.0, true);
        System.out.println("ThreeTuple: " + bookSale);

        System.out.println("-----------------------------------------\n");
    }
}