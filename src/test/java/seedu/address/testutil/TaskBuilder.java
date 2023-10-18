package seedu.address.testutil;

import seedu.address.model.task.Task;
import seedu.address.model.task.TaskDescription;
import seedu.address.model.task.TaskName;
import seedu.address.model.task.TaskPriority;

/**
 * A utility class to help with building Person objects.
 */
public class TaskBuilder {

    public static final String DEFAULT_NAME = "Borrow book";
    public static final String DEFAULT_DESCRIPTION = "At Central Library";
    public static final String DEFAULT_PRIORITY = "HIGH";

    private TaskName name;
    private TaskDescription description;
    private boolean isDone;
    private TaskPriority priority;

    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public TaskBuilder() {
        name = new TaskName(DEFAULT_NAME);
        description = new TaskDescription(DEFAULT_DESCRIPTION);
        priority = TaskPriority.valueOf(DEFAULT_PRIORITY);
    }

    /**
     * Initializes the TaskBuilder with the data of {@code task}.
     */
    public TaskBuilder(Task task) {
        name = task.getName();
        description = task.getDescription();
        priority = task.getPriority();
    }

    /**
     * Sets the {@code Name} of the {@code Task} that we are building.
     */
    public TaskBuilder withName(String name) {
        this.name = new TaskName(name);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Task} that we are building.
     */
    public TaskBuilder withDescription(String description) {
        this.description = new TaskDescription(description);
        return this;
    }

    /**
     * Sets the {@code isDone} of the {@code Task} that we are building.
     */
    public TaskBuilder withIsDone(boolean isDone) {
        this.isDone = isDone;
        return this;
    }

    /**
     * Sets the {@code priority} of the {@code Task} that we are building.
     */
    public TaskBuilder withPriority(String name) {
        this.priority = TaskPriority.valueOf(name);
        return this;
    }


    public Task build() {
        return new Task(name, description, isDone, priority);
    }

}
