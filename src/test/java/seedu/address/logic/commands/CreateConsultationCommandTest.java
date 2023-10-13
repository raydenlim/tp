package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;

import static seedu.address.testutil.Assert.assertThrows;

public class CreateConsultationCommandTest {
    @Test
    public void constructor_nullDetails_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CreateConsultCommand(null, null, null));
    }
}
