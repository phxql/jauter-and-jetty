package jautertest.routing;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public interface RouteHandler {
    void handle(HttpServletRequest request, HttpServletResponse response, Map<String, String> params) throws Exception;
}
