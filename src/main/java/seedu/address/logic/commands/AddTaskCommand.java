package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Adds a task to the address book.
 */
public class AddTaskCommand extends Command {

    public static final String COMMAND_WORD = "addTask";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("Hello from addTask");
    }

}
