package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.session.Session;


/**
 * Represents a command for viewing attendance of students.
 */
public class ViewAttendanceCommand extends Command {
    public static final String COMMAND_WORD = "viewattendance";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Views the attendance of a student. "
            + "Parameters: "
            + PREFIX_NAME + "KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe Alice";

    public static final CommandType COMMAND_TYPE = CommandType.VIEW_ATTENDANCE;

    private final Predicate<Session> predicate;

    /**
     * Creates a `ViewAttendanceCommand` to view attendance of student(s) listed.
     *
     * @param predicate The names of the student(s).
     */
    public ViewAttendanceCommand(Predicate<Session> predicate) {
        this.predicate = predicate;
    }

    /**
     * Executes the `ViewAttendanceCommand` to view the attendance of student(s) in the model.
     *
     * @param model The model to execute the command on.
     * @return A `CommandResult` containing the success message.
     * @throws CommandException If an error occurs during execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        model.updateFilteredSessionList(predicate);

        // Return a success message
        return new CommandResult(
                String.format(Messages.MESSAGE_SESSIONS_LISTED_OVERVIEW, model.getFilteredSessionList().size()),
                CommandType.VIEW_ATTENDANCE);
    }

    @Override
    public CommandType getCommandType() {
        return COMMAND_TYPE;
    }

    /**
     * Checks if this `TakeAttendanceCommand` is equal to another object.
     *
     * @param other The object to compare with.
     * @return `true` if the objects are equal, `false` otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ViewAttendanceCommand)) {
            return false;
        }

        ViewAttendanceCommand otherViewAttendanceCommand = (ViewAttendanceCommand) other;
        return predicate.equals(otherViewAttendanceCommand.predicate);
    }

    /**
     * Returns a string representation of the `ViewAttendanceCommand`.
     *
     * @return A string representation of the command.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", predicate)
                .toString();
    }
}
