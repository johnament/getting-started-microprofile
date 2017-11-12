package ws.ament.microprofile.gettingstarted;

import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/api/books")
@Counted
public class BooksController {
    @Inject
    private BookService bookService;

    @GET
    @RolesAllowed("read-books")
    public Books findAll() {
        return bookService.getAll();
    }

    @GET
    @Path("/{isbn}")
    public Book getBook(@PathParam("isbn") String isbn) {
        return bookService.getBook(isbn);
    }
}