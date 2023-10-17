package seedu.address.testutil;

import seedu.address.model.gradedtest.Finals;
import seedu.address.model.gradedtest.GradedTest;
import seedu.address.model.gradedtest.MidTerms;
import seedu.address.model.gradedtest.PracticalExam;
import seedu.address.model.gradedtest.ReadingAssessment;

/**
 * A utility class for building GradedTest objects for testing.
 * It provides methods for setting individual components of a GradedTest object.
 * You can create GradedTest objects with custom attributes or use default values.
 */
public class GradedTestBuilder {
    public static final String DEFAULT_RA1 = "-";
    public static final String DEFAULT_RA2 = "-";
    public static final String DEFAULT_MIDTERMS = "-";
    public static final String DEFAULT_FINALS = "-";
    public static final String DEFAULT_PE = "-";


    private ReadingAssessment rA1;
    private ReadingAssessment rA2;
    private MidTerms midterms;
    private Finals finals;
    private PracticalExam pE;


    /**
     * Creates a {@code TaskBuilder} with the default details.
     */
    public GradedTestBuilder() {
        rA1 = new ReadingAssessment(DEFAULT_RA1);
        rA2 = new ReadingAssessment(DEFAULT_RA2);
        midterms = new MidTerms(DEFAULT_MIDTERMS);
        finals = new Finals(DEFAULT_FINALS);
        pE = new PracticalExam(DEFAULT_PE);
    }

    /**
     * Initializes the TaskBuilder with the data of {@code gradedTest}.
     */
    public GradedTestBuilder(GradedTest gradedTest) {
        rA1 = gradedTest.getRA1();
        rA2 = gradedTest.getRA2();
        midterms = gradedTest.getMidTerms();
        finals = gradedTest.getFinals();
        pE = gradedTest.getPracticalExam();

    }

    /**
     * Sets the {@code Description} of the {@code Task} that we are building.
     */
    public GradedTestBuilder withReadingAssessment1(String rA1) {
        this.rA1 = new ReadingAssessment(rA1);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Task} that we are building.
     */
    public GradedTestBuilder withReadingAssessment2(String rA2) {
        this.rA2 = new ReadingAssessment(rA2);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Task} that we are building.
     */
    public GradedTestBuilder withMidTerms(String midTerms) {
        this.midterms = new MidTerms(midTerms);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Task} that we are building.
     */
    public GradedTestBuilder withFinals(String finals) {
        this.finals = new Finals(finals);
        return this;
    }

    /**
     * Sets the {@code Description} of the {@code Task} that we are building.
     */
    public GradedTestBuilder withPe(String pE) {
        this.pE = new PracticalExam(pE);
        return this;
    }

    public GradedTest build() {
        return new GradedTest(rA1, rA2, midterms, finals, pE);
    }
}
