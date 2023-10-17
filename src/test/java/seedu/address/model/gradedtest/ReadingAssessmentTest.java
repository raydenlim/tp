package seedu.address.model.gradedtest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class ReadingAssessmentTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ReadingAssessment(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new ReadingAssessment(invalidName));
    }

    @Test
    public void isValidReadingAssessment() {
        // null score
        assertThrows(NullPointerException.class, () -> ReadingAssessment.isValidRaResult(null));

        // invalid score
        assertFalse(ReadingAssessment.isValidRaResult("")); // empty string
        assertFalse(ReadingAssessment.isValidRaResult(" ")); // spaces only
        assertFalse(ReadingAssessment.isValidRaResult("^")); // only non-alphanumeric characters
        assertFalse(ReadingAssessment.isValidRaResult("peter*")); // contains non-alphanumeric characters
        assertFalse(ReadingAssessment.isValidRaResult("egsdgsg")); // contains alphabets
        assertFalse(ReadingAssessment.isValidRaResult("-1")); // contains negative numbers

        // valid score
        assertTrue(ReadingAssessment.isValidRaResult("-")); // default score
        assertTrue(ReadingAssessment.isValidRaResult("2103")); // numbers only
        assertTrue(ReadingAssessment.isValidRaResult("100.0")); // floats
        assertTrue(ReadingAssessment.isValidRaResult("0")); // 0 value allowed

    }

    @Test
    public void equals() {
        ReadingAssessment testScore = new ReadingAssessment("1");

        // same values -> returns true
        assertTrue(testScore.equals(new ReadingAssessment("1")));

        // same object -> returns true
        assertTrue(testScore.equals(testScore));

        // null -> returns false
        assertFalse(testScore.equals(null));

        // different types -> returns false
        assertFalse(testScore.equals(5.0f));

        // different values -> returns false
        assertFalse(testScore.equals(new ReadingAssessment("2")));
    }
}
