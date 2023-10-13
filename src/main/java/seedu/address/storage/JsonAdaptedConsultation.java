package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.tag.Tag;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Jackson-friendly version of {@link Consultation}.
 */
public class JsonAdaptedConsultation {
    private final String date;
    private final String time;
    private final List<JsonAdaptedPerson> students = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedConsultation} with the given consultation details.
     */
    @JsonCreator
    public JsonAdaptedConsultation(@JsonProperty("date") String date, @JsonProperty("time") String time,
                                   @JsonProperty("students") List<JsonAdaptedPerson> students) {
        this.date = date;
        this.time = time;
        this.students.addAll(students);
    }

    /**
     * Converts a given {@code Consultation} into this class for Jackson use.
     */
    public JsonAdaptedConsultation(Consultation source) {
        date = source.getDate().toString();
        time = source.getTime().toString();
        students.addAll(source.getStudents().stream()
                .map(JsonAdaptedPerson::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted session object into the model's {@code Session} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted session.
     */
    public Consultation toModelType() throws IllegalValueException {
        // TODO check for invalid values of date and time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate formattedDate = LocalDate.parse(date, dateFormatter);

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime formattedTime = LocalTime.parse(time, timeFormatter);

        final List<Person> studentsList = new ArrayList<>();
        for (JsonAdaptedPerson student : students) {
            studentsList.add(student.toModelType());
        }
        final Set<Person> studentSet = new HashSet<>(studentsList);

        return new Consultation(formattedDate, formattedTime, studentSet);
    }
}