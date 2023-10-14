package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.*;
import seedu.address.model.person.assignment.Assignment;
import seedu.address.model.person.assignment.AssignmentMap;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.Grade;
import seedu.address.model.tag.Tag;

import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

public class AddGradeCommand extends Command {

    public static final String COMMAND_WORD = "addgrade";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a grade to a person’s assignment. "
            + "Parameters: "
            + PREFIX_NAME + "NAME "
            + PREFIX_ASSIGNMENT + "ASSIGNMENT "
            + PREFIX_GRADE + "GRADE ";

    public static final String MESSAGE_SUCCESS = "Added grade to assignment: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This assignment has already been graded";

    private final AssignmentName assignmentName;
    private final String gradeString;
    private final Index index;

    public AddGradeCommand(Index index, AssignmentName assignmentName, String grade) {
        requireNonNull(index);
        requireNonNull(assignmentName);
        this.index = index;
        this.assignmentName = assignmentName;
        this.gradeString = grade;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());

        Assignment assignmentToGrade = personToEdit.getAssignment(this.assignmentName);
        Grade newGrade = new Grade(this.gradeString, assignmentToGrade.maxGrade());
        Person editedPerson = createGradedPerson(personToEdit, newGrade);

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(String.format(MESSAGE_SUCCESS, this.assignmentName));
    }

    public Person createGradedPerson(Person reference, Grade newGrade) {
        Assignment gradedAssignment = new Assignment(this.assignmentName, newGrade);
        Name name = reference.getName();
        Phone phone = reference.getPhone();
        Email email = reference.getEmail();
        Address address = reference.getAddress();
        Set<Tag> tags = reference.getTags();
        AssignmentMap updatedAssignmentMap =
                reference.getAllAssignments().createUpdatedMap(this.assignmentName, newGrade);
        return new Person(name, phone, email, address, tags, updatedAssignmentMap);
    }
}
