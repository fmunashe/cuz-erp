package zw.co.cuz.portal.commons;

import lombok.Data;
import org.springframework.http.HttpStatus;

public class ErrorResponse {
    private String message;
    private HttpStatus httpStatus;

    public ErrorResponse(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
