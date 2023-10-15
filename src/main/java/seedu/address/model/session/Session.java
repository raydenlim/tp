package seedu.address.model.session;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.Person;

/**
 * Represents a class for managing a session, which can hold a list of students and session-specific details.
 */
public class Session {
    public static final String SESSIONNUMBER_MESSAGE_CONSTRAINTS =
            "Session numbers should only contain numbers, and it should not be blank.";;
    private static final String SESSION_NUMBER_VALIDATION_REGEX = "^[1-9]\\d*$";

    private final String sessionNumber;
    private Set<Person> students = new HashSet<>();

    /**
     * Creates a session with a session number and an initial set of students.
     *
     * @param sessionNumber The unique identifier for this session.
     * @param presentStudents The set of students present in this session.
     */
    public Session(String sessionNumber, Set<Person> presentStudents) {
        requireAllNonNull(sessionNumber, presentStudents);
        this.sessionNumber = sessionNumber;
        this.students = presentStudents;
    }

    /**
     * Creates a session with a session number and a single student. Useful for adding students individually.
     *
     * @param sessionNumber The unique identifier for this session.
     * @param student The student to add to this session.
     */
    public Session(String sessionNumber, Person student) {
        requireAllNonNull(sessionNumber, student);
        this.sessionNumber = sessionNumber;
        this.students.add(student);
    }

    /**
     * Creates a session with just a session number. Useful for creating empty sessions.
     *
     * @param sessionNumber The unique identifier for this session.
     */
    public Session(String sessionNumber) {
        requireNonNull(sessionNumber);
        this.sessionNumber = sessionNumber;
    }


    /**
     * Adds a student to the session.
     *
     * @param p The student to add.
     * @return
     */
    public void addStudent(Person p) {
        this.students.add(p);
    }

    /**
     * Removes a student from the session.
     *
     * @param key The student to remove.
     */
    public void removeStudent(Person key) {
        this.students.remove(key);
    }

    /**
     * Checks if this session is equal to another object.
     *
     * @param other The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Session)) {
            return false;
        }

        Session otherSession = (Session) other;

        // Sort the students by name
        List<Person> thisStudents = new ArrayList<>(students);
        List<Person> otherStudents = new ArrayList<>(otherSession.students);

        thisStudents.sort(Comparator.comparing(p -> p.getName().toString()));
        otherStudents.sort(Comparator.comparing(p -> p.getName().toString()));

        return sessionNumber.equals(otherSession.sessionNumber) && thisStudents.equals(otherStudents);
    }


    /**
     * Checks if this session is the same as another session.
     *
     * @param other The session to compare with.
     * @return True if the sessions are the same, false otherwise.
     */
    public boolean isSameSession(Session other) {
        if (other == this) {
            return true;
        }

        return other != null
                && other.getSessionNumber().equals(sessionNumber)
                && other.getStudents().equals(students);
    }

    /**
     * Retrieves the set of students in this session.
     *
     * @return The set of students.
     */
    public Set<Person> getStudents() {
        Set<Person> anotherSet = new HashSet<>();
        for (Person student : students) {
            anotherSet.add(student);
        }
        return anotherSet;
    }

    /**
     * Retrieves the session number, a unique identifier for this session.
     *
     * @return The session number.
     */
    public String getSessionNumber() {
        return sessionNumber;
    }

    /**
     * Generates a human-readable representation of the session, including the session number and the set of students.
     *
     * @return A string representation of the session.
     */
    public String getSessionInfo() {
        List<Person> studentsArray = new ArrayList<>(students);
        studentsArray.sort(Comparator.comparing(p -> p.getName().toString()));
        StringBuilder studentNames = new StringBuilder();
        for (Person student : studentsArray) {
            studentNames.append(String.format("%s, ", student.getName()));
        }
        if (!students.isEmpty()) {
            studentNames.delete(studentNames.length() - 2, studentNames.length());
        }
        return String.format("%s - %s", sessionNumber, studentNames);
    }

    public static boolean isValidSessionNumber(String test) {
        return test.matches(SESSION_NUMBER_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.getSessionInfo();
    }

    @Override
    public int hashCode() {
        return Objects.hash(sessionNumber, students);
    }
}
