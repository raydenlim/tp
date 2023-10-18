package seedu.address.model.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class SessionStudentsTest {

    @Test
    public void addStudent_validStudent_success() {
        SessionStudents sessionStudents = new SessionStudents();
        Person student = new PersonBuilder().withName("Alice").build();

        sessionStudents.add(student);
        assertTrue(sessionStudents.contains(student));
        assertEquals(1, sessionStudents.size());
    }

    @Test
    public void removeStudent_validStudent_success() {
        SessionStudents sessionStudents = new SessionStudents();
        Person student = new PersonBuilder().withName("Alice").build();

        sessionStudents.add(student);
        assertTrue(sessionStudents.contains(student));

        sessionStudents.remove(student);
        assertFalse(sessionStudents.contains(student));
        assertEquals(0, sessionStudents.size());
    }

    @Test
    public void toStudentNames_validSessionStudents_success() {
        SessionStudents sessionStudents = new SessionStudents(
                new PersonBuilder().withName("Zoe").build(),
                new PersonBuilder().withName("Bob").build(),
                new PersonBuilder().withName("Alice").build()
        );

        String expected = "Alice, Bob, Zoe";
        assertEquals(expected, sessionStudents.toStudentNames());
    }

    @Test
    public void equals() {
        SessionStudents sessionStudents1 = new SessionStudents(new PersonBuilder().withName("Alice").build());
        SessionStudents sessionStudents2 = new SessionStudents(new PersonBuilder().withName("Bob").build());
        SessionStudents sessionStudents1Copy = new SessionStudents(new PersonBuilder().withName("Alice").build());

        // Testing equality with itself
        assertTrue(sessionStudents1.equals(sessionStudents1));

        // Testing equality with an equivalent object
        assertTrue(sessionStudents1.equals(sessionStudents1Copy));

        // Testing equality with a different object
        assertFalse(sessionStudents1.equals(sessionStudents2));

        // Testing equality with null
        assertFalse(sessionStudents1.equals(null));
    }
}
