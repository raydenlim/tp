package seedu.address.model.task;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TaskDescriptionTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new TaskDescription(null));
    }

    @Test
    public void isValidAddress() {
        // null address
        assertThrows(NullPointerException.class, () -> TaskDescription.isValidDescription(null));

        // invalid addresses
        assertFalse(TaskDescription.isValidDescription(" ")); // spaces only

        // valid addresses
        assertTrue(TaskDescription.isValidDescription("")); // empty string
        assertTrue(TaskDescription.isValidDescription("complete by friday"));
        assertTrue(TaskDescription.isValidDescription("-")); // one character
        assertTrue(TaskDescription.isValidDescription("complete the work and do "
                + "the 5 quizzes and all the projects user guide developer guide")); // long address
    }

    @Test
    public void equals() {
        TaskDescription address = new TaskDescription("Valid Description");

        // same values -> returns true
        assertTrue(address.equals(new TaskDescription("Valid Description")));

        // same object -> returns true
        assertTrue(address.equals(address));

        // null -> returns false
        assertFalse(address.equals(null));

        // different types -> returns false
        assertFalse(address.equals(5.0f));

        // different values -> returns false
        assertFalse(address.equals(new TaskDescription("Other Valid Description")));
    }
}
