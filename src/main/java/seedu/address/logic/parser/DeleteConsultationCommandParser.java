package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteConsultationCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeleteConsultationCommand object
 */
public class DeleteConsultationCommandParser implements Parser<DeleteConsultationCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteConsultationCommand
     * and returns a DeleteConsultationCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    @Override
    public DeleteConsultationCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeleteConsultationCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteConsultationCommand.MESSAGE_USAGE), pe);
        }
    }
}
