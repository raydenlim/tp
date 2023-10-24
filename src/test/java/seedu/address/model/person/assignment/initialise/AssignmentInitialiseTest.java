package seedu.address.model.person.assignment.initialise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssignmentInitialiseTest {

    @Test
    public void getInitialisationStatus_afterInitialisation_success() {
        AssignmentInitialise.init();
        assertTrue(AssignmentInitialise.getInitialisationStatus());
    }
}
