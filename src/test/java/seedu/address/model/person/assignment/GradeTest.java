package seedu.address.model.person.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalGrades.GRADE1;
import static seedu.address.testutil.TypicalGrades.GRADE2;
import static seedu.address.testutil.TypicalGrades.UNGRADED_GRADE;

public class GradeTest {

    @Test
    public void test_equals() {
        // same object -> returns true
        assertTrue(GRADE1.equals(GRADE1));

        // same values -> returns true
        Grade gradeCopy = new Grade(UNGRADED_GRADE.getMax());
        assertTrue(UNGRADED_GRADE.equals(gradeCopy));

        // null -> returns false
        assertFalse(GRADE1.equals(null));

        // different type -> returns false
        assertFalse(GRADE1.equals(5));

        // different actual grade -> returns false
        Grade editedGrade2 = new Grade("1", GRADE2.getMax());
        assertFalse(GRADE2.equals(editedGrade2));

        // different max grade -> returns false
        Grade editedGrade5 = new Grade("UNGRADED", "1");
        assertFalse(UNGRADED_GRADE.equals(editedGrade5));
    }

    @Test
    public void test_grade_copy() {
        Grade gradeCopy = GRADE1.copyGrade();
        assertTrue(GRADE1.equals(gradeCopy));
    }

    @Test
    public void test_toString() {
        // Ungraded grade -> returns true
        assertTrue("UNGRADED/1200".equals(UNGRADED_GRADE.toString()));

        //Graded grade -> returns false
        assertTrue("800/800".equals(GRADE1.toString()));
    }
}
