package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static javafx.collections.FXCollections.observableArrayList;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.assignment.Assignment;
import seedu.address.model.person.assignment.AssignmentMap;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.initialise.AssignmentInitialise;
import seedu.address.model.person.assignment.initialise.AssignmentNameInitialise;

/**
 * Shows a list of assignment details belonging to a person.
 */
public class ViewAssignmentsCommand extends Command {

    public static final String COMMAND_WORD = "viewassignments";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows a list of assignment details belonging to a "
            + "person, identified by the index number used in the displayed person list. "
            + "Parameters: INDEX (must be a positive integer) ";

    public static final String MESSAGE_SUCCESS = "Showing all assignment details of: %1$s";

    private final Index index;
    private ObservableList<Assignment> assignmentList;

    /**
     * Creates a ViewAssignmentsCommand to show a list of assignment details belonging to the specified person.
     */
    public ViewAssignmentsCommand(Index index) {
        requireNonNull(index);
        this.index = index;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person person = lastShownList.get(index.getZeroBased());
        AssignmentMap assignmentMap = person.getAllAssignments();
        ObservableList<AssignmentName> assignmentNameList = AssignmentNameInitialise.getAllNames();
        assignmentList = observableArrayList();
        AssignmentInitialise.init();
        for (int i = 0; i < assignmentNameList.size(); i++) {
            AssignmentName assignmentName = assignmentNameList.get(i);
            Assignment assignment = assignmentMap.get(assignmentName);
            assignmentList.add(assignment);
        }

        return new CommandResult(String.format(MESSAGE_SUCCESS, person.getName()), false, false, true, false);
    }

    public ObservableList<Assignment> getAssignmentList() {
        return this.assignmentList;
    }
}
