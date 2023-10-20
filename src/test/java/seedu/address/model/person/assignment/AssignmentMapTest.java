package seedu.address.model.person.assignment;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class AssignmentMapTest {

    private AssignmentMap assignments = new AssignmentMap();

    @Test
    public void test_contains_success() {
        AssignmentName assignmentNameTrue = new AssignmentName("Finding ELDRIC");
        assertTrue(assignments.contains(assignmentNameTrue));

        AssignmentName assignmentNameFalse = new AssignmentName("Finding BOYD");
        assertFalse(assignments.contains(assignmentNameFalse));
    }

    @Test
    public void asUnmodifiableObservableMap_modifyMap_throwsUnsupportedOperationException() {
        AssignmentName assignmentName = new AssignmentName("Finding ELDRIC");
        assertThrows(UnsupportedOperationException.class, ()
                -> assignments.asUnmodifiableObservableMap().remove(assignmentName));
    }
}
