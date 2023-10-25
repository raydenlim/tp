package seedu.address.model.attendance;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the presence of a student in an attendance record.
 * It can either be 'present' or 'absent'.
 */
public class AttendancePresence {

    public static final String MESSAGE_CONSTRAINTS =
            "Presence field should only contain either 'present' or 'absent', and it should not be blank";
    public static final String VALID_REGEX = "(?i)^(present|absent)$";
    public final String attendancePresence;

    /**
     * Constructs an {@code AttendancePresence} with the specified presence.
     *
     * @param presence A valid presence, either 'present' or 'absent'.
     */
    public AttendancePresence(String presence) {
        requireNonNull(presence);
        presence = presence.toLowerCase(); // Normalize to lowercase for case-insensitive comparison.
        checkArgument(isValidInput(presence), MESSAGE_CONSTRAINTS);
        attendancePresence = presence;
    }

    /**
     * Returns true if the given string is a valid presence, which can be either 'present' or 'absent'.
     *
     * @param test The string to check for validity.
     * @return True if the string is a valid presence, false otherwise.
     */
    public static boolean isValidInput(String test) {
        return test.matches(VALID_REGEX);
    }

    /**
     * Checks if the attendance presence is 'present'.
     *
     * @return True if the attendance presence is 'present', false otherwise.
     */
    public boolean isPresent() {
        return attendancePresence.equals("present");
    }

    @Override
    public String toString() {
        return attendancePresence;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AttendancePresence)) {
            return false;
        }

        AttendancePresence otherAttendancePresence = (AttendancePresence) other;
        return attendancePresence.equals(otherAttendancePresence.attendancePresence);
    }

    @Override
    public int hashCode() {
        return attendancePresence.hashCode();
    }
}
