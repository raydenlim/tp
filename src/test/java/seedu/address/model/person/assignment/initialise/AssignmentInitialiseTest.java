package seedu.address.model.person.assignment.initialise;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignmentInitialiseTest {

    @Test
    public void test_initialisation_status() {
        AssignmentInitialise.init();
        assertTrue(AssignmentInitialise.getInitialisationStatus());
    }
}
