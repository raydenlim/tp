package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 *
 * Adapted from: https://github.com/se-edu/addressbook-level3/commit/4516e099699baa9e2d51801bd26f016d812dedcc
 */
public class Remark {
    public final String value;

    /**
     * Constructs a Remark with the specified text value.
     *
     * @param remark The text value of the Remark. Must not be null.
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Remark // instanceof handles nulls
                && value.equals(((Remark) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
