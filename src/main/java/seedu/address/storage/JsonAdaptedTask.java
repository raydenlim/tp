package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskDescription;
import seedu.address.model.task.TaskName;
import seedu.address.model.task.TaskPriority;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Jackson-friendly version of {@link Task}.
 */
class JsonAdaptedTask {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Task's %s field is missing!";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    private final String name;
    private final String description;
    private final boolean isDone;
    private final String priority;
    private final String date;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given task details.
     */
    @JsonCreator
    public JsonAdaptedTask(@JsonProperty("name") String name, @JsonProperty("description") String description,
                           @JsonProperty("isDone") boolean isDone, @JsonProperty("priority") String priority,
                           @JsonProperty("date") String date) {
        this.name = name;
        this.description = description;
        this.isDone = isDone;
        this.priority = priority;
        this.date = date;
    }

    /**
     * Converts a given {@code Task} into this class for Jackson use.
     */
    public JsonAdaptedTask(Task source) {
        name = source.getName().taskName;
        description = source.getDescription().description;
        isDone = source.getIsDone();
        priority = source.getPriority().name();
        date = source.getDate() != null
                ? source.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                : "";
    }

    /**
     * Converts this Jackson-friendly adapted task object into the model's {@code Task} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted task.
     */
    public Task toModelType() throws IllegalValueException {
        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TaskName.class.getSimpleName()));
        }
        if (!TaskName.isValidName(name)) {
            throw new IllegalValueException(TaskName.MESSAGE_CONSTRAINTS);
        }
        final TaskName modelName = new TaskName(name);

        if (description == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TaskDescription.class.getSimpleName()));
        }
        if (!TaskDescription.isValidDescription(description)) {
            throw new IllegalValueException(TaskDescription.MESSAGE_CONSTRAINTS);
        }
        final TaskDescription modelDescription = new TaskDescription(description);

        final TaskPriority modelPriority;
        if (priority == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    TaskPriority.class.getSimpleName()));
        }
        try {
            modelPriority = TaskPriority.valueOf(priority);
        } catch (Exception e) {
            throw new IllegalValueException(TaskPriority.MESSAGE_CONSTRAINTS);
        }

        final LocalDate localDate;
        if (date.equals("")) {
            localDate = null;
        } else {
            localDate = LocalDate.parse(date, FORMATTER);
        }



        return new Task(modelName, modelDescription, isDone, modelPriority, localDate);
    }

}
