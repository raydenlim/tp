package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_OBJ;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TIME_OBJ;
import static seedu.address.testutil.Assert.assertThrows;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Name;
import seedu.address.model.util.SampleDataUtil;


public class CreateConsultationCommandTest {
    @Test
    public void constructor_nullDetails_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CreateConsultCommand(null, null, null));
    }

    @Test
    public void equals() {
        LocalDate date = VALID_DATE_OBJ;
        LocalTime time = VALID_TIME_OBJ;
        Set<Name> students = SampleDataUtil.getNamesSet(VALID_NAME_AMY);
        CreateConsultCommand createConsultCommand = new CreateConsultCommand(date, time, students);

        // same object -> returns true
        assertTrue(createConsultCommand.equals(createConsultCommand));

        // different types -> returns false
        assertFalse(createConsultCommand.equals(1));

        // null -> returns false
        assertFalse(createConsultCommand.equals(null));
    }
}
