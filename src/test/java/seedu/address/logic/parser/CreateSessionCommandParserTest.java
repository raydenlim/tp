package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.session.CreateSessionCommand;
import seedu.address.model.person.Name;

public class CreateSessionCommandParserTest {
    private CreateSessionCommandParser parser = new CreateSessionCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE
                + SESSION_NUMBER_SESSION1 + SESSION_STUDENTS_STUDENTS1, new CreateSessionCommand("1", new Name("Bob")));
    }


}
