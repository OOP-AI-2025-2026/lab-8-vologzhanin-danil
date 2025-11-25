package ua.opnu;

/**
 * Завдання 2: Клас, що моделює книгу та реалізує Comparable<BookData>
 */
public class BookData implements Comparable<BookData> {
    private final String title;
    private final String author;
    private final int reviews; // Кількість оцінок
    private final double total; // Загальна сума оцінок

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public String getTitle() { return title; }

    // Метод для розрахунку рейтингу
    public double getRating() {
        // Перевірка, щоб уникнути ділення на нуль
        return (reviews > 0) ? total / reviews : 0.0;
    }

    @Override
    public String toString() {
        return title + " (" + author + "), Rating: " + String.format("%.2f", getRating());
    }

    /**
     * Вимога: Книга з вищим рейтингом "менше", ніж книга з нижчим (зворотний порядок).
     * Якщо рейтинги рівні, порівняти за назвою (звичайний порядок).
     */
    @Override
    public int compareTo(BookData other) {
        // 1. Порівняння за рейтингом (зворотний порядок)
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        // Порівнюємо otherRating з thisRating, щоб отримати зворотний порядок
        if (otherRating > thisRating) {
            return 1;
        }
        if (otherRating < thisRating) {
            return -1;
        }

        // 2. Якщо рейтинги рівні, порівнюємо за назвою (звичайний порядок)
        return this.title.compareTo(other.title);
    }
}