package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_NAME;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.task.Task;

/**
 * Adds a task to the address book.
 */
public class AddTaskCommand extends Command {

    public static final String COMMAND_WORD = "addTask";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a new task with the specified description.\n"
            + "Parameters: "
            + PREFIX_TASK_NAME + "NAME "
            + "[" + PREFIX_TASK_DESCRIPTION + "DESCRIPTION]\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_TASK_NAME + "Do laundry "
            + PREFIX_TASK_DESCRIPTION + "Wash the clothes and pants in basket";

    public static final String MESSAGE_SUCCESS = "Task has been added: %1$s";

    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the task list.";

    private final Task task;

    /**
     * Creates an AddTaskCommand to add the specified {@code Task}
     */
    public AddTaskCommand(Task task) {
        requireAllNonNull(task);
        this.task = task;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasTask(task)) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }

        model.addTask(task);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(task)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddTaskCommand)) {
            return false;
        }

        AddTaskCommand e = (AddTaskCommand) other;
        return task.equals(e.task);
    }


}
