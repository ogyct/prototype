package dmitry.avgustis.prototype.service.impl;

public abstract class PrototypeService {
    protected void checkResponse(Object response) {
        if (response == null) {
            throw new RuntimeException("response.error");
        }
    }
}
