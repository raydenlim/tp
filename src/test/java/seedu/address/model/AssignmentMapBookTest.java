package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalAssignments.ASSIGNMENT1;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.assignment.AssignmentMap;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.testutil.TypicalAssignments;

public class AssignmentMapBookTest {

    private final AssignmentMapBook assignmentMapBook = new AssignmentMapBook();

    @Test
    public void constructor() {
        assertEquals(new AssignmentMap().asUnmodifiableObservableMap(), assignmentMapBook.getAssignmentMap());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> assignmentMapBook.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAssignmentMap_replacesData() {
        AssignmentMapBook newData = TypicalAssignments.getSampleAssignmentMapBook();
        assignmentMapBook.resetData(newData);
        assertEquals(newData, assignmentMapBook);
    }

    @Test
    public void constructor_withInput() {
        AssignmentMapBook newData = new AssignmentMapBook(assignmentMapBook);
        assertEquals(newData, assignmentMapBook);
    }

    @Test
    public void getAssignmentMap_modify_throwsUnsupportedOperationException() {
        AssignmentName name = ASSIGNMENT1.getName();
        assertThrows(UnsupportedOperationException.class, () ->
                assignmentMapBook.getAssignmentMap().put(name, ASSIGNMENT1));
    }
}
