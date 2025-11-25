package ua.opnu;

/**
 * Завдання 6: Узагальнений кортеж для двох елементів.
 * @param <T> Тип першого елемента.
 * @param <V> Тип другого елемента.
 */
public class GenericTwoTuple<T, V> {
    public final T first;
    public final V second;

    public GenericTwoTuple(T first, V second) {
        this.first = first;
        this.second = second;
    }

    // Додаємо гетери для кращого доступу
    public T getFirst() { return first; }
    public V getSecond() { return second; }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ')';
    }
}