package ws.ament.microprofile.gettingstarted;

import javax.persistence.Entity;

@Entity
public class Book {
    private String isbn;
    private String author;

    public Book(String isbn, String author) {

    }

    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }
}
