package ws.ament.microprofile.gettingstarted;

public class BookId {
    private final String isbn;
    private final String author;

    public BookId(String isbn, String author) {
        this.isbn = isbn;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }
}
