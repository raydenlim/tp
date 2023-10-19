package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.GRADE_400;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_ASSIGNMENT_NAME;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ASSIGNMENT_NAME;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.model.AddressBook;
import seedu.address.model.ConsultationListBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.SessionListBook;
import seedu.address.model.TaskListBook;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.Grade;

public class AddGradeCommandTest {

    private Model model = new ModelManager(
        getTypicalAddressBook(), new UserPrefs(), new TaskListBook(), new SessionListBook(), new ConsultationListBook());
    @Test
    public void execute_addGrade_success() {
        Index targetIndex = INDEX_FIRST_PERSON;
        List<Person> lastShownList = model.getFilteredPersonList();
        Person personToEdit = lastShownList.get(targetIndex.getZeroBased());

        AssignmentName assignmentName = new AssignmentName(VALID_ASSIGNMENT_NAME);
        Grade actualGrade = new Grade(GRADE_400, personToEdit.getAssignment(assignmentName).maxGrade());
        AddGradeCommand addGradeCommand = new AddGradeCommand(targetIndex, assignmentName, GRADE_400);
        Person editedPerson = addGradeCommand.createGradedPerson(personToEdit, actualGrade);

        String expectedMessage = String.format(AddGradeCommand.MESSAGE_SUCCESS, VALID_ASSIGNMENT_NAME);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()),
                new UserPrefs(), new TaskListBook(), new SessionListBook(), new ConsultationListBook());
        expectedModel.setPerson(model.getFilteredPersonList().get(0), editedPerson);

        assertCommandSuccess(addGradeCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidAssignment_failure() {
        AssignmentName assignmentName = new AssignmentName(INVALID_ASSIGNMENT_NAME);
        AddGradeCommand addGradeCommand = new AddGradeCommand(INDEX_FIRST_PERSON, assignmentName, GRADE_400);

        assertCommandFailure(addGradeCommand, model, assignmentName.MESSAGE_CONSTRAINTS);
    }

    @Test
    public void execute_invalidPersonIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        AssignmentName assignmentName = new AssignmentName(VALID_ASSIGNMENT_NAME);
        AddGradeCommand addGradeCommand = new AddGradeCommand(outOfBoundIndex, assignmentName, GRADE_400);

        assertCommandFailure(addGradeCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    /**
     * Edit filtered list where index is larger than size of filtered list,
     * but smaller than size of address book
     */
    @Test
    public void execute_invalidPersonIndexFilteredList_failure() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getPersonList().size());
        AssignmentName assignmentName = new AssignmentName(VALID_ASSIGNMENT_NAME);

        AddGradeCommand addGradeCommand = new AddGradeCommand(outOfBoundIndex, assignmentName, GRADE_400);

        assertCommandFailure(addGradeCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void test_sameObject_equals() {
        AssignmentName assignmentName = new AssignmentName(VALID_ASSIGNMENT_NAME);
        AddGradeCommand addGradeCommand = new AddGradeCommand(INDEX_FIRST_PERSON, assignmentName, GRADE_400);

        assertEquals(addGradeCommand, addGradeCommand);
    }

    @Test
    public void test_differentObject_equals() {
        AssignmentName assignmentName = new AssignmentName(VALID_ASSIGNMENT_NAME);
        AddGradeCommand addGradeCommand = new AddGradeCommand(INDEX_FIRST_PERSON, assignmentName, GRADE_400);

        assertFalse(addGradeCommand.equals(assignmentName));
    }

    @Test
    public void test_differentObjectSameContent_equals() {
        AssignmentName assignmentName = new AssignmentName(VALID_ASSIGNMENT_NAME);
        AddGradeCommand addGradeCommandFirst = new AddGradeCommand(INDEX_FIRST_PERSON, assignmentName, GRADE_400);
        AddGradeCommand addGradeCommandSecond = new AddGradeCommand(INDEX_FIRST_PERSON, assignmentName, GRADE_400);

        assertEquals(addGradeCommandFirst, addGradeCommandSecond);
    }
}
