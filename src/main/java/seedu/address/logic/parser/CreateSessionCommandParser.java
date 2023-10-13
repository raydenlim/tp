package seedu.address.logic.parser;

import seedu.address.logic.commands.session.CreateSessionCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;

import java.util.stream.Stream;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SESSION;

public class CreateSessionCommandParser implements Parser<CreateSessionCommand> {

    @Override
    public CreateSessionCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_SESSION, PREFIX_NAME);

        if (!arePrefixesPresent(argMultimap, PREFIX_SESSION, PREFIX_NAME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CreateSessionCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_SESSION);
        int sessionNumber = ParserUtil.parseSessionNumber(argMultimap.getValue(PREFIX_SESSION).get());
        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());

        return new CreateSessionCommand(sessionNumber, name);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
