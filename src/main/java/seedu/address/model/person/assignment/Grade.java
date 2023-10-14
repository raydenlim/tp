package seedu.address.model.person.assignment;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;

public class Grade {
    private String actualGrade;
    private String maxGrade;
    boolean isGraded;

    public Grade(String maxGrade) {
        this.maxGrade = maxGrade;
        this.isGraded = false;
    }

    public Grade(String actualGrade, String maxGrade) {
        this.actualGrade = actualGrade;
        this.maxGrade = maxGrade;
        this.isGraded = true;
    }

    public String getMax() {
        return this.maxGrade;
    }

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
