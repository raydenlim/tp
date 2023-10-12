package seedu.address.model.consultation.exceptions;

public class ConsultationNotFoundException extends RuntimeException {
    public ConsultationNotFoundException() {
        super("Consultation not found");
    }
}
