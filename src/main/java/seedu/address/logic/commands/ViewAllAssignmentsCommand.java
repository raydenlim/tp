package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Shows a list of assignment names.
 */
public class ViewAllAssignmentsCommand extends Command {

    public static final String COMMAND_WORD = "viewallassignments";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows a list of assignment names.";

    public static final String MESSAGE_SUCCESS = "Showing all assignment names";

    public static final CommandType COMMAND_TYPE = CommandType.VIEWALLASSIGNMENTS;

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        return new CommandResult(MESSAGE_SUCCESS, COMMAND_TYPE);
    }

    @Override
    public CommandType getCommandType() {
        return COMMAND_TYPE;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ViewAllAssignmentsCommand)) {
            return false;
        }

        return true;
    }
}
