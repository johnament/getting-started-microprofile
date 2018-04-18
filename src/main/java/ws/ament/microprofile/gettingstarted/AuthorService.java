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
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class AuthorService {
    @Inject
    @RestClient
    AuthorConnector authorConnector;

    private ConcurrentMap<String, Author> authorCache = new ConcurrentHashMap<>();

    @Retry
    @CircuitBreaker
    @Fallback(fallbackMethod = "getCachedAuthor")
    public Author findAuthor(String id) {
        Author author = authorConnector.get(id);
        authorCache.put(id, author);
        return author;
    }

    public Author getCachedAuthor(String id) {
        return authorCache.get(id);
    }
}
