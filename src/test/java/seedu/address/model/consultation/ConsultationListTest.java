package seedu.address.model.consultation;

import org.junit.jupiter.api.Test;
import seedu.address.model.consultation.exceptions.ConsultationNotFoundException;
import seedu.address.model.consultation.exceptions.DuplicateConsultationException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalConsultations.CONSULTATION1;
import static seedu.address.testutil.TypicalConsultations.CONSULTATION2;
import static seedu.address.testutil.TypicalConsultations.CONSULTATION3;
import static seedu.address.testutil.TypicalConsultations.CONSULTATION4;

public class ConsultationListTest {
    private final ConsultationList consultations = new ConsultationList();

    @Test
    public void contains_nullConsultation_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> consultations.contains(null));
    }

    @Test
    public void contains_consultationNotInList_returnsFalse() {
        assertFalse(consultations.contains(CONSULTATION1));
    }

    @Test
    public void contains_consultationInList_returnsTrue() {
        consultations.addConsultation(CONSULTATION1);
        assertTrue(consultations.contains(CONSULTATION1));
    }

    @Test
    public void addConsultation_nullConsultation_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> consultations.addConsultation(null));
    }

    @Test
    public void addConsultation_duplicateConsultation_throwsDuplicateConsultationException() {
        consultations.addConsultation(CONSULTATION2);
        assertThrows(DuplicateConsultationException.class, () -> consultations.addConsultation(CONSULTATION2));
    }

    @Test
    public void remove_nullConsultation_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> consultations.remove(null));
    }

    @Test
    public void remove_consultationDoesNotExist_throwsConsultationNotFoundException() {
        assertThrows(ConsultationNotFoundException.class, () -> consultations.remove(CONSULTATION4));
    }

    @Test
    public void remove_existingConsultation_removesConsultation() {
        consultations.addConsultation(CONSULTATION3);
        consultations.remove(CONSULTATION3);
        ConsultationList emptyConsultationList = new ConsultationList();
        assertEquals(emptyConsultationList, consultations);
    }

    @Test
    public void asUnmodifiableObservableList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class,
                () -> consultations.asUnmodifiableObservableList().remove(0));
    }

    @Test
    public void toStringMethod() {
        assertEquals(consultations.asUnmodifiableObservableList().toString(), consultations.toString());
    }
}
