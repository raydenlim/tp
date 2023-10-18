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

    public String name() {
        return this.assignmentName.toString();
    }
    public String gradeToString() {
        return this.grade.toString();
    }

    public String maxGrade() {
        return this.grade.getMax();
    }

    public Assignment copyAssignment() {
        return new Assignment(this.assignmentName, this.grade.copyGrade());
    }
}
