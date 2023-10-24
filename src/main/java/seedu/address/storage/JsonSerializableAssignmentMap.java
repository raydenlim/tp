package seedu.address.storage;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import seedu.address.model.ReadOnlyAssignmentMap;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.initialise.AssignmentInitialise;

/**
 * An Immutable AssignmentMap that is serializable to JSON format.
 */
@JsonRootName("assignmentMap")
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

    public HashMap<String, JsonAdaptedAssignment> getAssignments() {
        return this.assignments;
    }
}
