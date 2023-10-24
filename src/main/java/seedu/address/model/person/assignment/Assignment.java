package seedu.address.model.person.assignment;

/**
 * Represents an assignment.
 */
public class Assignment {

    // Identity fields
    private final AssignmentName assignmentName;
    private final Grade grade;

    /**
     * Creates an assignment.
     */
    public Assignment(AssignmentName name, Grade grade) {
        this.assignmentName = name;
        this.grade = grade;
    }

    public AssignmentName getName() {
        return this.assignmentName;
    }

    public Grade getGrade() {
        return this.grade;
    }

    public String maxGrade() {
        return this.grade.getMax();
    }

    public Assignment copyAssignment() {
        return new Assignment(this.assignmentName, this.grade.copyGrade());
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Assignment)) {
            return false;
        }

        Assignment otherName = (Assignment) other;
        return assignmentName.equals(otherName.assignmentName) && grade.equals(otherName.grade);
    }
}
