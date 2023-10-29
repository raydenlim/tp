package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.ParserUtil.MESSAGE_INVALID_INDEX;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.person.TelegramHandle;
import seedu.address.model.session.SessionRemark;
import seedu.address.model.tag.Tag;

public class ParserUtilTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_TELEGRAM_HANDLE1 = " ";
    private static final String INVALID_TELEGRAM_HANDLE2 = "@#$";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_TAG = "#friend";

    private static final String VALID_NAME = "Rachel Walker";
    private static final String VALID_PHONE = "123456";
    private static final String VALID_TELEGRAM_HANDLE = "l_dinghan";
    private static final String VALID_EMAIL = "rachel@u.nus.edu.sg";
    private static final String VALID_TAG_1 = "friend";
    private static final String VALID_TAG_2 = "neighbour";

    private static final String WHITESPACE = " \t\r\n";
    private static final String INVALID_PRIORITY = "jason";
    private static final String INVALID_ATTENDANCE_PRESENCE = "presen";
    private static final String VALID_SESSION_REMARK = "lgtm";
    private static final String INVALID_SESSION_REMARK = "pl@y3$";

    private static final String INVALID_DESCRIPTION = "ssssssssssssssssssssssssssssssssssssssssssssssss"
            + "sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss"; // more than 100 chars
    private static final String INVALID_PROGRESS = "jason";

    @Test
    public void parseIndex_invalidInput_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseIndex("10 a"));
    }

    @Test
    public void parseIndex_outOfRangeInput_throwsParseException() {
        assertThrows(ParseException.class, MESSAGE_INVALID_INDEX, ()
            -> ParserUtil.parseIndex(Long.toString(Integer.MAX_VALUE + 1)));
    }

    @Test
    public void parseIndex_validInput_success() throws Exception {
        // No whitespaces
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("1"));

        // Leading and trailing whitespaces
        assertEquals(INDEX_FIRST_PERSON, ParserUtil.parseIndex("  1  "));
    }

    @Test
    public void parseName_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseName((String) null));
    }

    @Test
    public void parseName_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseName(INVALID_NAME));
    }

    @Test
    public void parseName_validValueWithoutWhitespace_returnsName() throws Exception {
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(VALID_NAME));
    }

    @Test
    public void parseName_validValueWithWhitespace_returnsTrimmedName() throws Exception {
        String nameWithWhitespace = WHITESPACE + VALID_NAME + WHITESPACE;
        Name expectedName = new Name(VALID_NAME);
        assertEquals(expectedName, ParserUtil.parseName(nameWithWhitespace));
    }

    @Test
    public void parsePhone_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parsePhone((String) null));
    }

    @Test
    public void parsePhone_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parsePhone(INVALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithoutWhitespace_returnsPhone() throws Exception {
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, ParserUtil.parsePhone(VALID_PHONE));
    }

    @Test
    public void parsePhone_validValueWithWhitespace_returnsTrimmedPhone() throws Exception {
        String phoneWithWhitespace = WHITESPACE + VALID_PHONE + WHITESPACE;
        Phone expectedPhone = new Phone(VALID_PHONE);
        assertEquals(expectedPhone, ParserUtil.parsePhone(phoneWithWhitespace));
    }

    @Test
    public void parseAddress_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTelegramHandle(null));
    }

    @Test
    public void parseAddress_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTelegramHandle(INVALID_TELEGRAM_HANDLE1));
        assertThrows(ParseException.class, () -> ParserUtil.parseTelegramHandle(INVALID_TELEGRAM_HANDLE2));
    }

    @Test
    public void parseAddress_validValueWithoutWhitespace_returnsAddress() throws Exception {
        TelegramHandle expectedTelegramHandle = new TelegramHandle(VALID_TELEGRAM_HANDLE);
        assertEquals(expectedTelegramHandle, ParserUtil.parseTelegramHandle(VALID_TELEGRAM_HANDLE));
    }

    @Test
    public void parseAddress_validValueWithWhitespace_returnsTrimmedAddress() throws Exception {
        String telegramHandleWithTrailingWhitespace = WHITESPACE + VALID_TELEGRAM_HANDLE + WHITESPACE;
        TelegramHandle expectedTelegramHandle = new TelegramHandle(VALID_TELEGRAM_HANDLE);
        assertEquals(expectedTelegramHandle, ParserUtil.parseTelegramHandle(telegramHandleWithTrailingWhitespace));
    }

    @Test
    public void parseEmail_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseEmail((String) null));
    }

    @Test
    public void parseEmail_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseEmail(INVALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithoutWhitespace_returnsEmail() throws Exception {
        Email expectedEmail = new Email(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseEmail(VALID_EMAIL));
    }

    @Test
    public void parseEmail_validValueWithWhitespace_returnsTrimmedEmail() throws Exception {
        String emailWithWhitespace = WHITESPACE + VALID_EMAIL + WHITESPACE;
        Email expectedEmail = new Email(VALID_EMAIL);
        assertEquals(expectedEmail, ParserUtil.parseEmail(emailWithWhitespace));
    }

    @Test
    public void parseTag_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTag(null));
    }

    @Test
    public void parseTag_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTag(INVALID_TAG));
    }

    @Test
    public void parseTag_validValueWithoutWhitespace_returnsTag() throws Exception {
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(VALID_TAG_1));
    }

    @Test
    public void parseTag_validValueWithWhitespace_returnsTrimmedTag() throws Exception {
        String tagWithWhitespace = WHITESPACE + VALID_TAG_1 + WHITESPACE;
        Tag expectedTag = new Tag(VALID_TAG_1);
        assertEquals(expectedTag, ParserUtil.parseTag(tagWithWhitespace));
    }

    @Test
    public void parseTags_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> ParserUtil.parseTags(null));
    }

    @Test
    public void parseTags_collectionWithInvalidTags_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, INVALID_TAG)));
    }

    @Test
    public void parseTags_emptyCollection_returnsEmptySet() throws Exception {
        assertTrue(ParserUtil.parseTags(Collections.emptyList()).isEmpty());
    }

    @Test
    public void parseTags_collectionWithValidTags_returnsTagSet() throws Exception {
        Set<Tag> actualTagSet = ParserUtil.parseTags(Arrays.asList(VALID_TAG_1, VALID_TAG_2));
        Set<Tag> expectedTagSet = new HashSet<Tag>(Arrays.asList(new Tag(VALID_TAG_1), new Tag(VALID_TAG_2)));

        assertEquals(expectedTagSet, actualTagSet);
    }

    @Test
    public void parseNames_validNames_returnsSetOfNames() throws ParseException {
        Collection<String> names = Collections.singletonList("Alice");
        Set<Name> expectedNameSet = Collections.singleton(new Name("Alice"));

        Set<Name> parsedNameSet = ParserUtil.parseNames(names);
        assertEquals(expectedNameSet, parsedNameSet);
    }

    @Test
    public void parseNames_multipleValidNames_returnsSetOfNames() throws ParseException {
        Collection<String> names = List.of("Alice", "Bob", "Charlie");
        Set<Name> expectedNameSet = Set.of(new Name("Alice"), new Name("Bob"), new Name("Charlie"));

        Set<Name> parsedNameSet = ParserUtil.parseNames(names);
        assertEquals(expectedNameSet, parsedNameSet);
    }

    @Test
    public void parseNames_mixedValidAndInvalidNames_throwsParseException() {
        Collection<String> names = List.of("Alice", "abc_help", "Charlie");

        // When there's an invalid name, a ParseException should be thrown
        assertThrows(ParseException.class, () -> ParserUtil.parseNames(names));
    }

    @Test
    public void parsePriority_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTaskPriority(INVALID_PRIORITY));
    }

    @Test
    public void parseAttendancePresence_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseAttendancePresence(INVALID_ATTENDANCE_PRESENCE));
    }

    @Test
    public void parseSessionRemark_validRemark_returnsSessionRemark() throws ParseException {
        SessionRemark expectedSessionRemark = new SessionRemark(VALID_SESSION_REMARK);
        assertEquals(expectedSessionRemark, ParserUtil.parseSessionRemark(VALID_SESSION_REMARK));
    }

    @Test
    public void parseSessionRemark_invalidRemark_throwsParseException() throws ParseException {
        assertThrows(ParseException.class, () -> ParserUtil.parseSessionRemark(INVALID_SESSION_REMARK));
    }

    @Test
    public void parseDescription_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTaskDescription(INVALID_DESCRIPTION));
    }

    @Test
    public void parseProgress_invalidValue_throwsParseException() {
        assertThrows(ParseException.class, () -> ParserUtil.parseTaskProgress(INVALID_PROGRESS));
    }
}
