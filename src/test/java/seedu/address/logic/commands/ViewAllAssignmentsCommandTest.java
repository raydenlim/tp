package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.ConsultationListBook;
import seedu.address.model.GradedTestListBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.SessionListBook;
import seedu.address.model.TaskListBook;
import seedu.address.model.UserPrefs;

public class ViewAllAssignmentsCommandTest {

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new TaskListBook(),
            new SessionListBook(), new ConsultationListBook(), new GradedTestListBook());

    @Test
    public void execute_viewAssignments_success() throws CommandException {
        ViewAllAssignmentsCommand viewAllAssignmentsCommand = new ViewAllAssignmentsCommand();
        CommandResult expectedResult = viewAllAssignmentsCommand.execute(model);
        String expectedMessage = String.format(ViewAllAssignmentsCommand.MESSAGE_SUCCESS);
        assertTrue(expectedResult.equals(new CommandResult(expectedMessage, CommandType.VIEWALLASSIGNMENTS)));
    }

    @Test
    public void getCommandType() {
        ViewAllAssignmentsCommand command = new ViewAllAssignmentsCommand();

        assertEquals(command.getCommandType(), CommandType.VIEWALLASSIGNMENTS);
    }

    @Test
    public void equals() {
        // same object -> returns true
        ViewAllAssignmentsCommand viewAllAssignmentsCommand = new ViewAllAssignmentsCommand();
        assertEquals(viewAllAssignmentsCommand, viewAllAssignmentsCommand);

        // different type -> returns false
        assertFalse(viewAllAssignmentsCommand.equals(5));

        // different object same type -> returns true
        assertEquals(viewAllAssignmentsCommand, new ViewAllAssignmentsCommand());
    }
}
