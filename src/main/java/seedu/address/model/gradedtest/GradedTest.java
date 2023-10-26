package seedu.address.model.gradedtest;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.parser.exceptions.ParseException;

public class GradedTest {
    public static final String MESSAGE_CONSTRAINTS =
            "GradedTest Names should only contain alphanumeric characters and spaces, and it should not be blank";
    public static final String VALIDATION_REGEX =
            "RA1:[-\\d]+ \\| RA2:[-\\d]+ \\| MidTerms:[-\\d]+ \\| Finals:[-\\d]+ \\| PE:[-\\d]+";

    public static final String DEFAULT_VALUE = "-";
    // Identity fields
    public final String gradedTestsIndv;

    // Data fields
    private final ReadingAssessment1 readingAssessment1;
    private final ReadingAssessment2 readingAssessment2;
    private final MidTerms midTerms;
    private final Finals finals;
    private final PracticalExam practicalExam;

    /**
     * Constructs a {@code GradedTest}.
     *
     * @param readingAssessment1 The first reading assessment.
     * @param readingAssessment2 The second reading assessment.
     * @param midTerms The mid-terms.
     * @param finals The finals.
     * @param practicalExam The practical exam.
     */
    public GradedTest(ReadingAssessment1 readingAssessment1, ReadingAssessment2 readingAssessment2,
                      MidTerms midTerms, Finals finals, PracticalExam practicalExam) {
        requireAllNonNull(readingAssessment1, readingAssessment2, midTerms, finals, practicalExam);
        this.readingAssessment1 = readingAssessment1;
        this.readingAssessment2 = readingAssessment2;
        this.midTerms = midTerms;
        this.finals = finals;
        this.practicalExam = practicalExam;
        this.gradedTestsIndv =
                "RA1:" + readingAssessment1.toString() + " | "
                + "RA2:" + readingAssessment2.toString() + " | "
                + "MidTerms:" + midTerms.toString() + " | "
                + "Finals:" + finals.toString() + " | "
                + "PE:" + practicalExam.toString();
    }

    /**
     * Constructs a {@code GradedTest}.
     *
     * @param gradedTestsIndv A valid gradedTest name.
     */
    public GradedTest(String gradedTestsIndv) {
        this.gradedTestsIndv = gradedTestsIndv;
        requireNonNull(gradedTestsIndv);
        if (!isValidGradeTestName(gradedTestsIndv)) {
            throw new IllegalArgumentException(MESSAGE_CONSTRAINTS);
        }
        try {
            this.readingAssessment1 = new ReadingAssessment1(parseGradedTest(gradedTestsIndv)[0]);
            this.readingAssessment2 = new ReadingAssessment2(parseGradedTest(gradedTestsIndv)[1]);
            this.midTerms = new MidTerms(parseGradedTest(gradedTestsIndv)[2]);
            this.finals = new Finals(parseGradedTest(gradedTestsIndv)[3]);
            this.practicalExam = new PracticalExam(parseGradedTest(gradedTestsIndv)[4]);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private String[] parseGradedTest(String gradedTestsIndv) throws ParseException {
        String[] components = gradedTestsIndv.split("\\|");

        if (components.length != 5) {
            throw new ParseException("Invalid GradedTest format. Expected 5 components.");
        }
        String ra1Score = components[0].replaceAll("RA1:", "").trim();
        String ra2Score = components[1].replaceAll("RA2:", "").trim();
        String midTermsScore = components[2].replaceAll("MidTerms:", "").trim();
        String finalsScore = components[3].replaceAll("Finals:", "").trim();
        String peScore = components[4].replaceAll("PE:", "").trim();
        return new String[]{ra1Score, ra2Score, midTermsScore, finalsScore, peScore};
    }

    public ReadingAssessment1 getRA1() {
        return readingAssessment1;
    }

    public ReadingAssessment2 getRA2() {
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

    public String getGradedTests() {
        return gradedTestsIndv;
    }


    // Setter Methods
    public GradedTest updateRA1(ReadingAssessment1 score) {
        return new GradedTest(score, this.readingAssessment2, this.midTerms, this.finals, this.practicalExam);
    }

    public GradedTest updateRA2(ReadingAssessment2 score) {
        return new GradedTest(this.readingAssessment1, score, this.midTerms, this.finals, this.practicalExam);
    }

    public GradedTest updateMidTerms(MidTerms score) {
        return new GradedTest(this.readingAssessment1, this.readingAssessment2, score, this.finals, this.practicalExam);
    }

    public GradedTest updateFinals(Finals score) {
        return new GradedTest(this.readingAssessment1,
                this.readingAssessment2, this.midTerms, score, this.practicalExam);
    }

    public GradedTest updatePE(PracticalExam score) {
        return new GradedTest(this.readingAssessment1, this.readingAssessment2, this.midTerms, this.finals, score);
    }

    /**
     * Returns true if a given string is a valid gradedTest name.
     */
    public static boolean isValidGradeTestName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns true if both tasks have the same name and description.
     */
    public boolean isSameGradedTest(GradedTest otherGradedTest) {
        if (otherGradedTest == this) {
            return true;
        }

        return otherGradedTest != null
                && otherGradedTest.getGradedTests().equals(gradedTestsIndv)
                && otherGradedTest.getRA1().equals(readingAssessment1)
                && otherGradedTest.getRA2().equals(readingAssessment2)
                && otherGradedTest.getMidTerms().equals(midTerms)
                && otherGradedTest.getFinals().equals(finals)
                && otherGradedTest.getPracticalExam().equals(practicalExam);
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
                && practicalExam.equals(otherTest.practicalExam)
                && gradedTestsIndv.equals(otherTest.gradedTestsIndv);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(readingAssessment1, readingAssessment2, midTerms, finals, practicalExam);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("RA1", readingAssessment1)
                .add("RA2", readingAssessment2)
                .add("MidTerms", midTerms)
                .add("Finals", finals)
                .add("PE", practicalExam)
                .toString();
    }

}
