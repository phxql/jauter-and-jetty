package jautertest.routing;

import jauter.Router;

public class MyRouter extends Router<Method, RouteHandler, MyRouter> {
    protected MyRouter getThis() {
        return this;
    }

    protected Method CONNECT() {
        return Method.CONNECT;
    }

    protected Method DELETE() {
        return Method.DELETE;
    }

    protected Method GET() {
        return Method.GET;
    }

    protected Method HEAD() {
        return Method.HEAD;
    }

    protected Method OPTIONS() {
        return Method.OPTIONS;
    }

    protected Method PATCH() {
        return Method.PATCH;
    }

    protected Method POST() {
        return Method.POST;
    }

    protected Method PUT() {
        return Method.PUT;
    }

    protected Method TRACE() {
        return Method.TRACE;
    }
}
