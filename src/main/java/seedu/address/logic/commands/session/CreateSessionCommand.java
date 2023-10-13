package seedu.address.logic.commands.session;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.session.Session;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

public class CreateSessionCommand extends Command {
    public static final String COMMAND_WORD = "createsession";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a session with the student(s). "
            + "Parameters: "
            + PREXFIX_SESSION + "SESSION_NUMBER "
            + "[" + PREFIX_NAME + "NAME]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_NAME + "Foo Bar";
    public static final String MESSAGE_SUCCESS = "New consultation added: %1$s";
    private int sessionNumber;
    private Name name;
    private Set<Name> names;
    private Session sessionToAdd;

    public CreateSessionCommand(int sessionNumber, Name name) {
        requireAllNonNull(sessionNumber, name);

        this.sessionNumber = sessionNumber;
        this.name = name;
    }

    public CreateSessionCommand(int sessionNumber, Set<Name> names) {
        requireAllNonNull(sessionNumber, names);

        this.sessionNumber = sessionNumber;
        this.names = names;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Person studentToAdd = model.getMatchingStudentName(name);
        this.sessionToAdd = new Session(sessionNumber, studentToAdd);

        model.addSession(this.sessionToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(this.sessionToAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CreateSessionCommand)) {
            return false;
        }

        CreateSessionCommand otherCreateConsultCommand = (CreateSessionCommand) other;
        return this.sessionToAdd.equals(otherCreateConsultCommand.sessionToAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", sessionToAdd)
                .toString();
    }
}