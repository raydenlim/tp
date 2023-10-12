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

    public void addActualGrade(String actualGrade) throws CommandException {
        if (this.isGraded) {
            throw new CommandException(Messages.MESSAGE_ASSIGNMENT_GRADED);
        } else {
            this.actualGrade = actualGrade;
            this.isGraded = true;
        }
    }

    public void editGrade(String newGrade) throws CommandException {
        if (this.isGraded) {
            this.actualGrade = newGrade;
        } else {
            throw new CommandException(Messages.MESSAGE_ASSIGNMENT_UNGRADED);
        }
    }

    public void deleteGrade() throws CommandException {
        if (this.isGraded) {
            this.isGraded = false;
            this.actualGrade = "";
        } else {
            throw new CommandException(Messages.MESSAGE_ASSIGNMENT_UNGRADED);
        }
    }

    @Override
    public String toString() {
        if (this.isGraded) {
            return this.actualGrade + "/" + this.maxGrade;
        } else {
            return "UNGRADED";
        }
    }
}
