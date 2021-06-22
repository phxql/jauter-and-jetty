package jautertest.routing;

import jakarta.servlet.http.HttpServletRequest;

public enum Method {
    CONNECT, DELETE, GET, HEAD, OPTIONS, PATCH, POST, PUT, TRACE;

    public static Method fromRequest(HttpServletRequest request) {
        return valueOf(request.getMethod());
    }
}