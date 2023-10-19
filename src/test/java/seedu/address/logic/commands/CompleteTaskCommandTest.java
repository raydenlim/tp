package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showTaskAtIndex;
import static seedu.address.testutil.TypicalConsultations.getTypicalConsultationListBook;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_TASK;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalSessions.getTypicalSessionList;
import static seedu.address.testutil.TypicalTasks.getTypicalTaskList;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.task.Task;
import seedu.address.testutil.TaskBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for
 * {@code CompleteTaskCommand}.
 */
public class CompleteTaskCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(),
            getTypicalTaskList(), getTypicalSessionList(), getTypicalConsultationListBook());

    @Test
    public void execute_validIndexUnfilteredList_success() {
        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Task editedTask = new TaskBuilder(taskToMark).withIsDone(true).build();
        CompleteTaskCommand completeTaskCommand = new CompleteTaskCommand(INDEX_FIRST_TASK);

        String expectedMessage = String.format(CompleteTaskCommand.MESSAGE_MARK_TASK_SUCCESS,
                Messages.format(taskToMark));


        ModelManager expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), model.getTaskList(),
                model.getSessionList(), model.getConsultationList());

        expectedModel.setTask(taskToMark, editedTask);

        assertCommandSuccess(completeTaskCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexUnfilteredList_throwsCommandException() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredTaskList().size() + 1);
        CompleteTaskCommand completeTaskCommand = new CompleteTaskCommand(outOfBoundIndex);

        assertCommandFailure(completeTaskCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void execute_validIndexFilteredList_success() {
        showTaskAtIndex(model, INDEX_FIRST_TASK);

        Task taskToMark = model.getFilteredTaskList().get(INDEX_FIRST_TASK.getZeroBased());
        Task editedTask = new TaskBuilder(taskToMark).withIsDone(true).build();
        CompleteTaskCommand completeTaskCommand = new CompleteTaskCommand(INDEX_FIRST_TASK);

        String expectedMessage = String.format(CompleteTaskCommand.MESSAGE_MARK_TASK_SUCCESS,
                Messages.format(taskToMark));

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs(), model.getTaskList(),
                model.getSessionList(), model.getConsultationList());

        expectedModel.setTask(taskToMark, editedTask);

        assertCommandSuccess(completeTaskCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidIndexFilteredList_throwsCommandException() {
        showTaskAtIndex(model, INDEX_FIRST_TASK);

        Index outOfBoundIndex = INDEX_SECOND_TASK;
        // ensures that outOfBoundIndex is still in bounds of task list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getTaskList().getTaskList().size());

        CompleteTaskCommand completeTaskCommand = new CompleteTaskCommand(outOfBoundIndex);

        assertCommandFailure(completeTaskCommand, model, Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        CompleteTaskCommand completeFirstCommand = new CompleteTaskCommand(INDEX_FIRST_TASK);
        CompleteTaskCommand completeSecondCommand = new CompleteTaskCommand(INDEX_SECOND_TASK);

        // same object -> returns true
        assertEquals(completeFirstCommand, completeFirstCommand);

        // same values -> returns true
        CompleteTaskCommand completeFirstCommandCopy = new CompleteTaskCommand(INDEX_FIRST_TASK);
        assertEquals(completeFirstCommand, completeFirstCommandCopy);

        // different types -> returns false
        assertFalse(completeFirstCommand.equals(1));

        // null -> returns false
        assertNotEquals(null, completeFirstCommand);

        // different person -> returns false
        assertNotEquals(completeFirstCommand, completeSecondCommand);
    }

    @Test
    public void toStringMethod() {
        Index targetIndex = Index.fromOneBased(1);
        CompleteTaskCommand completeTaskCommand = new CompleteTaskCommand(targetIndex);
        String expected = CompleteTaskCommand.class.getCanonicalName() + "{targetIndex=" + targetIndex + "}";
        assertEquals(expected, completeTaskCommand.toString());
    }
}
