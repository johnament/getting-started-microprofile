import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
 
import java.io.IOException;
 
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

class AuthorServlet extends AbstractHandler
{
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) 
        throws IOException, ServletException
    {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);
        response.getWriter().println("\"This is a mock author\"");
    }
}

def startJetty() {
    int port = Integer.parseInt(properties.getProperty("port", "8080"))
    def server = new Server(port)
 
    server.handler = new AuthorServlet()
    server.start()
    server.join()
}
 
println "Starting Jetty, press Ctrl+C to stop."
startJetty()