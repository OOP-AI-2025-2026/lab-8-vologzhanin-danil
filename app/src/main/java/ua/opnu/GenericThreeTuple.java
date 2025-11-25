package ua.opnu;

/**
 * Завдання 6: Узагальнений кортеж для трьох елементів.
 * @param <T> Тип першого елемента.
 * @param <V> Тип другого елемента.
 * @param <S> Тип третього елемента.
 */
public class GenericThreeTuple<T, V, S> {
    // Використовуємо композицію
    private final GenericTwoTuple<T, V> twoTuple;
    public final S third;

    public GenericThreeTuple(T first, V second, S third) {
        this.twoTuple = new GenericTwoTuple<>(first, second);
        this.third = third;
    }

    public T getFirst() { return twoTuple.first; }
    public V getSecond() { return twoTuple.second; }
    public S getThird() { return third; }

    @Override
    public String toString() {
        return "(" + twoTuple.first + ", " + twoTuple.second + ", " + third + ')';
    }
}