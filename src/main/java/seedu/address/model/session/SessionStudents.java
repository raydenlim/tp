package seedu.address.model.session;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import seedu.address.model.person.Person;

/**
 * Represents a collection of students in a session. This class provides methods for managing and manipulating
 * the set of students within a session.
 */
public class SessionStudents implements Iterable<Person> {
    public static final String MESSAGE_CONSTRAINTS =
            "Session students must not be null";

    /** The set of students in the session. */
    public final Set<Person> students;

    /**
     * Constructs an empty SessionStudents object.
     */
    public SessionStudents() {
        this.students = new HashSet<>();
    }

    /**
     * Constructs a SessionStudents object with a given set of students.
     *
     * @param students The set of students to initialize the object with.
     */
    public SessionStudents(Set<Person> students) {
        requireNonNull(students);
        this.students = students;
    }

    /**
     * Constructs a SessionStudents object with a single student.
     *
     * @param student The student to add to the session.
     */
    public SessionStudents(Person student) {
        requireNonNull(student);
        this.students = new HashSet<>();
        this.students.add(student);
    }


    /**
     * Constructs a SessionStudents object with an array of students.
     *
     * @param students The students to add to the session.
     */
    public SessionStudents(Person ...students) {
        this.students = new HashSet<>();
        for (Person student : students) {
            this.students.add(student);
        }
    }

    /**
     * Adds a student to the session.
     *
     * @param student The student to add.
     */
    public void add(Person student) {
        this.students.add(student);
    }

    /**
     * Removes a student from the session.
     *
     * @param student The student to remove.
     */
    public void remove(Person student) {
        this.students.remove(student);
    }

    /**
     * Returns a string containing the names of the students in the session, sorted alphabetically.
     *
     * @return A string with student names.
     */
    public String toStudentNames() {
        List<Person> studentsArray = new ArrayList<>(students);
        studentsArray.sort(Comparator.comparing(p -> p.getName().toString()));
        StringBuilder studentNames = new StringBuilder();
        for (Person student : studentsArray) {
            studentNames.append(String.format("%s, ", student.getName()));
        }
        if (!students.isEmpty()) {
            studentNames.delete(studentNames.length() - 2, studentNames.length());
        }
        return studentNames.toString();
    }


    /**
     * Creates and returns a new SessionStudents object with the same students as this one.
     *
     * @return A new SessionStudents object with a copy of the students.
     */
    public SessionStudents getStudents() {
        SessionStudents anotherSet = new SessionStudents();
        for (Person student : students) {
            anotherSet.add(student);
        }
        return anotherSet;
    }

    /**
     * Checks if the session contains a specific student.
     *
     * @param student The student to check for existence.
     * @return True if the student exists in the session, false otherwise.
     */
    public boolean contains(Person student) {
        return students.contains(student);
    }

    /**
     * Provides a stream of students in the session.
     *
     * @return A stream of students.
     */
    public Stream<Person> stream() {
        return students.stream();
    }

    /**
     * Returns the number of students in the session.
     *
     * @return The number of students in the session.
     */
    public int size() {
        return students.size();
    }

    /**
     * Provides an iterator to iterate through the students in the session.
     *
     * @return An iterator for the students in the session.
     */
    @Override
    public Iterator<Person> iterator() {
        return students.iterator();
    }

    /**
     * Returns a string representation of the students in the session.
     *
     * @return A string representation of the students.
     */
    @Override
    public String toString() {
        return students.toString();
    }

    /**
     * Checks if this SessionStudents object is equal to another object.
     *
     * @param other The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SessionStudents)) {
            return false;
        }

        SessionStudents otherSessionStudents = (SessionStudents) other;
        return students.equals(otherSessionStudents.students);
    }

    /**
     * Returns the hash code of this SessionStudents object.
     *
     * @return The hash code of the session students.
     */
    @Override
    public int hashCode() {
        return students.hashCode();
    }

}
