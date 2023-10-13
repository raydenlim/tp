package seedu.address.model.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalSessions.SESSION1A;
import static seedu.address.testutil.TypicalSessions.SESSION1B;
import static seedu.address.testutil.TypicalSessions.SESSION2;
import static seedu.address.testutil.TypicalSessions.SESSION3A;
import static seedu.address.testutil.TypicalSessions.SESSION3B;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TypicalPersons;

public class SessionTest {
    @Test
    public void isSameSession() {
        assertTrue(SESSION1A.isSameSession(SESSION1B));

        assertFalse(SESSION1A.isSameSession(null));

        assertFalse(SESSION2.isSameSession(SESSION3A));

        assertTrue(SESSION3B.addStudent(TypicalPersons.BOB).isSameSession(SESSION3A));
    }

    @Test
    public void toStringMethod() {
        String expected = String.format("%d - %s",
                SESSION2.getSessionNumber(), SESSION2.getStudents());
        assertEquals(expected, SESSION2.toString());
    }
}
