package seedu.address.model.session;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Tests that a {@code Session}'s {@code SessionStudents} matches any of the keywords given.
 */
public class SessionStudentsContainsKeywordsPredicate implements Predicate<Session> {
    private final List<String> keywords;

    public SessionStudentsContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Session session) {
        return keywords.stream()
                .anyMatch(keyword -> containsSubstringIgnoreCase(
                        session.getStudents().toStudentNames(), keyword));
    }

    private boolean containsSubstringIgnoreCase(String str, String substring) {
        // Convert both the main string and substring to lowercase for a case-insensitive match
        String lowerCaseStr = str.toLowerCase();
        String lowerCaseSubstring = substring.toLowerCase();

        // Check if the main string contains the substring
        return lowerCaseStr.contains(lowerCaseSubstring);
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
        return keywords.equals(otherSessionStudentsContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("session keywords", keywords).toString();
    }
}
