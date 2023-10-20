package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.util.StringUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.attendance.AttendancePresence;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.session.SessionNumber;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.TaskDescription;
import seedu.address.model.task.TaskName;
import seedu.address.model.task.TaskPriority;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";
    public static final String MESSAGE_INVALID_DATE = "Date is needs to be in the format dd/MM/yyyy.";
    public static final String MESSAGE_INVALID_TIME = "Time is needs to be in the format HH:mm.";

    /**
     * Parses {@code oneBasedIndex} into an {@code Index} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     * @throws ParseException if the specified index is invalid (not non-zero unsigned integer).
     */
    public static Index parseIndex(String oneBasedIndex) throws ParseException {
        String trimmedIndex = oneBasedIndex.trim();
        if (!StringUtil.isNonZeroUnsignedInteger(trimmedIndex)) {
            throw new ParseException(MESSAGE_INVALID_INDEX);
        }
        return Index.fromOneBased(Integer.parseInt(trimmedIndex));
    }

    /**
     * Parses a {@code String name} into a {@code Name}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static Name parseName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!Name.isValidName(trimmedName)) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }
        return new Name(trimmedName);
    }

    /**
     * Parses {@code Collection<String> names} into a {@code Set<Name>}.
     */
    public static Set<Name> parseNames(Collection<String> names) throws ParseException {
        requireNonNull(names);
        final Set<Name> nameSet = new HashSet<>();
        for (String studentName : names) {
            if (!Name.isValidName(studentName)) {
                throw new ParseException(Name.MESSAGE_CONSTRAINTS);
            }
            nameSet.add(parseName(studentName));
        }
        return nameSet;
    }

    /**
     * Parses a {@code String phone} into a {@code Phone}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code phone} is invalid.
     */
    public static Phone parsePhone(String phone) throws ParseException {
        requireNonNull(phone);
        String trimmedPhone = phone.trim();
        if (!Phone.isValidPhone(trimmedPhone)) {
            throw new ParseException(Phone.MESSAGE_CONSTRAINTS);
        }
        return new Phone(trimmedPhone);
    }

    /**
     * Parses a {@code String address} into an {@code Address}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code address} is invalid.
     */
    public static Address parseAddress(String address) throws ParseException {
        requireNonNull(address);
        String trimmedAddress = address.trim();
        if (!Address.isValidAddress(trimmedAddress)) {
            throw new ParseException(Address.MESSAGE_CONSTRAINTS);
        }
        return new Address(trimmedAddress);
    }

    /**
     * Parses a {@code String email} into an {@code Email}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code email} is invalid.
     */
    public static Email parseEmail(String email) throws ParseException {
        requireNonNull(email);
        String trimmedEmail = email.trim();
        if (!Email.isValidEmail(trimmedEmail)) {
            throw new ParseException(Email.MESSAGE_CONSTRAINTS);
        }
        return new Email(trimmedEmail);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }

    /**
     * Parses {@code String date} into an {@code LocalDate} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     */
    public static LocalDate parseDate(String date) throws ParseException {
        requireNonNull(date);
        String trimmedDate = date.trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(trimmedDate, formatter);
        } catch (DateTimeParseException e) {
            throw new ParseException(MESSAGE_INVALID_DATE);
        }
    }

    /**
     * Parses {@code String time} into an {@code LocalTime} and returns it. Leading and trailing whitespaces will be
     * trimmed.
     */
    public static LocalTime parseTime(String time) throws ParseException {
        requireNonNull(time);
        String trimmedTime = time.trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            return LocalTime.parse(trimmedTime, formatter);
        } catch (DateTimeParseException e) {
            throw new ParseException(MESSAGE_INVALID_TIME);
        }
    }

    /**
     * Parses the input session number as a string and returns it as a SessionNumber.
     *
     * @param sessionNumber The session number to be parsed.
     * @return The parsed session number as a SessionNumber.
     * @throws ParseException If the session number is not a valid number.
     */
    public static SessionNumber parseSessionNumber(String sessionNumber) throws ParseException {
        requireNonNull(sessionNumber);
        String trimmedSessionNumber = sessionNumber.trim();
        if (!SessionNumber.isValidSessionNumber(trimmedSessionNumber)) {
            throw new ParseException(SessionNumber.MESSAGE_CONSTRAINTS);
        }
        return new SessionNumber(trimmedSessionNumber);
    }

    /**
     * Parses the input attendance presence as a string and returns it as an AttendancePresence.
     *
     * @param attendancePresence The attendance presence to be parsed.
     * @return The parsed attendance presence as an AttendancePresence.
     * @throws ParseException If the attendance presence is invalid.
     */
    public static AttendancePresence parseAttendancePresence(String attendancePresence) throws ParseException {
        requireNonNull(attendancePresence);
        String trimmedAttendancePresence = attendancePresence.trim().toLowerCase();
        if (!AttendancePresence.isValidInput(trimmedAttendancePresence)) {
            throw new ParseException(AttendancePresence.MESSAGE_CONSTRAINTS);
        }
        return new AttendancePresence(attendancePresence);
    }

    /**
     * Parses a {@code String taskName} into a {@code TaskName}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static TaskName parseTaskName(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!TaskName.isValidName(trimmedName)) {
            throw new ParseException(TaskName.MESSAGE_CONSTRAINTS);
        }
        return new TaskName(trimmedName);
    }

    /**
     * Parses a {@code String taskDescription} into a {@code TaskDescription}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static TaskDescription parseTaskDescription(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim();
        if (!TaskDescription.isValidDescription(trimmedName)) {
            throw new ParseException(TaskDescription.MESSAGE_CONSTRAINTS);
        }
        return new TaskDescription(trimmedName);
    }

    /**
     * Parses a {@code String priority} into a {@code TaskPriority}.
     * Leading and trailing whitespaces will be trimmed.
     * String will be uppercase.
     *
     * @throws ParseException if the given {@code name} is invalid.
     */
    public static TaskPriority parseTaskPriority(String name) throws ParseException {
        requireNonNull(name);
        String trimmedName = name.trim().toUpperCase();
        for (TaskPriority priority : TaskPriority.values()) {
            if (trimmedName.equals(priority.name())) {
                return TaskPriority.valueOf(trimmedName);
            }
        }
        throw new ParseException(TaskPriority.MESSAGE_CONSTRAINTS);
    }


}
