package seedu.address.model.gradedtest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRADED_TEST_1;
import static seedu.address.logic.commands.CommandTestUtil.VALID_GRADED_TEST_2;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalGradedTest.GT1;
import static seedu.address.testutil.TypicalGradedTest.GT3;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.GradedTestBuilder;


public class GradedTestTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new GradedTest(null));
    }

    @Test
    public void constructor_invalidGradedTestName_throwsIllegalArgumentException() {
        String invalidGradedTestName = "%$#%#%";
        assertThrows(IllegalArgumentException.class, () -> new GradedTest(invalidGradedTestName));
    }

    @Test
    public void isValidGradedTestName() {
        // null gradedTest name
        assertThrows(NullPointerException.class, () -> GradedTest.isValidGradeTestName(null));
    }

    @Test
    public void testValidateFieldValidRA1_valid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_1);
        String result = gradedTest.validateField("RA1", "-");
        assertEquals(null, result);
    }

    @Test
    public void testValidateFieldInvalidRA1_invalid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_1);
        String result = gradedTest.validateField("RA1", "-100");
        assertEquals(GradedTest.MESSAGE_CONSTRAINTS_RA1, result);
    }

    @Test
    public void testValidateFieldValidRA2_valid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_1);
        String result = gradedTest.validateField("RA2", "4564132");
        assertEquals(null, result);
    }

    @Test
    public void testValidateFieldInvalidRA2_invalid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_1);
        String result = gradedTest.validateField("RA2", "^#*&");
        assertEquals(GradedTest.MESSAGE_CONSTRAINTS_RA2, result);
    }

    @Test
    public void testValidateFieldValidMidTerms_valid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_1);
        String result = gradedTest.validateField("MidTerms", "123.456");
        assertEquals(null, result);
    }

    @Test
    public void testValidateFieldInvalidMidTerms_invalid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_1);
        String result = gradedTest.validateField("MidTerms", "onetwothree");
        assertEquals(GradedTest.MESSAGE_CONSTRAINTS_MIDTERMS, result);
    }

    @Test
    public void testValidateFieldValidFinals_valid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_2);
        String result = gradedTest.validateField("Finals", "4");
        assertEquals(null, result);
    }

    @Test
    public void testValidateFieldValidFinals_invalid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_2);
        String result = gradedTest.validateField("Finals", "--");
        assertEquals(GradedTest.MESSAGE_CONSTRAINTS_FINALS, result);
    }

    @Test
    public void testValidateFieldInvalidPE_valid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_2);
        String result = gradedTest.validateField("PE", "-"); // 1 - is ok
        assertEquals(null, result);
    }
    @Test
    public void testValidateFieldInvalidPE_invalid() {
        GradedTest gradedTest = new GradedTest(VALID_GRADED_TEST_2);
        String result = gradedTest.validateField("PE", "-----------"); // Cant have so many -
        assertEquals(GradedTest.MESSAGE_CONSTRAINTS_PE, result);
    }

    @Test
    public void isSameGradedTest() {
        // same object -> returns true
        assertTrue(GT1.isSameGradedTest(GT1));

        // null -> returns false
        assertFalse(GT1.isSameGradedTest(null));

        // same test -> returns true
        GradedTest editedGradedTest1 = new GradedTestBuilder(GT1).build();
        assertTrue(GT1.isSameGradedTest(editedGradedTest1));

        // different finals -> returns false
        editedGradedTest1 = new GradedTestBuilder(GT1).withFinals("100").build();
        assertFalse(GT1.isSameGradedTest(editedGradedTest1));

        // different Pe -> returns false
        editedGradedTest1 = new GradedTestBuilder(GT1).withPe("100").build();
        assertFalse(GT1.isSameGradedTest(editedGradedTest1));

        // different Pe,RA1, RA2 -> returns false
        editedGradedTest1 = new GradedTestBuilder(GT1).withPe("100")
                .withReadingAssessment1("1").withReadingAssessment2("2")
                .build();
        assertFalse(GT1.isSameGradedTest(editedGradedTest1));

    }

    @Test
    public void equals() {
        // same values -> returns true
        GradedTest gradedTestCopy = new GradedTestBuilder(GT1).build();
        assertTrue(GT1.equals(gradedTestCopy));

        // same object -> returns true
        assertTrue(GT1.equals(GT1));

        // null -> returns false
        assertFalse(GT1.equals(null));

        // different type -> returns false
        assertFalse(GT1.equals(5));

        // different gradedTest -> returns false
        assertFalse(GT1.equals(GT3));

        // different pe value -> return false
        GradedTest editedGradedTest2 = new GradedTestBuilder(GT1)
                .withPe(GT3.getPracticalExam().value).build();
        assertFalse(GT1.equals(editedGradedTest2));

        // different finals value -> return false
        editedGradedTest2 = new GradedTestBuilder(GT1).withFinals(GT3
                .getFinals().value).build();
        assertFalse(GT1.equals(editedGradedTest2));

    }

    @Test
    public void toStringMethod() {
        String expected = String.format("%s{RA1:%s, RA2:%s, MidTerms:%s, Finals:%s, PE:%s}",
                GradedTest.class.getCanonicalName(), GT1.getRA1(), GT1.getRA2(),
                GT1.getMidTerms(), GT1.getFinals(), GT1.getPracticalExam());
        assertEquals(expected, expected);
    }
}
