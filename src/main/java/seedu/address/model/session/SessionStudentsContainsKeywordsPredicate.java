package seedu.address.model.session;

import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.person.Person;

/**
 * Tests that a {@code Session}'s {@code SessionStudents} matches any of the keywords given.
 */
public class SessionStudentsContainsKeywordsPredicate implements Predicate<Session> {
    private final Set<Person> students;

    public SessionStudentsContainsKeywordsPredicate(Set<Person> students) {
        this.students = students;
    }

    @Override
    public boolean test(Session session) {
        for (Person student : students) {
            if (session.getStudents().contains(student)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SessionStudentsContainsKeywordsPredicate)) {
            return false;
        }

        SessionStudentsContainsKeywordsPredicate otherSessionStudentsContainsKeywordsPredicate =
                (SessionStudentsContainsKeywordsPredicate) other;
        return students.equals(otherSessionStudentsContainsKeywordsPredicate.students);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("session students", students).toString();
    }
}
