package seedu.address.model.session.exceptions;

public class DuplicateSessionException extends RuntimeException {
    public DuplicateSessionException() {
        super("Operation would result in duplicate consultations");
    }
}
