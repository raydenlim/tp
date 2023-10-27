package seedu.address.testutil;

import seedu.address.model.person.Person;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionNumber;
import seedu.address.model.session.SessionStudents;

/**
 * A utility class for building Session objects for testing purposes.
 */
public class SessionBuilder {
    public static final String DEFAULT_SESSION_NUMBER = "1";

    private SessionNumber sessionNumber;
    private SessionStudents students;

    /**
     * Constructs a SessionBuilder with default session number and no students.
     */
    public SessionBuilder() {
        sessionNumber = new SessionNumber(DEFAULT_SESSION_NUMBER);
        students = new SessionStudents();
    }

    /**
     * Constructs a SessionBuilder with a given session number and no students.
     *
     * @param sessionNumber The session number to use for the session being built.
     */
    public SessionBuilder(SessionNumber sessionNumber) {
        this.sessionNumber = sessionNumber;
        students = new SessionStudents();
    }

    /**
     * Sets the session number for the session being built.
     *
     * @param sessionNumber The session number to use for the session.
     * @return The SessionBuilder object with the updated session number.
     */
    public SessionBuilder withSessionNumber(String sessionNumber) {
        this.sessionNumber = new SessionNumber(sessionNumber);
        return this;
    }

    /**
     * Sets the students for the session being built.
     *
     * @param students The students to add to the session.
     * @return The SessionBuilder object with the updated students.
     */
    public SessionBuilder withStudents(SessionStudents students) {
        this.students = students;
        return this;
    }

    /**
     * Sets the students for the session being built from an array of Person objects.
     *
     * @param students The students to add to the session.
     * @return The SessionBuilder object with the updated students.
     */
    public SessionBuilder withStudents(Person... students) {
        this.students = new SessionStudents();
        for (Person student : students) {
            this.students.add(student);
        }
        return this;
    }

    /**
     * Sets a single student for the session being built.
     *
     * @param student The student to add to the session.
     * @return The SessionBuilder object with the updated student.
     */
    public SessionBuilder withStudent(Person student) {
        this.students = new SessionStudents();
        students.add(student);
        return this;
    }

    /**
     * Builds and returns the Session object with the specified session number and students.
     *
     * @return The Session object with the specified attributes.
     */
    public Session build() {
        return new Session(sessionNumber, students);
    }
}