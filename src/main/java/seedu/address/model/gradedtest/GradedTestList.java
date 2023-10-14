package seedu.address.model.gradedtest;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.task.exceptions.DuplicateTaskException;
import seedu.address.model.task.exceptions.GradedTestNotFoundException;
import seedu.address.model.task.exceptions.TaskNotFoundException;

/**
 * A list of tasks that enforces uniqueness between its elements and does not allow nulls.
 * A task is considered unique by comparing using {@code GradedTest#isSameGradedTest(gradedTest)}.
 * As such, adding and updating of tasks uses GradedTest#isSameGradedTest(gradedTest) for equality
 * so as to ensure that the task being added or updated is unique in terms of identity in the GradedTestList.
 * However, the removal of a task uses GradedTest#equals(Object) so as to ensure that the task with exactly
 * the same fields will be removed.
 *
 * Supports a minimal set of list operations.
 *
 * @see GradedTest#isSameGradedTest(GradedTest)
 */
public class GradedTestList implements Iterable<GradedTest> {

    private final ObservableList<GradedTest> internalList = FXCollections.observableArrayList();
    private final ObservableList<GradedTest> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent gradedTest as the given argument.
     */
    public boolean contains(GradedTest toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameGradedTest);
    }

    /**
     * Returns the gradedTest at the given index.
     */
    public GradedTest getGradedTest(int index) {
        if (index >= internalList.size()) {
            throw new IllegalArgumentException("Index is out of bounds");
        }

        return internalList.get(index);
    }

    /**
     * Adds a task to the list.
     * The task must not already exist in the list.
     */
    public void add(GradedTest toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateTaskException();
        }
        internalList.add(toAdd);
    }

    /**
     * Replaces the gradedTest {@code target} in the list with {@code editedGradedTest}.
     * {@code target} must exist in the list.
     * The task identity of {@code editedGradedTest} must not be the same as another existing task in the list.
     */
    public void editGradedTest(GradedTest target, GradedTest editedGradedTest) {
        requireAllNonNull(target, editedGradedTest);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new TaskNotFoundException();
        }

        if (!target.isSameGradedTest(editedGradedTest) && contains(editedGradedTest)) {
            throw new DuplicateTaskException();
        }

        internalList.set(index, editedGradedTest);
    }

    /**
     * Removes the equivalent gradedTest from the list.
     * The gradedTest must exist in the list.
     */
    public void remove(GradedTest toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new GradedTestNotFoundException();
        }
    }

    public void setTasks(GradedTestList replacement) {
        requireNonNull(replacement);
        internalList.setAll(replacement.internalList);
    }

    /**
     * Replaces the contents of this list with {@code gradedTest}.
     * {@code gradedTest} must not contain duplicate gradedTest.
     */
    public void setGradedTests(List<GradedTest> gradedTests) {
        requireAllNonNull(gradedTests);
        if (!isUniqueGradedTest(gradedTests)) {
            throw new DuplicateTaskException();
        }

        internalList.setAll(gradedTests);
    }

    /**
     * Returns the backing list as an unmodifiable {@code ObservableList}.
     */
    public ObservableList<GradedTest> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<GradedTest> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof GradedTestList)) {
            return false;
        }

        GradedTestList otherUniquePersonList = (GradedTestList) other;
        return internalList.equals(otherUniquePersonList.internalList);
    }

    @Override
    public int hashCode() {
        return internalList.hashCode();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }

    /**
     * Returns true if {@code gradedTest} contains only unique gradedTest.
     */
    private boolean isUniqueGradedTest(List<GradedTest> gradedTests) {
        for (int i = 0; i < gradedTests.size() - 1; i++) {
            for (int j = i + 1; j < gradedTests.size(); j++) {
                if (gradedTests.get(i).isSameGradedTest(gradedTests.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }
}
