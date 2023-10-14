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

import seedu.address.model.person.Person;
import seedu.address.model.session.Session;
import seedu.address.testutil.PersonBuilder;

public class AttendanceTest {
    @Test
    public void markPresentTest() {
        Person alice = new PersonBuilder(ALICE).build();
        Session emptySession = EMPTY_SESSION;
        Attendance.markPresent(emptySession, alice);
        assertTrue(emptySession.getStudents().contains(alice));
    }

    @Test
    public void markAbsentTest() {
        Person alice = new PersonBuilder(ALICE).build();
        Session sessionWithAlice = new Session(SESSION1A.getSessionNumber(), new HashSet<>(SESSION1A.getStudents()));
        Attendance.markAbsent(sessionWithAlice, alice);

        assertFalse(sessionWithAlice.getStudents().contains(alice));
    }

    @Test
    public void getAttendanceBySessionTest() {
        assertTrue(Attendance.getAttendanceBySession(SESSION3A).equals(SESSION3A.getStudents()));
    }

    @Test
    public void getAttendanceByStudentTest() {
        Person bob = new PersonBuilder(BOB).build();
        Session tempSession3a = new Session(SESSION3A.getSessionNumber(), SESSION3A.getStudents());
        Set<Session> attendanceBefore = Attendance.getAttendanceByStudent(bob);
        // bob has not attended SESSION3A
        assertFalse(attendanceBefore.contains(tempSession3a));

        bob.attendSession(tempSession3a);

        Set<Session> attendanceAfter = Attendance.getAttendanceByStudent(bob);
        // Check if the list contains the expected session
        assertTrue(attendanceAfter.contains(tempSession3a));
    }
}
