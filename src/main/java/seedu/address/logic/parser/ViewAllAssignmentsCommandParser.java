package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ViewAllAssignmentsCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new ViewAllAssignmentsCommand object
 */
public class ViewAllAssignmentsCommandParser implements Parser<ViewAllAssignmentsCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewAllAssignmentsCommand
     * and returns a ViewAllAssignmentsCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewAllAssignmentsCommand parse(String args) throws ParseException {
        if (!args.equals("")) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    ViewAllAssignmentsCommand.MESSAGE_USAGE));
        } else {
            return new ViewAllAssignmentsCommand();
        }
    }
}
