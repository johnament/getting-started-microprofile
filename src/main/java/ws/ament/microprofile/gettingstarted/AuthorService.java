package ws.ament.microprofile.gettingstarted;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@ApplicationScoped
public class AuthorService {
    @Inject
    @ConfigProperty(name = "author.service.url")
    private String authorUrl;

    private ConcurrentMap<String, Author> authorCache = new ConcurrentHashMap<>();

    @Retry
    @CircuitBreaker
    @Fallback(fallbackMethod = "getCachedAuthor")
    public Author findAuthor(String id) {
        Author author = ClientBuilder.newClient()
                .target(authorUrl)
                .path("/{id}")
                .resolveTemplate("id", id)
                .request(MediaType.APPLICATION_JSON)
                .get(Author.class);
        authorCache.put(id, author);
        return author;
    }

    public Author getCachedAuthor(String id) {
        return authorCache.get(id);
    }
}
