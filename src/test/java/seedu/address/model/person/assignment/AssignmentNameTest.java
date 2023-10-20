package seedu.address.model.person.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class AssignmentNameTest {

    private AssignmentName assignmentName = new AssignmentName("Finding ELDRIC");

    @Test
    public void test_sameObject_equals() {
        assertEquals(assignmentName, assignmentName);
    }

    @Test
    public void test_differentObject_equals() {
        assertFalse(assignmentName.equals("assignmentName"));
    }
}
