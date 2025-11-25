package ua.opnu;

/**
 * Завдання 2: Клас, що моделює книгу та реалізує Comparable<BookData>
 */
public class BookData implements Comparable<BookData> {
    private final String title;
    private final String author;
    private final int reviews;
    private final double total;

    public BookData(String title, String author, int reviews, double total) {
        this.title = title;
        this.author = author;
        this.reviews = reviews;
        this.total = total;
    }

    public String getTitle() { return title; }

    public double getRating() {
        return (reviews > 0) ? total / reviews : 0.0;
    }

    @Override
    public String toString() {
        return title + " (" + author + "), Rating: " + String.format("%.2f", getRating());
    }

    /**
     * Книга з вищим рейтингом "менше" (повертає 1), ніж книга з нижчим (зворотний порядок).
     * Якщо рейтинги рівні, порівнює за назвою (звичайний порядок).
     */
    @Override
    public int compareTo(BookData other) {
        double thisRating = this.getRating();
        double otherRating = other.getRating();

        // Порівнюємо otherRating з thisRating для зворотного порядку
        if (otherRating > thisRating) {
            return 1;
        }
        if (otherRating < thisRating) {
            return -1;
        }

        // Якщо рейтинги рівні, порівнюємо за назвою
        return this.title.compareTo(other.title);
    }
}