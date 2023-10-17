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

import static seedu.address.model.gradedtest.GradedTest.DEFAULT_VALUE;

/**
 * Jackson-friendly version of {@link GradedTest}.
 */
class JsonAdaptedGradedTest {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "GradedTest's %s field is missing!";
    private final String gradedTestIndv;
    private final String readingAssessment1;
    private final String readingAssessment2;
    private final String midTerms;
    private final String finals;
    private final String practicalExam;

    /**
     * Constructs a {@code JsonAdaptedGradedTest} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedGradedTest(String gradedTestIndv) {
        this.gradedTestIndv = gradedTestIndv;
        String[] parts = gradedTestIndv.split("\\|");
        if (parts.length == 5) {
            this.readingAssessment1 = parts[0].trim();
            this.readingAssessment2 = parts[1].trim();
            this.midTerms = parts[2].trim();
            this.finals = parts[3].trim();
            this.practicalExam = parts[4].trim();
        } else {
            this.readingAssessment1 = DEFAULT_VALUE;
            this.readingAssessment2 = DEFAULT_VALUE;
            this.midTerms = DEFAULT_VALUE;
            this.finals = DEFAULT_VALUE;
            this.practicalExam = DEFAULT_VALUE;
        }
    }

    @JsonCreator
    public JsonAdaptedGradedTest(@JsonProperty("readingAssessment1") String readingAssessment1,
                                 @JsonProperty("readingAssessment2") String readingAssessment2,
                                 @JsonProperty("midTerms") String midTerms,
                                 @JsonProperty("finals") String finals,
                                 @JsonProperty("practicalExam") String practicalExam) {
        this.readingAssessment1 = readingAssessment1;
        this.readingAssessment2 = readingAssessment2;
        this.midTerms = midTerms;
        this.finals = finals;
        this.practicalExam = practicalExam;
        this.gradedTestIndv = readingAssessment1 + readingAssessment2
                + midTerms + finals + practicalExam;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedGradedTest(GradedTest source) {
        readingAssessment1 = source.getRA1().value;
        readingAssessment2 = source.getRA2().value;
        midTerms = source.getMidTerms().value;
        finals = source.getFinals().value;
        practicalExam = source.getPracticalExam().value;
        this.gradedTestIndv = readingAssessment1 + readingAssessment2
                + midTerms + finals + practicalExam;
    }


    @JsonValue
    public String getGradedTestName() {
        return gradedTestIndv;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code GradedTest} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted gradedTest.
     */
    public GradedTest toModelType() throws IllegalValueException {
        if (readingAssessment1 == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ReadingAssessment.class.getSimpleName()));
        }
        if (!ReadingAssessment.isValidRaResult(readingAssessment1)) {
            throw new IllegalValueException(ReadingAssessment.MESSAGE_CONSTRAINTS);
        }
        final ReadingAssessment modelRA1 = new ReadingAssessment(readingAssessment1);

        if (readingAssessment2 == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    ReadingAssessment.class.getSimpleName()));
        }
        if (!ReadingAssessment.isValidRaResult(readingAssessment2)) {
            throw new IllegalValueException(ReadingAssessment.MESSAGE_CONSTRAINTS);
        }
        final ReadingAssessment modelRA2 = new ReadingAssessment(readingAssessment2);

        if (midTerms == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    MidTerms.class.getSimpleName()));
        }
        if (!MidTerms.isValidMidTermResult(midTerms)) {
            throw new IllegalValueException(MidTerms.MESSAGE_CONSTRAINTS);
        }
        final MidTerms modelMidTerms = new MidTerms(midTerms);

        if (finals == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Finals.class.getSimpleName()));
        }
        if (!Finals.isValidFinalsResult(finals)) {
            throw new IllegalValueException(MidTerms.MESSAGE_CONSTRAINTS);
        }
        final Finals modelFinals = new Finals(finals);

        if (practicalExam == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    PracticalExam.class.getSimpleName()));
        }
        if (!PracticalExam.isValidPeResult(practicalExam)) {
            throw new IllegalValueException(PracticalExam.MESSAGE_CONSTRAINTS);
        }
        final PracticalExam modelPE = new PracticalExam(practicalExam);

        return new GradedTest(modelRA1, modelRA2, modelMidTerms, modelFinals, modelPE);
    }

}
