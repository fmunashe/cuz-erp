package zw.co.cuz.portal.commons;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import zw.co.cuz.portal.exceptions.RecordNotFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> getErrorResponse(RecordNotFoundException recordNotFoundException) {
        ErrorResponse errorResponse1 = new ErrorResponse(recordNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(errorResponse1,HttpStatus.NOT_FOUND);
    }
}
