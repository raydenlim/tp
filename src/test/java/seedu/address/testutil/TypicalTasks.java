package seedu.address.testutil;

import seedu.address.model.task.Task;

/**
 * A utility class containing a list of {@code Task} objects to be used in tests.
 */
public class TypicalTasks {
    public static final Task TASK1 = new TaskBuilder()
            .withName("Do cs2103t")
            .withDescription("Complete PRS")
            .build();

    public static final Task TASK2 = new TaskBuilder()
            .withName("Read quant guide")
            .withDescription("The green book")
            .build();

}
