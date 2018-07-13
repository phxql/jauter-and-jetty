package jautertest;

import jautertest.jetty.Handler;
import jautertest.routing.MyRouter;
import org.eclipse.jetty.server.Server;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
        // Install routes
        MyRouter router = new MyRouter()
                .GET("/hello", this::hello)
                .GET("/hello/:name", this::hello);

        // Start server
        Server server = new Server(8080);
        server.setHandler(new Handler(router));
        server.start();
        server.join();
    }

    /**
     * This is our route handler
     *
     * @param request  Request.
     * @param response Response.
     * @param params   Extracted parameters from URL.
     * @throws Exception If something went wrong.
     */
    private void hello(HttpServletRequest request, HttpServletResponse response, Map<String, String> params) throws Exception {
        try (PrintWriter writer = response.getWriter()) {
            writer.append("Hello(");
            writer.append(params.toString());
            writer.append(")");
        }
    }
}
