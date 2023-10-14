package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.gradedtest.GradedTest;
import seedu.address.model.gradedtest.GradedTestList;

/**
 * Wraps all data at the task-list level
 * Duplicates are not allowed (by .isSameTask comparison)
 */
public class GradedTestListBook implements ReadOnlyGradedTestList {
    private GradedTestList gradedTests;

    /*
     * The 'unusual' code block below is a non-static initialization block, sometimes used to avoid duplication
     * between constructors. See https://docs.oracle.com/javase/tutorial/java/javaOO/initial.html
     *
     * Note that non-static init blocks are not recommended to use. There are other ways to avoid duplication
     *   among constructors.
     */
    {
        gradedTests = new GradedTestList();
    }

    public GradedTestListBook() {}

    /**
     * Creates an TaskList using the Tasks in the {@code toBeCopied}
     */
    public GradedTestListBook(ReadOnlyGradedTestList toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the task list with {@code tasks}.
     * {@code tasks} must not contain duplicate tasks.
     */
    public void setGradedTests(List<GradedTest> gradedTests) {
        this.gradedTests.setGradedTests(gradedTests);
    }

    /**
     * Resets the existing data of this {@code GradedTestList} with {@code newData}.
     */
    public void resetData(ReadOnlyGradedTestList newData) {
        requireNonNull(newData);

        setGradedTests(newData.getGradedTestList());
    }

    //// task-level operations

    /**
     * Returns the task at the given index.
     */
    public GradedTest getGradedTest(int index) {
        return gradedTests.getGradedTest(index);
    }

    /**
     * Returns true if a task with the same identity as {@code gradedTest} exists in the task list.
     */
    public boolean hasGradedTest(GradedTest gradedTest) {
        requireNonNull(gradedTest);
        return gradedTests.contains(gradedTest);
    }

    /**
     * Adds a task to the task list.
     * The task must not already exist in the task list.
     */
    public void addGradedTest(GradedTest gt) {
        gradedTests.add(gt);
    }

    /**
     * Replaces the given task {@code target} in the list with {@code editedTask}.
     * {@code target} must exist in the task list.
     * The task identity of {@code editedTask} must not be the same as another existing task in the task list.
     */
    public void setGradedTests(GradedTest target, GradedTest editedGradedTest) {
        requireNonNull(editedGradedTest);

        gradedTests.editGradedTest(target, editedGradedTest);
    }

    /**
     * Removes {@code key} from this {@code GradedTestListBook}.
     * {@code key} must exist in the task list book.
     */
    public void removeGradedTest(GradedTest key) {
        gradedTests.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("Graded Test", gradedTests)
                .toString();
    }

    @Override
    public ObservableList<GradedTest> getGradedTestList() {
        return gradedTests.asUnmodifiableObservableList();
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

        GradedTestListBook otherGradedTestList = (GradedTestListBook) other;
        return gradedTests.equals(otherGradedTestList.gradedTests);
    }

    @Override
    public int hashCode() {
        return gradedTests.hashCode();
    }
}
