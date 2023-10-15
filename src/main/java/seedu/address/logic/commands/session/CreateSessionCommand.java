package seedu.address.logic.commands.session;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SESSION;

import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.session.Session;


/**
 * Command to create a session with the specified student(s).
 */
public class CreateSessionCommand extends Command {
    public static final String COMMAND_WORD = "createsession";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a session with the student(s). "
            + "Parameters: "
            + PREFIX_SESSION + "SESSION_NUMBER "
            + "[" + PREFIX_NAME + "NAME]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_NAME + "Foo Bar";
    public static final String MESSAGE_SUCCESS = "New session added: %1$s";

    private String sessionNumber;
    private Name name;
    private Set<Name> names;
    private Session sessionToAdd;

    /**
     * Creates a new CreateSessionCommand with a single student to be added to the session.
     *
     * @param sessionNumber The session number to create.
     * @param name The name of the student to add to the session.
     */
    public CreateSessionCommand(String sessionNumber, Name name) {
        requireAllNonNull(sessionNumber, name);

        this.sessionNumber = sessionNumber;
        this.name = name;
    }

    /**
     * Creates a new CreateSessionCommand with multiple students to be added to the session.
     *
     * @param sessionNumber The session number to create.
     * @param names A set of names of the students to add to the session.
     */
    public CreateSessionCommand(String sessionNumber, Set<Name> names) {
        requireAllNonNull(sessionNumber, names);

        this.sessionNumber = sessionNumber;
        this.names = names;
    }

    /**
     * Executes the CreateSessionCommand to create a new session in the model.
     *
     * @param model The model to execute the command on.
     * @return A CommandResult containing the success message.
     * @throws CommandException If an error occurs during execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (name != null) {
            // Get the student to add to the session
            Person studentToAdd = model.getMatchingStudentName(name);
            // Create the session to add
            this.sessionToAdd = new Session(sessionNumber, studentToAdd);
        }
        if (names != null && !names.isEmpty()) {
            Set<Person> studentsToAdd = new HashSet<>();
            for (Name name : names) {
                Person studentToAdd = model.getMatchingStudentName(name);
                studentsToAdd.add(studentToAdd);
            }
            this.sessionToAdd = new Session(sessionNumber, studentsToAdd);
        }


        // Add the session to the model
        model.addSession(this.sessionToAdd);

        // Return a success message
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(this.sessionToAdd)));
    }

    /**
     * Checks if this CreateSessionCommand is equal to another object.
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
        if (!(other instanceof CreateSessionCommand)) {
            return false;
        }

        CreateSessionCommand otherCreateSessionCommand = (CreateSessionCommand) other;
        if (names != null && otherCreateSessionCommand.names != null) {
            // Compare when both 'names' are not null
            return this.names.equals(otherCreateSessionCommand.names)
                    && this.sessionNumber.equals(otherCreateSessionCommand.sessionNumber);
        } else if (names == null && otherCreateSessionCommand.names == null) {
            // Compare when both 'names' are null
            return this.name == null ? otherCreateSessionCommand.name == null
                    : this.name.equals(otherCreateSessionCommand.name)
                    && this.sessionNumber.equals(otherCreateSessionCommand.sessionNumber);
        } else {
            // 'names' is null in one of the objects
            return false;
        }

    }

    /**
     * Returns a string representation of the CreateSessionCommand.
     *
     * @return A string representation of the command.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toCreate", sessionToAdd)
                .toString();
    }
}
