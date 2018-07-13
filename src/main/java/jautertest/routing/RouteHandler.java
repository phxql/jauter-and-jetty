package jautertest.routing;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface RouteHandler {
    void handle(HttpServletRequest request, HttpServletResponse response, Map<String, String> params) throws Exception;
}
