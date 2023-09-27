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
    private final TaskName taskName;

    // Data fields
    private final TaskDescription taskDescription;

    /**
     * Every field must be present and not null.
     */
    public Task(TaskName taskName, TaskDescription taskDescription) {
        requireAllNonNull(taskName, taskDescription);
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    public TaskName getName() {
        return taskName;
    }

    public TaskDescription getDescription() {
        return taskDescription;
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
        return taskName.equals(otherTask.taskName)
                && taskDescription.equals(otherTask.taskDescription);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(taskName, taskDescription);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", taskName)
                .add("description", taskDescription)
                .toString();
    }

}
