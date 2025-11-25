package ua.opnu;

/**
 * Завдання 1: Спрощена реалізація java.util.Optional<T>.
 * @param <T> Тип значення, яке може зберігатися.
 */
public class MyOptional<T> {
    private final T value;
    private final boolean present;

    // Конструктор 1: Порожній об'єкт
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    // Конструктор 2: Об'єкт зі значенням
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null. Використовуйте MyOptional() для порожнього стану.");
        }
        this.value = value;
        this.present = true;
    }

    public boolean isPresent() {
        return present;
    }

    public boolean isEmpty() {
        return !present;
    }

    public T get() {
        if (isEmpty()) {
            throw new IllegalStateException("Значення відсутнє.");
        }
        return value;
    }

    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    @Override
    public String toString() {
        if (present) {
            return "MyOptional[value=" + value + "]";
        } else {
            return "MyOptional[empty]";
        }
    }
}