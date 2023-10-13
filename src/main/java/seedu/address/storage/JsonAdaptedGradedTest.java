package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.gradedtest.Finals;
import seedu.address.model.gradedtest.GradedTest;
import seedu.address.model.gradedtest.MidTerms;
import seedu.address.model.gradedtest.PracticalExam;
import seedu.address.model.gradedtest.ReadingAssessment;

/**
 * Jackson-friendly version of {@link GradedTest}.
 */
class JsonAdaptedGradedTest {

    private String gradedTestName;
    private ReadingAssessment readingAssessment1;
    private ReadingAssessment readingAssessment2;
    private MidTerms midTerms;
    private Finals finals;
    private PracticalExam practicalExam;

    /**
     * Constructs a {@code JsonAdaptedGradedTest} with the given {@code gradedTestName}.
     */
    @JsonCreator
    public JsonAdaptedGradedTest(String gradedTestName) {
        this.gradedTestName = gradedTestName;
    }

    @JsonCreator
    public JsonAdaptedGradedTest(@JsonProperty("readingAssessment1") ReadingAssessment readingAssessment1,
                                 @JsonProperty("readingAssessment2") ReadingAssessment readingAssessment2,
                                 @JsonProperty("midTerms") MidTerms midTerms,
                                 @JsonProperty("finals") Finals finals,
                                 @JsonProperty("practicalExam") PracticalExam practicalExam) {
        this.readingAssessment1 = readingAssessment1;
        this.readingAssessment2 = readingAssessment2;
        this.midTerms = midTerms;
        this.finals = finals;
        this.practicalExam = practicalExam;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedGradedTest(GradedTest source) {
        gradedTestName = source.getGradedTestName();
    }

    @JsonValue
    public String getGradedTestName() {
        return gradedTestName;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code GradedTest} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted gradedTest.
     */
    public GradedTest toModelType() throws IllegalValueException {
        if (!GradedTest.isValidGradeTestName(gradedTestName)) {
            throw new IllegalValueException(GradedTest.MESSAGE_CONSTRAINTS);
        }
        return new GradedTest(readingAssessment1, readingAssessment2, midTerms, finals, practicalExam);
        // return new GradedTest(gradedTestName);
    }

}
