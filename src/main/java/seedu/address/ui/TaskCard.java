package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import seedu.address.model.task.Task;

/**
 * A UI component that displays information of a {@code Task}.
 */
public class TaskCard extends UiPart<Region> {

    private static final String FXML = "TaskListCard.fxml";

    public final Task task;

    @FXML
    private HBox cardPane;
    @FXML
    private Text name;
    @FXML
    private Label id;
    @FXML
    private Text description;
    @FXML
    private Text priority;
    @FXML
    private Text date;

    /**
     * Creates a {@code TaskCard} with the given {@code Task} and index to display.
     */
    public TaskCard(Task task, int displayedIndex) {
        super(FXML);
        this.task = task;
        id.setText(displayedIndex + ". ");
        name.setText(task.getName().taskName);
        description.setText(task.getDescription().description);
        priority.setText(task.getPriority().name());
        date.setText(task.getDate() != null ? task.getDate().toString() : "");

        switch(task.getPriority()) {
        case LOW:
            priority.setStyle("-fx-fill: green");
            break;
        case MEDIUM:
            priority.setStyle("-fx-fill: yellow");
            break;
        case HIGH:
            priority.setStyle("-fx-fill: red");
            break;
        default:
            priority.setStyle("-fx-fill: white");
        }

        name.setStrikethrough(task.getIsDone());
        description.setStrikethrough(task.getIsDone());
        priority.setStrikethrough(task.getIsDone());
        date.setStrikethrough(task.getIsDone());

    }
}
