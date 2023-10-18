package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.assignment.Assignment;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.Grade;
import seedu.address.model.task.TaskDescription;

/**
 * Jackson-friendly version of {@link Assignment}.
 */
public class JsonAdaptedAssignment {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Assignment's %s field is missing!";

    private final String name;
    private final String grade;

    /**
     * Constructs a {@code JsonAdaptedAssignment} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedAssignment(String jsonData) {
        String[] splitData = jsonData.split(": ");
        this.name = splitData[0];
        this.grade = splitData[1];
    }

    /**
     * Converts a given {@code Assignment} into this class for Jackson use.
     */
    public JsonAdaptedAssignment(Assignment source) {
        name = source.name();
        grade = source.gradeToString();
    }

    @JsonValue
    public String getAssignmentDetails() {
        return name + ": " + grade;
    }

    /**
     * Converts this Jackson-friendly adapted assignment object into the model's {@code Assignment} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted assignment.
     */
    public Assignment toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    AssignmentName.class.getSimpleName()));
        }

        final AssignmentName modelName = new AssignmentName(name);

        if (grade == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TaskDescription.class.getSimpleName()));
        }
        // Add valid grade checker later

        final Grade modelGrade;
        if (grade.startsWith("UNGRADED/")) {
            String maxGradeString = grade.substring(9);
            modelGrade = new Grade(maxGradeString);
        } else {
            String[] arrOfGradeStrings = grade.split("/");
            String actualGradeString = arrOfGradeStrings[0];
            String maxGradeString = arrOfGradeStrings[1];
            modelGrade = new Grade(actualGradeString, maxGradeString);
        }
        return new Assignment(modelName, modelGrade);
    }
}
