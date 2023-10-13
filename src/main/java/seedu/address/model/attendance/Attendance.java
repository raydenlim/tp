package seedu.address.model.attendance;

import seedu.address.model.person.Person;
import seedu.address.model.session.Session;

import java.util.Set;

public class Attendance {
    public Attendance() {

    }

    public static void markPresent(Session session, Person student) {
        student.attendSession(session);
        session.addStudent(student);
    }

    public static void markAbsent(Session session, Person student) {
        student.missSession(session);
        session.removeStudent(student);
    }

    public static Set<Person> getAttendanceBySession(Session session) {
        return session.getStudents();
    }

    public static String getAttendanceByStudent(Person student) {
        StringBuilder stb = new StringBuilder();
        for (Session session : student.getSessions()) {
            stb.append(String.format("Session %d\n", session.getSessionNumber()));
        }
        return stb.toString();
    }



}
