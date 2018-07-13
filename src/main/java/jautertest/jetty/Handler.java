package jautertest.jetty;

import jauter.Routed;
import jautertest.routing.Method;
import jautertest.routing.MyRouter;
import jautertest.routing.RouteHandler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handler for Jetty.
 */
public class Handler extends AbstractHandler {
    private final MyRouter router;

    public Handler(MyRouter router) {
        this.router = router;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Method method = Method.fromRequest(request);
        String path = request.getPathInfo();

        System.out.println("Handling " + method + " " + path);
        Routed<RouteHandler> route = router.route(method, path);

        if (route == null) {
            // No route found -> 404
            response.sendError(404, "Not Found");
        } else {
            try {
                // Route found -> execute it
                route.target().handle(request, response, route.params());
            } catch (Exception e) {
                // Route execution threw exception -> 500
                e.printStackTrace();
                response.sendError(500, "Internal server error");
            }
        }
    }
}
