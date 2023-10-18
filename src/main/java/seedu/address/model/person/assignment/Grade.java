package seedu.address.model.person.assignment;

/**
 * Represents the Grade given to an assignment.
 * Consists of the maximum grade as well as the actual grade.
 */
public class Grade {
    private String actualGrade;
    private final String maxGrade;
    private boolean isGraded;

    /**
     * Creates a Grade for an assignment with only the maximum grade.
     *
     * @param maxGrade The maximum grade for the assignment.
     */
    public Grade(String maxGrade) {
        this.maxGrade = maxGrade;
        this.isGraded = false;
    }

    /**
     * Creates a Grade for an assignment with both the actual grade and the maximum grade.
     *
     * @param actualGrade The grade the person scores for the assignment.
     * @param maxGrade The maximum grade for the assignment.
     */
    public Grade(String actualGrade, String maxGrade) {
        this.actualGrade = actualGrade;
        this.maxGrade = maxGrade;
        this.isGraded = true;
    }

    public String getMax() {
        return this.maxGrade;
    }

    /**
     * Creates a new copy of the Grade of an assignment.
     *
     * @return New copy of the Grade of an assignment.
     */
    public Grade copyGrade() {
        if (this.isGraded) {
            return new Grade(this.actualGrade, this.maxGrade);
        } else {
            return new Grade(this.maxGrade);
        }
    }

    @Override
    public String toString() {
        if (this.isGraded) {
            return this.actualGrade + "/" + this.maxGrade;
        } else {
            return "UNGRADED/" + this.maxGrade;
        }
    }
}
