package seedu.address.model.expectedgrade;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an ExpectedGrade in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidGrade(String)}
 */
public class ExpectedGrade {

    public static final String MESSAGE_CONSTRAINTS = "Grades should be alphabets";
    public static final String VALIDATION_REGEX = "\\p{Alpha}+";

    public final String expectedGrade;

    /**
     * Constructs a {@code Tag}.
     *
     * @param expectedGrade A valid tag name.
     */
    public ExpectedGrade(String expectedGrade) {
        requireNonNull(expectedGrade);
        checkArgument(isValidGrade(expectedGrade), MESSAGE_CONSTRAINTS);
        this.expectedGrade = expectedGrade;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidGrade(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ExpectedGrade)) {
            return false;
        }

        ExpectedGrade otherGrade = (ExpectedGrade) other;
        return expectedGrade.equals(otherGrade.expectedGrade);
    }

    @Override
    public int hashCode() {
        return expectedGrade.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return "Expected: " + '[' + expectedGrade + ']';
    }

}

