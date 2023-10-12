package seedu.address.model.person.assignment;

import seedu.address.logic.commands.exceptions.CommandException;

public class Assignment {

    // Identity fields
    private String name;
    private Grade grade;
    private Comment comment;

    public Assignment(String name, String maxGrade) {
        this.name = name;
        this.grade = new Grade(maxGrade);
    }

    public void addGrade(String actualGrade) throws CommandException {
        this.grade.addActualGrade(actualGrade);
    }

    public void addComment(String commentBody) {
        this.comment = new Comment(commentBody);
    }
}
