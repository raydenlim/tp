package seedu.address.model;

import javafx.collections.ObservableMap;
import seedu.address.model.person.assignment.Assignment;
import seedu.address.model.person.assignment.AssignmentMap;
import seedu.address.model.person.assignment.AssignmentName;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.requireNonNull;

public class AssignmentMapBook implements ReadOnlyAssignmentMap {

    private final AssignmentMap assignments;

    {
        assignments = new AssignmentMap();
    }

    public AssignmentMapBook() {}

    public AssignmentMapBook(ReadOnlyAssignmentMap toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    public void setAssignments(Map<AssignmentName, Assignment> newAssignments) {
        this.assignments.setAssignmentMap(newAssignments);
    }

    public void resetData(ReadOnlyAssignmentMap newData) {
        requireNonNull(newData);

        setAssignments(newData.getAssignmentMap());
    }

    public Assignment getAssignment(AssignmentName assignmentName) {
        return assignments.get(assignmentName);
    }

    @Override
    public ObservableMap<AssignmentName, Assignment> getAssignmentMap() {
        return assignments.asUnmodifiableObservableMap();
    }
}
