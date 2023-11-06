package seedu.address.model.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.SessionBuilder;
import seedu.address.testutil.TypicalPersons;

public class SessionStudentsContainsKeywordsPredicateTest {

    @Test
    public void equals() {
        Set<Person> firstPredicateKeywordSet = Collections.singleton(
                new PersonBuilder(TypicalPersons.ALICE).build());
        Set<Person> secondPredicateKeywordSet = new HashSet<>(Arrays.asList(
                new PersonBuilder(TypicalPersons.ALICE).build(), new PersonBuilder(TypicalPersons.BOB).build()));

        SessionStudentsContainsKeywordsPredicate firstPredicate =
                new SessionStudentsContainsKeywordsPredicate(firstPredicateKeywordSet);
        SessionStudentsContainsKeywordsPredicate secondPredicate =
                new SessionStudentsContainsKeywordsPredicate(secondPredicateKeywordSet);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        SessionStudentsContainsKeywordsPredicate firstPredicateCopy =
                new SessionStudentsContainsKeywordsPredicate(firstPredicateKeywordSet);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different predicate -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_sessionStudentsContainsKeywords_returnsTrue() {
        // One keyword
        Set<Person> firstPredicateKeywordSet = Collections.singleton(new PersonBuilder(TypicalPersons.ALICE).build());
        SessionStudentsContainsKeywordsPredicate predicate =
                new SessionStudentsContainsKeywordsPredicate(firstPredicateKeywordSet);
        assertTrue(predicate.test(new SessionBuilder().withStudent(TypicalPersons.ALICE).build()));

        // Multiple keywords
        Set<Person> secondPredicateKeywordSet = new HashSet<>(Arrays.asList(
                new PersonBuilder(TypicalPersons.ALICE).build(), new PersonBuilder(TypicalPersons.BOB).build()));
        predicate = new SessionStudentsContainsKeywordsPredicate(secondPredicateKeywordSet);
        assertTrue(predicate.test(new SessionBuilder().withStudents(TypicalPersons.ALICE, TypicalPersons.BOB).build()));

        // Only one matching keyword
        predicate = new SessionStudentsContainsKeywordsPredicate(secondPredicateKeywordSet);
        assertTrue(predicate.test(new SessionBuilder().withStudent(TypicalPersons.BOB).build()));
    }

    @Test
    public void test_sessionStudentDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        SessionStudentsContainsKeywordsPredicate predicate =
                new SessionStudentsContainsKeywordsPredicate(Collections.emptySet());
        assertFalse(predicate.test(new SessionBuilder().withStudent(TypicalPersons.CARL).build()));

        // Non-matching keyword
        Set<Person> keywordSet = Collections.singleton(new PersonBuilder().withName("Alice").build());
        predicate = new SessionStudentsContainsKeywordsPredicate(keywordSet);
        assertFalse(predicate.test(new SessionBuilder().withStudent(TypicalPersons.CARL).build()));
    }

    @Test
    public void toStringMethod() {
        Set<Person> keywordSet = new HashSet<>(Arrays.asList(
                new PersonBuilder().withName("keyword1").build(), new PersonBuilder().withName("keyword2").build()));
        SessionStudentsContainsKeywordsPredicate predicate = new SessionStudentsContainsKeywordsPredicate(keywordSet);

        String expected = SessionStudentsContainsKeywordsPredicate.class.getCanonicalName()
                + "{session students=" + keywordSet + "}";
        assertEquals(expected, predicate.toString());
    }
}
