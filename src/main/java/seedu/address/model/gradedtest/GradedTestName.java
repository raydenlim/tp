package seedu.address.model.gradedtest;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a GradedTest's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidGradedTestName(String)}
 */
public class GradedTestName {
    public static final String MESSAGE_CONSTRAINTS =
            "GradedTest Names should only contain alphanumeric characters and spaces, and it should not be blank";

    /*
     * The task names should ony consist of letters (both uppercase and lowercase),
     * digits, spaces, underscores, and hyphens
     */
    public static final String VALIDATION_REGEX = "^(?=.*[A-Za-z0-9_-])[-A-Za-z0-9\\s_-]*$";

    public final String gradedTestName;

    /**
     * Constructs a {@code Name}.
     *
     * @param name A valid name.
     */
    public GradedTestName(String name) {
        requireNonNull(name);
        checkArgument(isValidGradedTestName(name), MESSAGE_CONSTRAINTS);
        gradedTestName = name;
    }

    /**
     * Returns true if a given string is a valid name.
     */
    public static boolean isValidGradedTestName(String test) {
        return test.matches(VALIDATION_REGEX);
    }


    @Override
    public String toString() {
        return gradedTestName;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof GradedTestName)) {
            return false;
        }

        GradedTestName otherGradedTestName = (GradedTestName) other;
        return gradedTestName.equals(otherGradedTestName);
    }

    @Override
    public int hashCode() {
        return gradedTestName.hashCode();
    }
}

