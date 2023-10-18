package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.MarkTaskCompletedCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new MarkTaskCompletedCommand object
 */
public class MarkTaskCompletedCommandParser implements Parser<MarkTaskCompletedCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the MarkTaskCompletedCommand
     * and returns a MarkTaskCompletedCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public MarkTaskCompletedCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new MarkTaskCompletedCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkTaskCompletedCommand.MESSAGE_USAGE), pe);
        }
    }

}
