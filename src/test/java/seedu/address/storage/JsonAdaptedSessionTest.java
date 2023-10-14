package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import seedu.address.model.session.Session;
public class JsonAdaptedSessionTest {
    //TODO: ACTUAL TESTS
    @Test
    public void toModelType_validSessionDetails_returnsSession() throws Exception {
        JsonAdaptedSession session = new JsonAdaptedSession(new Session("0"));
        assertEquals(new Session("0"), session.toModelType());
    }
}
