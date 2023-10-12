package seedu.address.logic.commands.consultation;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

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
    private LocalDate date;
    private LocalTime time;
    private Name name;
    private Set<Name> names;
    private Consultation consultationToAdd;

    public CreateConsultCommand(LocalDate date, LocalTime time, Name name) {
        requireNonNull(date);
        requireNonNull(time);
        requireNonNull(name);

        this.date = date;
        this.time = time;
        this.name = name;
    }

    public CreateConsultCommand(LocalDate date, LocalTime time, Set<Name> names) {
        requireNonNull(date);
        requireNonNull(time);
        requireNonNull(names);

        this.date = date;
        this.time = time;
        this.names = names;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        Person studentToAdd = model.getMatchingStudentName(name);
        this.consultationToAdd = new Consultation(date, time, studentToAdd);

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
