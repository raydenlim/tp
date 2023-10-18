package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import seedu.address.model.ReadOnlyAssignmentMap;
import seedu.address.model.person.assignment.AssignmentMap;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.Grade;
import seedu.address.model.person.assignment.initialise.AssignmentInitialise;

import java.util.HashMap;

@JsonRootName(value = "assignmentmap")
public class JsonSerializableAssignmentMap {

    private final HashMap<String, JsonAdaptedAssignment> assignments = new HashMap<>();

    @JsonCreator
    public JsonSerializableAssignmentMap(
            @JsonProperty("assignments") HashMap<String, JsonAdaptedAssignment> assignments) {
        for (int i = 0; i < AssignmentInitialise.size(); i++) {
            String assignmentName = AssignmentInitialise.getAssignmentName(i).toString();
            JsonAdaptedAssignment JSONAssignment = assignments.get(assignmentName);
            this.assignments.put(assignmentName, JSONAssignment);
        }
    }

    public JsonSerializableAssignmentMap(ReadOnlyAssignmentMap source) {
        for (int i = 0; i < AssignmentInitialise.size(); i++) {
            AssignmentName assignmentName = AssignmentInitialise.getAssignmentName(i);
            JsonAdaptedAssignment assignmentToBeAdded =
                    new JsonAdaptedAssignment(source.getAssignmentMap().get(assignmentName));
            assignments.put(assignmentName.toString(), assignmentToBeAdded);
        }
    }

    public HashMap<String, JsonAdaptedAssignment> getAssignments() {
        return this.assignments;
    }
}
