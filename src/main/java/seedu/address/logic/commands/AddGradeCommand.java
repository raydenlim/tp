package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.assignment.Assignment;

import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;

public class AddGradeCommand extends Command {

    public static final String COMMAND_WORD = "addgrade";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a grade to a person’s assignment. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_ASSIGNMENT + "ASSIGNMENT "
            + PREFIX_GRADE + "GRADE ";

    public static final String MESSAGE_SUCCESS = "Added grade to assignment: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This assignment has already been graded";

    private final String assignmentName;
    private final String grade;
    private final Index index;

    public AddGradeCommand(Index index, String assignmentName, String grade) {
        requireNonNull(index);
        requireNonNull(assignmentName);
        this.index = index;
        this.assignmentName = assignmentName;
        this.grade = grade;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Assignment assignment = personToEdit.getAssignment(this.assignmentName);
        assignment.addGrade(this.grade);

        return new CommandResult(String.format(MESSAGE_SUCCESS, this.assignmentName));
    }
}
