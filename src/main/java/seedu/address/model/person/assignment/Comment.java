package seedu.address.model.person.assignment;

/**
 * Represents the comment on an assignment.
 */
public class Comment {
    private String commentBody;

    public Comment(String commentBody) {
        this.commentBody = commentBody;
    }

    @Override
    public String toString() {
        return this.commentBody;
    }
}
