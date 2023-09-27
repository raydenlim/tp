package seedu.address.model.task;


import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    // Identity fields
    private final Name name;

    // Data fields
    private final Description description;

    /**
     * Every field must be present and not null.
     */
    public Task(Name name, Description description) {
        requireAllNonNull(name, description);
        this.name = name;
        this.description = description;
    }

    public Name getName() {
        return name;
    }

    public Description getDescription() {
        return description;
    }


    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSameTask(seedu.address.model.task.Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof seedu.address.model.task.Task)) {
            return false;
        }

        seedu.address.model.task.Task otherTask = (seedu.address.model.task.Task) other;
        return name.equals(otherTask.name)
                && description.equals(otherTask.description);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, description);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", name)
                .add("description", description)
                .toString();
    }

}
