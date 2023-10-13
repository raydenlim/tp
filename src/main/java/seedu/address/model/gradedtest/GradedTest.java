package seedu.address.model.gradedtest;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.expectedgrade.ExpectedGrade;

public class GradedTest {
    public static final String MESSAGE_CONSTRAINTS = "Graded Test Scores should be Alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";
    // Identity fields
    private String gradedTestName;
    private ReadingAssessment readingAssessment1;
    private ReadingAssessment readingAssessment2;
    private MidTerms midTerms;
    private Finals finals;
    private PracticalExam practicalExam;

    // Data fields
    private final Set<ExpectedGrade> expectedGrades = new HashSet<>();

    /**
     * Constructs a {@code GradedTest}.
     *
     * @param readingAssessment1 The first reading assessment.
     * @param readingAssessment2 The second reading assessment.
     * @param midTerms The mid-terms.
     * @param finals The finals.
     * @param practicalExam The practical exam.
     */
    public GradedTest(ReadingAssessment readingAssessment1, ReadingAssessment readingAssessment2,
                      MidTerms midTerms, Finals finals, PracticalExam practicalExam) {
        requireAllNonNull(readingAssessment1, readingAssessment2, midTerms, finals, practicalExam);
        this.readingAssessment1 = readingAssessment1;
        this.readingAssessment2 = readingAssessment2;
        this.midTerms = midTerms;
        this.finals = finals;
        this.practicalExam = practicalExam;
    }

    /**
     * Constructs a {@code GradedTest}.
     *
     * @param gradedTestName A valid gradedTest name.
     */
    public GradedTest(String gradedTestName) {
        requireNonNull(gradedTestName);
        checkArgument(isValidGradeTestName(gradedTestName), MESSAGE_CONSTRAINTS);
        this.gradedTestName = gradedTestName;
    }

    public ReadingAssessment getRA1() {
        return readingAssessment1;
    }

    public ReadingAssessment getRA2() {
        return readingAssessment2;
    }

    public MidTerms getMidTerms() {
        return midTerms;
    }

    public Finals getFinals() {
        return finals;
    }

    public PracticalExam getPracticalExam() {
        return practicalExam;
    }

    public String getGradedTestName() {
        return gradedTestName;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<ExpectedGrade> getExpectedGrade() {
        return Collections.unmodifiableSet(expectedGrades);
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidGradeTestName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof GradedTest)) {
            return false;
        }

        GradedTest otherTest = (GradedTest) other;
        return readingAssessment1.equals(otherTest.readingAssessment1)
                && readingAssessment2.equals(otherTest.readingAssessment2)
                && midTerms.equals(otherTest.midTerms)
                && finals.equals(otherTest.finals)
                && practicalExam.equals(otherTest.practicalExam);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(readingAssessment1, readingAssessment2, midTerms, finals, practicalExam);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("readingAssessment1", readingAssessment1)
                .add("readingAssessment2", readingAssessment2)
                .add("midTerms", midTerms)
                .add("finals", finals)
                .add("practicalExam", practicalExam)
                .toString();
    }

}
