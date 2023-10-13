package seedu.address.model.session.exceptions;

public class SessionNotFoundException extends RuntimeException {
    public SessionNotFoundException() {
        super("Session not found");
    }
}
