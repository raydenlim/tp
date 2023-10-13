package seedu.address.model.session;

import seedu.address.model.person.Person;

import java.util.Set;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
public class Session {
    private final int sessionNumber;
    private Set<Person> students;

    public Session(int sessionNumber, Set<Person> presentStudents) {
        requireAllNonNull(sessionNumber, presentStudents);
        this.sessionNumber = sessionNumber;
    }

    public void addStudent(Person p) {
        students.add(p);
    }

    public void removeStudent(Person key) {
        students.remove(key);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        Session otherSession = (Session) other;
        return students.equals(otherSession.students)
                && otherSession.sessionNumber == sessionNumber;
    }

    public boolean isSameSession(Session other) {
        return other.equals(this);
    }

    public Set<Person> getStudents() {
        return students;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

}
