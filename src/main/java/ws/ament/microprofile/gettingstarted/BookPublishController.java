package ws.ament.microprofile.gettingstarted;

import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Path("/api/books")
@Counted
public class BookPublishController {
    @Inject
    private PublishBookService publishBookService;
    @POST
    public Response publish(PublishBook publishBook) {
        BookId bookId = publishBookService.publish(publishBook);
        URI uri = UriBuilder.fromMethod(BooksController.class, "getBook").build(bookId.getIsbn());
        return Response.created(uri).build();
    }
}
