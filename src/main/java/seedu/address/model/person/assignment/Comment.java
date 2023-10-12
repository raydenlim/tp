package seedu.address.model.person.assignment;

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
