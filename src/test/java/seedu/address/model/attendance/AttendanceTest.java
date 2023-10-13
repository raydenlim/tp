package seedu.address.model.attendance;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalPersons.ALICE;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalSessions.EMPTY_SESSION;
import static seedu.address.testutil.TypicalSessions.SESSION1A;
import static seedu.address.testutil.TypicalSessions.SESSION3A;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.session.Session;

public class AttendanceTest {
    @Test
    public void markPresentTest() {
        Session emptySession = EMPTY_SESSION;
        Attendance.markPresent(emptySession, ALICE);
        assertTrue(emptySession.getStudents().contains(ALICE));
    }

    @Test
    public void markAbsentTest() {
        Session sessionWithAlice = new Session(SESSION1A.getSessionNumber(), new HashSet<>(SESSION1A.getStudents()));
        Attendance.markAbsent(sessionWithAlice, ALICE);

        assertFalse(sessionWithAlice.getStudents().contains(ALICE));
    }

    @Test
    public void getAttendanceBySessionTest() {
        assertTrue(Attendance.getAttendanceBySession(SESSION3A).equals(SESSION3A.getStudents()));
    }

    @Test
    public void getAttendanceByStudentTest() {
        Set<Session> attendanceBefore = Attendance.getAttendanceByStudent(BOB);
        // BOB has not attended SESSION3A
        assertFalse(attendanceBefore.contains(SESSION3A));

        BOB.attendSession(SESSION3A);

        Set<Session> attendanceAfter = Attendance.getAttendanceByStudent(BOB);
        // Check if the list contains the expected session
        assertTrue(attendanceAfter.contains(SESSION3A));
    }
}
