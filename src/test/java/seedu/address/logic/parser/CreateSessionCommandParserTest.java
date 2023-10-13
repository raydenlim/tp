package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.AddTaskCommand;
import seedu.address.logic.commands.session.CreateSessionCommand;
import seedu.address.model.person.Name;
import seedu.address.model.session.Session;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskName;
import seedu.address.testutil.TaskBuilder;
import seedu.address.testutil.TypicalPersons;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.*;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_NAME;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalTasks.TASK1;

public class CreateSessionCommandParserTest {
    private CreateSessionCommandParser parser = new CreateSessionCommandParser();

    @Test
    public void parse_allFieldsPresent_success() {

        // whitespace only preamble
        assertParseSuccess(parser, PREAMBLE_WHITESPACE
                + SESSION_NUMBER_SESSION1 + SESSION_STUDENTS_STUDENTS1, new CreateSessionCommand(1, new Name("Bob")));
    }

}
