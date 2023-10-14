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

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.TypicalPersons;

public class SessionTest {
    @Test
    public void isSameSession() {
        assertTrue(SESSION1A.isSameSession(SESSION1B));

        assertFalse(SESSION1A.isSameSession(null));

        assertFalse(SESSION2.isSameSession(SESSION3A));

        Person bob = new PersonBuilder(TypicalPersons.BOB).build();
        SESSION3B.addStudent(bob);
        assertTrue(SESSION3B.isSameSession(SESSION3A));
    }

    @Test
    public void equalsMethod() {
        // same values -> returns true
        Session otherSession = new Session(SESSION1A.getSessionNumber(), SESSION1A.getStudents());
        assertTrue(SESSION1A.equals(otherSession));

        // same object -> returns true
        assertTrue(SESSION2.equals(SESSION2));

        // null -> returns false
        assertFalse(SESSION3A.equals(null));

        // different type -> returns false
        assertFalse(SESSION3B.equals("test"));

        // different task -> returns false
        assertFalse(SESSION2.equals(SESSION3A));

        // different students -> returns false
        Session tempSession = new Session(SESSION1B.getSessionNumber(), SESSION1B.getStudents());
        Person carl = new PersonBuilder(TypicalPersons.CARL).build();
        tempSession.addStudent(carl);
        assertFalse(SESSION1B.equals(tempSession));
    }

    @Test
    public void createSessionWithoutStudents() {
        Session sessionWithoutStudents = new Session("5");
        assertTrue("5 - ".equals(sessionWithoutStudents.toString()));
    }


    @Test
    public void toStringMethod() {
        String expected1 = "2 - Bob Choo";
        assertEquals(expected1, SESSION2.toString());

        Session tempSession3A = new Session(SESSION3A.getSessionNumber(), SESSION3A.getStudents());
        String expected2 = "3 - Alice Pauline, Bob Choo";
        assertEquals(expected2, tempSession3A.toString());
    }
}
