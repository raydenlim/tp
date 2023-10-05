package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.TaskListBook;
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

    public static final Task TASK3 = new TaskBuilder()
            .withName("Study cs3233")
            .withDescription("Read Steven Halim Book for competitive programming")
            .build();

    public static final Task TASK4 = new TaskBuilder()
            .withName("Plan for mods")
            .withDescription("SEPSPEPESEP")
            .build();

    private TypicalTasks() {} // prevents instantiation

    /**
     * Returns an {@code TaskListBook} with all the typical tasks.
     */
    public static TaskListBook getTypicalTaskList() {
        TaskListBook ab = new TaskListBook();
        for (Task task : getTypicalTasks()) {
            ab.addTask(task);
        }
        return ab;
    }

    public static List<Task> getTypicalTasks() {
        return new ArrayList<>(Arrays.asList(TASK1, TASK2));
    }

}
