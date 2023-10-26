package seedu.address.model.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.SessionBuilder;
import seedu.address.testutil.TypicalPersons;

public class SessionStudentsContainsKeywordsPredicateTest {
    @Test
    public void equals() {
        List<String> firstPredicateKeywordList = Collections.singletonList("Alice");
        List<String> secondPredicateKeywordList = Arrays.asList("Alice", "Alex");

        SessionStudentsContainsKeywordsPredicate firstPredicate =
                new SessionStudentsContainsKeywordsPredicate(firstPredicateKeywordList);
        SessionNumberContainsKeywordsPredicate secondPredicate =
                new SessionNumberContainsKeywordsPredicate(secondPredicateKeywordList);

        // same object -> returns true
        assertTrue(firstPredicate.equals(firstPredicate));

        // same values -> returns true
        SessionStudentsContainsKeywordsPredicate firstPredicateCopy =
                new SessionStudentsContainsKeywordsPredicate(firstPredicateKeywordList);
        assertTrue(firstPredicate.equals(firstPredicateCopy));

        // different types -> returns false
        assertFalse(firstPredicate.equals(1));

        // null -> returns false
        assertFalse(firstPredicate.equals(null));

        // different task -> returns false
        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_sessionStudentsContainsKeywords_returnsTrue() {
        // One keyword
        Person alice = new PersonBuilder(TypicalPersons.ALICE).build();
        Person bob = new PersonBuilder(TypicalPersons.BOB).build();
        SessionStudentsContainsKeywordsPredicate predicate =
                new SessionStudentsContainsKeywordsPredicate(Collections.singletonList("Alice"));
        assertTrue(predicate.test(new SessionBuilder().withStudent(alice).build()));

        // Multiple keywords
        predicate = new SessionStudentsContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        assertTrue(predicate.test(new SessionBuilder().withStudents(alice, bob).build()));

        // Only one matching keyword
        predicate = new SessionStudentsContainsKeywordsPredicate(Arrays.asList("Alice", "Bob"));
        assertTrue(predicate.test(new SessionBuilder().withStudent(bob).build()));
    }

    @Test
    public void test_sessionStudentDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        SessionStudentsContainsKeywordsPredicate predicate =
                new SessionStudentsContainsKeywordsPredicate(Collections.emptyList());
        assertFalse(predicate.test(new SessionBuilder().withStudent(TypicalPersons.CARL).build()));

        // Non-matching keyword
        predicate = new SessionStudentsContainsKeywordsPredicate(Arrays.asList("Alice"));
        assertFalse(predicate.test(new SessionBuilder().withStudent(TypicalPersons.CARL).build()));

    }

    @Test
    public void toStringMethod() {
        List<String> keywords = List.of("keyword1", "keyword2");
        SessionStudentsContainsKeywordsPredicate predicate = new SessionStudentsContainsKeywordsPredicate(keywords);

        String expected = SessionStudentsContainsKeywordsPredicate.class.getCanonicalName()
                + "{session keywords=" + keywords + "}";
        assertEquals(expected, predicate.toString());
    }
}
