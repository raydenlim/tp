package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_TASK;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.IncompleteTaskCommand;

/**
 * JUnit test class for the IncompleteTaskCommandParser.
 */
public class IncompleteTaskCommandParserTest {

    private IncompleteTaskCommandParser parser = new IncompleteTaskCommandParser();

    @Test
    public void parse_validArgs_returnsCompleteTaskCommand() {
        assertParseSuccess(parser, "1", new IncompleteTaskCommand(INDEX_FIRST_TASK));
    }

    @Test
    public void parse_invalidArgs_throwsParseException() {
        assertParseFailure(parser, "a", String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                IncompleteTaskCommand.MESSAGE_USAGE));
    }
}
