package ua.opnu;

/**
 * Завдання 1: Спрощена реалізація java.util.Optional<T> для безпечної роботи з можливістю відсутності значення.
 * @param <T> Тип значення, яке може зберігатися в контейнері.
 */
public class MyOptional<T> {
    private final T value;
    private final boolean present;

    // Конструктор 1: Порожній об'єкт (значення відсутнє)
    public MyOptional() {
        this.value = null; // Поле value залишається null, але present == false
        this.present = false;
    }

    // Конструктор 2: Об'єкт зі значенням
    public MyOptional(T value) {
        // Вимога: якщо value == null, кидаємо виняток
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null. Використовуйте MyOptional() для порожнього стану.");
        }
        this.value = value;
        this.present = true;
    }

    // Метод: Перевірка наявності значення
    public boolean isPresent() {
        return present;
    }

    // Метод: Перевірка відсутності значення (Підказка: !isPresent())
    public boolean isEmpty() {
        return !present;
    }

    // Метод: Отримання значення
    public T get() {
        // Вимога: якщо значення немає, кидаємо IllegalStateException
        if (isEmpty()) {
            throw new IllegalStateException("Значення відсутнє.");
        }
        return value;
    }

    // Метод: Отримання значення або значення за замовчуванням
    public T orElse(T defaultValue) {
        // Якщо present == true, повертаємо value. Інакше повертаємо defaultValue.
        return present ? value : defaultValue;
    }

    // Метод: Гарний вивід для налагодження
    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }
}
