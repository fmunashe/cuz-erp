package zw.co.cuz.portal.exceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
