package seedu.address.model.task;


import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents a Task in the task list.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Task {

    // Identity fields
    private final TaskName taskName;

    // Data fields
    private final TaskDescription taskDescription;
    private boolean isDone;

    /**
     * Creates a new task with the given name, description, and completion status.
     *
     * @param taskName        The name of the task. Must not be null.
     * @param taskDescription The description of the task. Must not be null.
     * @param isDone          The completion status of the task.
     */
    public Task(TaskName taskName, TaskDescription taskDescription, boolean isDone) {
        requireAllNonNull(taskName, taskDescription);
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isDone = isDone;
    }

    /**
     * Creates a new task with the given name and description.
     * This task is initially marked as not done.
     *
     * @param taskName        The name of the task. Must not be null.
     * @param taskDescription The description of the task. Must not be null.
     */
    public Task(TaskName taskName, TaskDescription taskDescription) {
        requireAllNonNull(taskName, taskDescription);
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.isDone = false;
    }

    public TaskName getName() {
        return taskName;
    }

    public TaskDescription getDescription() {
        return taskDescription;
    }

    public boolean getIsDone() {
        return isDone;
    }

    /**
     * Marks a task as completed.
     */
    public void markDone() {
        isDone = true;
    }

    /**
     * Returns true if both tasks have the same name and description.
     */
    public boolean isSameTask(Task otherTask) {
        if (otherTask == this) {
            return true;
        }

        return otherTask != null
                && otherTask.getName().equals(getName())
                && otherTask.getDescription().equals(getDescription());
    }

    /**
     * Returns true if both tasks have the same identity and data fields.
     * This defines a stronger notion of equality between two tasks.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Task)) {
            return false;
        }

        Task otherTask = (Task) other;
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
