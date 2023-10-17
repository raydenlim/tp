package seedu.address.storage;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionNumber;
import seedu.address.model.session.SessionStudents;

/**
 * Jackson-friendly version of {@link Session}.
 */
public class JsonAdaptedSession {
    private final String sessionNumber;
    private final List<JsonAdaptedPerson> students = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedSession} with the given {@code sessionInfo}.
     */
    @JsonCreator
    public JsonAdaptedSession(@JsonProperty("sessionNumber") String sessionNumber,
            @JsonProperty("students") List<JsonAdaptedPerson> students) {
        this.sessionNumber = sessionNumber;
        this.students.addAll(students);
    }

    /**
     * Converts a given {@code Session} into this class for Jackson use.
     */
    public JsonAdaptedSession(Session source) {
        this.sessionNumber = source.getSessionNumber().toString();
        if (source.getStudents() != null) {
            students.addAll(source.getStudents().stream()
                    .map(JsonAdaptedPerson::new)
                    .collect(Collectors.toList()));
        }
    }

    /**
     * Converts this Jackson-friendly adapted session object into the model's {@code Session} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted session.
     */
    public Session toModelType() throws IllegalValueException {
        if (sessionNumber == null) {
            throw new IllegalValueException(SessionNumber.MESSAGE_CONSTRAINTS);
        }

        final SessionNumber modelSessionNumber = new SessionNumber(sessionNumber);

        final List<Person> studentsList = new ArrayList<>();
        SessionStudents sessionStudents = new SessionStudents();
        if (students != null) {
            for (JsonAdaptedPerson student : students) {
                studentsList.add(student.toModelType());
            }
            final Set<Person> studentSet = new HashSet<>(studentsList);
            sessionStudents = new SessionStudents(studentSet);
        }

        return new Session(modelSessionNumber, sessionStudents);
    }

}
