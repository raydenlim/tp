package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TIME;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;
import java.util.stream.Stream;

import seedu.address.logic.commands.CreateConsultCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;

/**
 * Parses input arguments and creates a new CreateConsultationCommand object
 */
public class CreateConsultCommandParser implements Parser<CreateConsultCommand> {
    @Override
    public CreateConsultCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_DATE, PREFIX_TIME, PREFIX_NAME);

        if (!arePrefixesPresent(argMultimap, PREFIX_DATE, PREFIX_TIME, PREFIX_NAME)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, CreateConsultCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_DATE, PREFIX_TIME);

        LocalDate date = ParserUtil.parseDate(argMultimap.getValue(PREFIX_DATE).get());
        LocalTime time = ParserUtil.parseTime(argMultimap.getValue(PREFIX_TIME).get());
        Set<Name> names = ParserUtil.parseNames(argMultimap.getAllValues(PREFIX_NAME));

        return new CreateConsultCommand(date, time, names);
    }

    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
