package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SESSION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SESSION_REMARK;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionNumber;
import seedu.address.model.session.SessionRemark;

/**
 * Command to update the remarks of a session.
 */
public class UpdateSessionRemarkCommand extends Command {
    public static final String COMMAND_WORD = "updatesessionremark";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Updates the remarks of a session. "
            + "Parameters: "
            + PREFIX_SESSION + "SESSION_NUMBER "
            + PREFIX_SESSION_REMARK + "SESSION_REMARK\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_SESSION + "3 "
            + PREFIX_SESSION_REMARK + "Teach students how to perform recursion.";
    public static final String MESSAGE_SUCCESS = "Session remarks updated: %1$s";

    public static final CommandType COMMAND_TYPE = CommandType.UPDATESESSIONREMARK;

    private SessionNumber sessionNumber;
    private SessionRemark sessionRemark;
    private Session sessionToUpdate;

    /**
     * Creates a new UpdateSessionRemarkCommand with a remark to be added to the session.
     *
     * @param sessionNumber The session number to create.
     * @param sessionRemark The remark to be added to the session.
     */
    public UpdateSessionRemarkCommand(SessionNumber sessionNumber, SessionRemark sessionRemark) {
        requireAllNonNull(sessionNumber, sessionRemark);

        this.sessionNumber = sessionNumber;
        this.sessionRemark = sessionRemark;
    }


    /**
     * Executes the UpdateSessionRemarkCommand to update the remarks of a session in the model.
     *
     * @param model The model to execute the command on.
     * @return A CommandResult containing the success message.
     * @throws CommandException If an error occurs during execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        sessionToUpdate = model.findSessionBySessionNumber(this.sessionNumber);
        sessionToUpdate.updateRemark(sessionRemark);

        // Return a success message
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(sessionToUpdate)),
                COMMAND_TYPE);
    }

    @Override
    public CommandType getCommandType() {
        return COMMAND_TYPE;
    }

    /**
     * Checks if this UpdateSessionRemarkCommand is equal to another object.
     *
     * @param other The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof UpdateSessionRemarkCommand)) {
            return false;
        }

        UpdateSessionRemarkCommand otherUpdateSessionRemarkCommand = (UpdateSessionRemarkCommand) other;
        return this.sessionNumber.equals(otherUpdateSessionRemarkCommand.sessionNumber)
                && this.sessionRemark.equals(otherUpdateSessionRemarkCommand.sessionRemark);
    }

    /**
     * Returns a string representation of the UpdateSessionRemarkCommand.
     *
     * @return A string representation of the command.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toUpdate", sessionNumber)
                .add("remark", sessionRemark)
                .toString();
    }
}
