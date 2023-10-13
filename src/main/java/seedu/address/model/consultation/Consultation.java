package seedu.address.model.consultation;

import seedu.address.model.person.Person;

import java.util.Set;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a Consultation with a date, time and specified students.
 */
public class Consultation {
    private LocalDate date;
    private LocalTime time;
    private Set<Person> students;

    /**
     * Constructs an {@code Consultation}.
     *
     * @param date A valid date object.
     * @param time A valid time object.
     * @param students A set of students.
     */
    public Consultation(LocalDate date, LocalTime time, Set<Person> students) {
        this.date = date;
        this.time = time;
        this.students = students;
    }

    /**
     * Adds a student to the consultation.
     * The person must not already exist in the consultation.
     */
    public void addStudent(Person p) {
        students.add(p);
    }

    /**
     * Removes {@code key} from this {@code Consultation}.
     * {@code key} must exist in the consultation.
     */
    public void removeStudent(Person key) {
        students.remove(key);
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
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

    public boolean isSameConsultation(Consultation other) {
        return other.equals(this);
    }

    public LocalDate getDate() {
        return date;
    }
    public LocalTime getTime() {
        return time;
    }
    public Set<Person> getStudents() {
        return students;
    }
    public String getConsultationInfo() {
        return String.format("%s, %s - %s", date, time, students);
    }
}
