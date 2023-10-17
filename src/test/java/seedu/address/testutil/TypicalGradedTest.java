package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.GradedTestListBook;
import seedu.address.model.gradedtest.GradedTest;

/**
 * A utility class containing a list of {@code GradedTest} objects to be used in tests.
 */
public class TypicalGradedTest {

    public static final GradedTest GT1 = new GradedTestBuilder()
            .withReadingAssessment1("1")
            .withReadingAssessment2("2")
            .withMidTerms("3")
            .withFinals("4")
            .withPe("5")
            .build();

    public static final GradedTest GT2 = new GradedTestBuilder()
            .withReadingAssessment1("-")
            .withReadingAssessment2("-")
            .withMidTerms("-")
            .withFinals("-")
            .withPe("-")
            .build();

    // Pass, floats allowed
    public static final GradedTest GT3 = new GradedTestBuilder()
            .withReadingAssessment1("1.0")
            .withReadingAssessment2("2.0")
            .withMidTerms("3.0")
            .withFinals("4.0")
            .withPe("5.0")
            .build();

    public static final GradedTest GT4 = new GradedTestBuilder()
            .withReadingAssessment1("1")
            .withReadingAssessment2("2.0")
            .withMidTerms("3")
            .withFinals("4.0")
            .withPe("5")
            .build();

    private TypicalGradedTest() {} // prevents instantiation

    /**
     * Returns an {@code GradedTestBook} with all the typical gradedTest.
     */
    public static GradedTestListBook getTypicalGradedTestList() {
        GradedTestListBook ab = new GradedTestListBook();
        for (GradedTest gt : getTypicalGradedTest()) {
            ab.addGradedTest(gt);
        }
        return ab;
    }

    public static List<GradedTest> getTypicalGradedTest() {
        return new ArrayList<>(Arrays.asList(GT1, GT3));
    }

}
