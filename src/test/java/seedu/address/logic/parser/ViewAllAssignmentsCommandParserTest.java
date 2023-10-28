package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ViewAllAssignmentsCommand;

public class ViewAllAssignmentsCommandParserTest {

    private static final String MESSAGE_INVALID_FORMAT =
            String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewAllAssignmentsCommand.MESSAGE_USAGE);

    private ViewAllAssignmentsCommandParser parser = new ViewAllAssignmentsCommandParser();

    @Test
    public void parse_haveInput_failure() {
        assertParseFailure(parser, "1", MESSAGE_INVALID_FORMAT);
    }

    @Test
    public void parse_noInput_success() {
        assertParseSuccess(parser, "", new ViewAllAssignmentsCommand());
    }
}
