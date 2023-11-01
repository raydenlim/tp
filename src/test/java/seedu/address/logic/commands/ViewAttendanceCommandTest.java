package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.Messages.MESSAGE_SESSIONS_LISTED_OVERVIEW;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalPersons.CARL;
import static seedu.address.testutil.TypicalPersons.DANIEL;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import seedu.address.model.ConsultationListBook;
import seedu.address.model.GradedTestListBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.SessionListBook;
import seedu.address.model.TaskListBook;
import seedu.address.model.UserPrefs;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionStudentsContainsKeywordsPredicate;
import seedu.address.testutil.SessionBuilder;


public class ViewAttendanceCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new TaskListBook(),
            new SessionListBook(), new ConsultationListBook(), new GradedTestListBook());
    private Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new TaskListBook(),
            new SessionListBook(), new ConsultationListBook(), new GradedTestListBook());

    @Test
    public void equals() {
        SessionStudentsContainsKeywordsPredicate firstPredicate =
                new SessionStudentsContainsKeywordsPredicate(Collections.singletonList("first"));
        SessionStudentsContainsKeywordsPredicate secondPredicate =
                new SessionStudentsContainsKeywordsPredicate(Collections.singletonList("second"));

        ViewAttendanceCommand viewAttendanceFirstCommand = new ViewAttendanceCommand(firstPredicate);
        ViewAttendanceCommand viewAttendanceSecondCommand = new ViewAttendanceCommand(secondPredicate);

        // same object -> returns true
        assertTrue(viewAttendanceFirstCommand.equals(viewAttendanceFirstCommand));

        // same values -> returns true
        ViewAttendanceCommand viewAttendanceFirstCommandCopy = new ViewAttendanceCommand(firstPredicate);
        assertTrue(viewAttendanceFirstCommand.equals(viewAttendanceFirstCommandCopy));

        // different types -> returns false
        assertFalse(viewAttendanceFirstCommand.equals(1));

        // null -> returns false
        assertFalse(viewAttendanceFirstCommand.equals(null));

        // different person -> returns false
        assertFalse(viewAttendanceFirstCommand.equals(viewAttendanceSecondCommand));
    }

    @Test
    public void execute_zeroKeywords_noSessionFound() {
        String expectedMessage = String.format(MESSAGE_SESSIONS_LISTED_OVERVIEW, 0);
        SessionStudentsContainsKeywordsPredicate predicate = preparePredicate(" ");
        ViewAttendanceCommand command = new ViewAttendanceCommand(predicate);
        expectedModel.updateFilteredSessionList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Collections.emptyList(), model.getFilteredSessionList());
    }

    @Test
    public void execute_multipleKeywords_multiplePersonsFound() {
        Session s1 = new SessionBuilder().withSessionNumber("1").withStudent(CARL).build();
        Session s2 = new SessionBuilder().withSessionNumber("2").withStudents(DANIEL).build();
        model.addSession(s1);
        model.addSession(s2);
        expectedModel.addSession(s1);
        expectedModel.addSession(s2);
        String expectedMessage = String.format(MESSAGE_SESSIONS_LISTED_OVERVIEW, 2);
        SessionStudentsContainsKeywordsPredicate predicate = preparePredicate("Carl Daniel Fiona");
        ViewAttendanceCommand command = new ViewAttendanceCommand(predicate);
        expectedModel.updateFilteredSessionList(predicate);
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(Arrays.asList(s1, s2), model.getFilteredSessionList());
    }

    @Test
    public void getCommandType() {
        SessionStudentsContainsKeywordsPredicate firstPredicate =
                new SessionStudentsContainsKeywordsPredicate(Collections.singletonList("first"));
        ViewAttendanceCommand command = new ViewAttendanceCommand(firstPredicate);

        assertEquals(command.getCommandType(), CommandType.VIEWATTENDANCE);
    }

    @Test
    public void toStringMethod() {
        SessionStudentsContainsKeywordsPredicate predicate =
                new SessionStudentsContainsKeywordsPredicate(Arrays.asList("keyword"));
        ViewAttendanceCommand viewAttendanceCommand = new ViewAttendanceCommand(predicate);
        String expected = ViewAttendanceCommand.class.getCanonicalName() + "{predicate=" + predicate + "}";
        assertEquals(expected, viewAttendanceCommand.toString());
    }

    /**
     * Parses {@code userInput} into a {@code SessionStudentsContainsKeywordsPredicate}.
     */
    private SessionStudentsContainsKeywordsPredicate preparePredicate(String userInput) {
        return new SessionStudentsContainsKeywordsPredicate(Arrays.asList(userInput.split("\\s+")));
    }
}
