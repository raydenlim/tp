package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SESSION;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionNumber;

/**
 * Deletes a session identified using it's displayed index from the session list book.
 */
public class DeleteSessionCommand extends Command {
    public static final String COMMAND_WORD = "deletesession";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the session identified by the session number.\n"
            + "Parameters: "
            + PREFIX_SESSION + "SESSION_NUMBER (session must already be created) "
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_SESSION + "1";

    public static final String MESSAGE_DELETE_SESSION_SUCCESS = "Deleted Session: %1$s";

    private final SessionNumber targetSessionNumber;

    public DeleteSessionCommand(SessionNumber targetSessionNumber) {
        this.targetSessionNumber = targetSessionNumber;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Session sessionToDelete = model.findSessionBySessionNumber(targetSessionNumber);
        if (sessionToDelete == null) {
            throw new CommandException(Messages.MESSAGE_SESSION_NOT_FOUND);
        }

        model.deleteSession(sessionToDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_SESSION_SUCCESS,
                Messages.format(sessionToDelete)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof DeleteSessionCommand)) {
            return false;
        }

        DeleteSessionCommand otherDeleteSessionCommand = (DeleteSessionCommand) other;
        return targetSessionNumber.equals(otherDeleteSessionCommand.targetSessionNumber);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("targetSessionNumber", targetSessionNumber)
                .toString();
    }
}
