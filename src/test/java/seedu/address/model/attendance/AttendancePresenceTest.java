package seedu.address.model.attendance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class AttendancePresenceTest {

    @Test
    public void constructor_validPresence_success() {
        String validPresence = "present";
        try {
            AttendancePresence attendancePresence = new AttendancePresence(validPresence);
            assertEquals(validPresence, attendancePresence.toString());
            assertTrue(attendancePresence.isPresent());
        } catch (IllegalArgumentException e) {
            fail("Valid presence should not throw an exception.");
        }
    }

    @Test
    public void constructor_validPresenceIgnoreCase_success() {
        String validPresence = "Present";
        try {
            AttendancePresence attendancePresence = new AttendancePresence(validPresence);
            assertEquals(validPresence.toLowerCase(), attendancePresence.toString());
            assertTrue(attendancePresence.isPresent());
        } catch (IllegalArgumentException e) {
            fail("Valid presence should not throw an exception.");
        }
    }

    @Test
    public void constructor_invalidPresence_throwsIllegalArgumentException() {
        String invalidPresence = "invalid";
        try {
            new AttendancePresence(invalidPresence);
            fail("Invalid presence should throw an exception.");
        } catch (IllegalArgumentException e) {
            assertEquals(AttendancePresence.MESSAGE_CONSTRAINTS, e.getMessage());
        }
    }

    @Test
    public void isValidInput_validPresence_returnsTrue() {
        assertTrue(AttendancePresence.isValidInput("present"));
        assertTrue(AttendancePresence.isValidInput("absent"));
    }

    @Test
    public void isValidInput_invalidPresence_returnsFalse() {
        assertFalse(AttendancePresence.isValidInput("Invalid"));
        assertFalse(AttendancePresence.isValidInput("random"));
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        AttendancePresence attendancePresence = new AttendancePresence("present");
        assertTrue(attendancePresence.equals(attendancePresence));
    }

    @Test
    public void equals_sameValues_returnsTrue() {
        AttendancePresence attendancePresence1 = new AttendancePresence("present");
        AttendancePresence attendancePresence2 = new AttendancePresence("present");
        assertTrue(attendancePresence1.equals(attendancePresence2));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        AttendancePresence attendancePresence1 = new AttendancePresence("present");
        AttendancePresence attendancePresence2 = new AttendancePresence("absent");
        assertFalse(attendancePresence1.equals(attendancePresence2));
    }

    @Test
    public void equals_null_returnsFalse() {
        AttendancePresence attendancePresence = new AttendancePresence("present");
        assertFalse(attendancePresence.equals(null));
    }

    @Test
    public void equals_differentType_returnsFalse() {
        AttendancePresence attendancePresence = new AttendancePresence("present");
        assertFalse(attendancePresence.equals("present"));
    }

    @Test
    public void hashCode_sameObject_returnsTrue() {
        AttendancePresence attendancePresence = new AttendancePresence("present");
        assertEquals(attendancePresence.hashCode(), attendancePresence.hashCode());
    }

    @Test
    public void hashCode_sameValues_returnsTrue() {
        AttendancePresence attendancePresence1 = new AttendancePresence("present");
        AttendancePresence attendancePresence2 = new AttendancePresence("present");
        assertEquals(attendancePresence1.hashCode(), attendancePresence2.hashCode());
    }
}
