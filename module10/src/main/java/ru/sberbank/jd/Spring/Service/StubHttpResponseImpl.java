package ru.sberbank.jd.Spring.Service;

public class StubHttpResponseImpl implements HttpResponse {

    @Override
    public String callHttp() {
        return "Work";
    }
}
