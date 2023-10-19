package seedu.address.model.gradedtest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class MidTermTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new MidTerms(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = "";
        assertThrows(IllegalArgumentException.class, () -> new MidTerms(invalidName));
    }

    @Test
    public void isValidMidTerms() {
        // null score
        assertThrows(NullPointerException.class, () -> MidTerms.isValidMidTermResult(null));

        // invalid score
        assertFalse(MidTerms.isValidMidTermResult("")); // empty string
        assertFalse(MidTerms.isValidMidTermResult(" ")); // spaces only
        assertFalse(MidTerms.isValidMidTermResult("^")); // only non-alphanumeric characters
        assertFalse(MidTerms.isValidMidTermResult("peter*")); // contains non-alphanumeric characters
        assertFalse(MidTerms.isValidMidTermResult("egsdgsg")); // contains alphabets
        assertFalse(MidTerms.isValidMidTermResult("-1")); // contains negative numbers

        // valid score
        assertTrue(MidTerms.isValidMidTermResult("-")); // default score
        assertTrue(MidTerms.isValidMidTermResult("2103")); // numbers only
        assertTrue(MidTerms.isValidMidTermResult("100.0")); // floats
        assertTrue(MidTerms.isValidMidTermResult("0")); // 0 value allowed

    }

    @Test
    public void equals() {
        MidTerms testScore = new MidTerms("1");

        // same values -> returns true
        assertTrue(testScore.equals(new MidTerms("1")));

        // same object -> returns true
        assertTrue(testScore.equals(testScore));

        // null -> returns false
        assertFalse(testScore.equals(null));

        // different types -> returns false
        assertFalse(testScore.equals(5.0f));

        // different values -> returns false
        assertFalse(testScore.equals(new MidTerms("2")));
    }
}
