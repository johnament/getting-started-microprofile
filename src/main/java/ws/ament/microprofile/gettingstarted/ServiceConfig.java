package ws.ament.microprofile.gettingstarted;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.eclipse.microprofile.auth.LoginConfig;

/**
 *
 * @author Ondrej Mihalyi
 */
@LoginConfig(authMethod = "MP-JWT", realmName = "admin-realm")
@ApplicationPath("/")
public class ServiceConfig extends Application {

}

