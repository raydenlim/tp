package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionNumber;

public class SessionCard extends UiPart<Region> {
    private static final String FXML = "SessionListCard.fxml";

    public final Session session;

    @javafx.fxml.FXML
    private HBox cardPane;
    @FXML
    private Label sessionNumberLabel;
    @FXML
    private Label studentListLabel;

    public SessionCard(Session session) {
        super(FXML);
        this.session = session;
        sessionNumberLabel.setText(session.getSessionNumber() + ". ");
        studentListLabel.setText(session.getStudents().toStudentNames());
    }
}
