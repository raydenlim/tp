package seedu.address.model.consultation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.session.StudentSet;

/**
 * Represents a Consultation with a date, time and specified students.
 */
public class Consultation {
    private LocalDate date;
    private LocalTime time;
    private StudentSet students;

    /**
     * Constructs an {@code Consultation}.
     *
     * @param date A valid date object.
     * @param time A valid time object.
     * @param students A set of students.
     */
    public Consultation(LocalDate date, LocalTime time, StudentSet students) {
        this.date = date;
        this.time = time;
        this.students = students;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Consultation)) {
            return false;
        }

        Consultation otherConsultation = (Consultation) other;
        return students.equals(otherConsultation.students)
                && date.equals(otherConsultation.date)
                && time.equals(otherConsultation.time);
    }

    /**
     * Returns true if both consultations have the same details.
     */
    public boolean isSameConsultation(Consultation other) {
        if (other == this) {
            return true;
        }

        return other != null
                && other.getDate().equals(this.getDate())
                && other.getTime().equals(this.getTime())
                && other.getStudents().equals(this.getStudents());
    }

    /**
     * Generates a human-readable representation of the session, including the session number and the set of students.
     *
     * @return A string representation of the session.
     */
    public String getConsultationInfo() {
        String studentNames = "";
        if (students != null) {
            studentNames = students.toStudentNames();
        }
        return String.format("%s - %s - %s", date, time, studentNames);
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }

    /**
     * Retrieves the set of students in this consultation.
     *
     * @return The set of students.
     */
    public StudentSet getStudents() {
        if (students == null) {
            students = new StudentSet();
        }
        return students.getStudents();
    }
    public Set<Name> getStudentsNames() {
        return students.stream().map(Person::getName).collect(Collectors.toSet());
    }
}
