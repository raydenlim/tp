package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewAttendanceCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.session.SessionStudentsContainsKeywordsPredicate;

public class ViewAttendanceCommandParserTest {

    private ViewAttendanceCommandParser parser = new ViewAttendanceCommandParser();

    @Test
    public void parse_validArguments_success() throws ParseException {
        String validArgs = " n/John Doe";
        List<String> keywords = new ArrayList<>();
        keywords.add("John");
        keywords.add("Doe");
        ViewAttendanceCommand expectedCommand = new ViewAttendanceCommand(
                new SessionStudentsContainsKeywordsPredicate(keywords));

        assertEquals(expectedCommand, parser.parse(validArgs));
    }

    @Test
    public void parse_validArgumentsWithMultipleNames_success() throws ParseException {
        String validArgs = " n/John Doe Jane Smith";
        List<String> keywords = new ArrayList<>();
        keywords.add("John");
        keywords.add("Doe");
        keywords.add("Jane");
        keywords.add("Smith");
        ViewAttendanceCommand expectedCommand = new ViewAttendanceCommand(
                new SessionStudentsContainsKeywordsPredicate(keywords)
        );

        assertEquals(expectedCommand, parser.parse(validArgs));
    }

    @Test
    public void parse_missingNamePrefix_throwsParseException() {
        String invalidArgs = "John Doe";
        assertThrows(ParseException.class, () -> parser.parse(invalidArgs));
    }

    @Test
    public void parse_emptyName_throwsParseException() {
        String invalidArgs = " n/";
        assertThrows(ParseException.class, () -> parser.parse(invalidArgs));
    }
}
