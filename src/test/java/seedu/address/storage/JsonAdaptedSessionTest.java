package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.session.Session;


public class JsonAdaptedSessionTest {
    @Test
    public void toModelType_validSessionDetails_returnsSession() throws Exception {
        JsonAdaptedSession session = new JsonAdaptedSession(new Session("0"));
        assertEquals(new Session("0"), session.toModelType());
    }

    @Test
    public void toModelType_invalidSessionNumber_throwsIllegalValueException() {
        List<JsonAdaptedPerson> students = new ArrayList<>();
        JsonAdaptedSession session = new JsonAdaptedSession(null, students);
        String expectedMessage = Session.SESSIONNUMBER_MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, session::toModelType);
    }
}
