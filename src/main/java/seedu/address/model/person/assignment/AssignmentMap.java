package seedu.address.model.person.assignment;

import javafx.collections.ObservableMap;
import seedu.address.model.person.assignment.initialise.AssignmentInitialise;

import java.util.HashMap;
import java.util.Map;

import static javafx.collections.FXCollections.observableHashMap;
import static javafx.collections.FXCollections.unmodifiableObservableMap;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class AssignmentMap {
    private final ObservableMap<AssignmentName, Assignment> assignments = observableHashMap();
    private final ObservableMap<AssignmentName, Assignment> unmodifiableAssignments =
            unmodifiableObservableMap(assignments);

    public AssignmentMap() {
        if (!AssignmentInitialise.isInitialised) {
            AssignmentInitialise.Init();
        }
        for (int i = 0; i < AssignmentInitialise.size(); i++) {
            AssignmentName assignmentName = AssignmentInitialise.getAssignmentName(i);
            Grade assignmentMaxGrade = AssignmentInitialise.getAssignmentMaxGrade(i);
            assignments.put(assignmentName, new Assignment(assignmentName, assignmentMaxGrade));
        }
    }

    public void setAssignmentMap(Map<AssignmentName, Assignment> assignments) {
        for (int i = 0; i < AssignmentInitialise.size(); i++) {
            AssignmentName assignmentName = AssignmentInitialise.getAssignmentName(i);
            Assignment replaceAssignment = assignments.get(assignmentName);
            this.assignments.replace(assignmentName, replaceAssignment.copyAssignment());
        }
    }

    public AssignmentMap copy() {
        AssignmentMap copyTo = new AssignmentMap();
        for (int i = 0; i < AssignmentInitialise.size(); i++) {
            AssignmentName assignmentName = AssignmentInitialise.getAssignmentName(i);
            Assignment originalAssignment = this.assignments.get(assignmentName);
            copyTo.assignments.replace(assignmentName, originalAssignment.copyAssignment());
        }
        return copyTo;
    }

    public AssignmentMap createUpdatedMap(AssignmentName toBeGraded, Grade newGrade) {
        AssignmentMap updateTo = new AssignmentMap();
        for (int i = 0; i < AssignmentInitialise.size(); i++) {
            AssignmentName assignmentName = AssignmentInitialise.getAssignmentName(i);
            if (assignmentName.equals(toBeGraded)) {
                Assignment gradedAssignment = new Assignment(toBeGraded, newGrade);
                updateTo.assignments.replace(assignmentName, gradedAssignment);
            } else {
                Assignment originalAssignment = this.assignments.get(assignmentName);
                updateTo.assignments.replace(assignmentName, originalAssignment.copyAssignment());
            }
        }
        return updateTo;
    }

    public boolean contains(AssignmentName key) {
        return assignments.containsKey(key);
    }

    public Assignment get(AssignmentName key) {
        return assignments.get(key);
    }

    public ObservableMap<AssignmentName, Assignment> asUnmodifiableObservableMap() {
        return unmodifiableAssignments;
    }
}
