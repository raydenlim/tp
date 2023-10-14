package seedu.address.model;

import javafx.collections.ObservableMap;
import seedu.address.model.person.assignment.Assignment;
import seedu.address.model.person.assignment.AssignmentName;

public interface ReadOnlyAssignmentMap {
    ObservableMap<AssignmentName, Assignment> getAssignmentMap();
}
