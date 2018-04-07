package ws.ament.microprofile.gettingstarted;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ondrej Mihalyi
 */
@ApplicationScoped
public class JPAProducer {
    @Produces
    @PersistenceContext
    private EntityManager em;
}

