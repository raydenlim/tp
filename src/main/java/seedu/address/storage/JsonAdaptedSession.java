package seedu.address.storage;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Person;
import seedu.address.model.session.Session;

/**
 * Jackson-friendly version of {@link Session}.
 */
public class JsonAdaptedSession {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Session's fields are missing!";
    private final String sessionInfo;


    /**
     * Constructs a {@code JsonAdaptedSession} with the given {@code sessionInfo}.
     */
    @JsonCreator
    public JsonAdaptedSession(@JsonProperty("sessionInfo") String sessionInfo) {
        this.sessionInfo = sessionInfo;
    }

    /**
     * Converts a given {@code Session} into this class for Jackson use.
     */
    public JsonAdaptedSession(Session source) {
        sessionInfo = source.toSaveState();
    }

    @JsonValue
    public String getSessionInfo() {
        return sessionInfo;
    }

    /**
     * Converts this Jackson-friendly adapted session object into the model's {@code Session} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted session.
     */
    public Session toModelType() throws IllegalValueException {
        if (sessionInfo == null) {
            throw new IllegalValueException(MISSING_FIELD_MESSAGE_FORMAT);
        }
        String modelSessionNumber = sessionInfo.split(" - ")[0];
        //TODO: convert storage students to studentList
        Set<Person> studentList = new HashSet<>();
        String[] students = sessionInfo.split(" - ")[1].split(", ");
        for (String student : students) {



        }
        return new Session(modelSessionNumber, studentList);
    }

}
