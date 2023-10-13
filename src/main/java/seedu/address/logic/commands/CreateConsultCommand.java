package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

/**
 * Creates a consultation to the consultation list.
 */
public class CreateConsultCommand extends Command {
    public static final String COMMAND_WORD = "createconsult";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a consultation with the student(s). "
            + "Parameters: "
            + PREFIX_DATE + "DATE "
            + PREFIX_TIME + "TIME "
            + "[" + PREFIX_NAME + "NAME]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_DATE + "10/10/2023 "
            + PREFIX_TIME + "15:00 "
            + PREFIX_NAME + "John Doe "
            + PREFIX_NAME + "Foo Bar";
    public static final String MESSAGE_SUCCESS = "New consultation added: %1$s";
    private final LocalDate date;
    private final LocalTime time;
    private Set<Name> names;
    private Consultation consultationToAdd;

    /**
     * Creates an CreateConsultCommand to with the specified {@code date, time, names}
     */
    public CreateConsultCommand(LocalDate date, LocalTime time, Set<Name> names) {
        requireAllNonNull(date, time, names);

        this.date = date;
        this.time = time;
        this.names = names;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Set<Person> studentsToAdd = names.stream().map(model::getMatchingStudentName).collect(Collectors.toSet());
        this.consultationToAdd = new Consultation(date, time, studentsToAdd);
        model.addConsultation(this.consultationToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(this.consultationToAdd)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CreateConsultCommand)) {
            return false;
        }

        CreateConsultCommand otherCreateConsultCommand = (CreateConsultCommand) other;
        return this.consultationToAdd.equals(otherCreateConsultCommand.consultationToAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", consultationToAdd)
                .toString();
    }
}
