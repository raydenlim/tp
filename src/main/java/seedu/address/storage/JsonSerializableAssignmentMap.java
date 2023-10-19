package seedu.address.storage;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.model.ReadOnlyAssignmentMap;
import seedu.address.model.person.assignment.AssignmentMap;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.initialise.AssignmentInitialise;

/**
 * An Immutable AssignmentMap that is serializable to JSON format.
 */
public class JsonSerializableAssignmentMap {

    private final HashMap<String, JsonAdaptedAssignment> assignments;

    /**
     * Constructs a {@code JsonSerializableAssignmentMap} with the given persons.
     */
    @JsonCreator
    public JsonSerializableAssignmentMap(
            @JsonProperty("assignments") HashMap<String, JsonAdaptedAssignment> assignments) {
        this.assignments = assignments;
    }

    /**
     * Converts a given {@code ReadOnlyAssignmentMap} into this class for Jackson use.
     *
     * @param source future changes to this will not affect the created {@code JsonSerializableAssignmentMap}.
     */
    public JsonSerializableAssignmentMap(ReadOnlyAssignmentMap source) {
        this.assignments = new HashMap<String, JsonAdaptedAssignment>();
        for (int i = 0; i < AssignmentInitialise.size(); i++) {
            AssignmentName assignmentName = AssignmentInitialise.getAssignmentName(i);
            JsonAdaptedAssignment assignmentToBeAdded =
                    new JsonAdaptedAssignment(source.getAssignmentMap().get(assignmentName));
            this.assignments.put(assignmentName.toString(), assignmentToBeAdded);
        }
    }

    public HashMap<String, JsonAdaptedAssignment> getAssignments() {
        return this.assignments;
    }
}
