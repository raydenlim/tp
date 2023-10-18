package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.assignment.Assignment;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.Grade;
import seedu.address.model.task.TaskDescription;

public class JsonAdaptedAssignment {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Assignment's %s field is missing!";

    private final String name;
    private final String grade;


    /*public JsonAdaptedAssignment(@JsonProperty("assignmentname") String name, @JsonProperty("grade") String grade) {
        this.name = name;
        this.grade = grade;
    }*/
    @JsonCreator
    public JsonAdaptedAssignment(String JSONdata) {
        String[] splitData = JSONdata.split(": ");
        this.name = splitData[0];
        this.grade = splitData[1];
    }

    public JsonAdaptedAssignment(Assignment source) {
        name = source.name();
        grade = source.gradeToString();
    }

    @JsonValue
    public String getAssignmentDetails() {
        return name + ": " + grade;
    }

    public Assignment toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    AssignmentName.class.getSimpleName()));
        }
        if (!AssignmentName.isValidName(name)) {
            throw new IllegalValueException(AssignmentName.MESSAGE_CONSTRAINTS);
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
