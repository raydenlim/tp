package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.Arrays;
import java.util.stream.Stream;

import seedu.address.logic.commands.ViewAttendanceCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;
import seedu.address.model.session.SessionStudentsContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new ViewAttendanceCommand object.
 */
public class ViewAttendanceCommandParser implements Parser<ViewAttendanceCommand> {
    /**
     * Parses the given `args` and creates a new `ViewAttendanceCommand` object.
     *
     * @param args The input arguments provided by the user.
     * @return A `ViewAttendanceCommand` object.
     * @throws ParseException If the user input does not conform to the expected format.
     */
    public ViewAttendanceCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME);

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_NAME);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(
                    MESSAGE_INVALID_COMMAND_FORMAT, ViewAttendanceCommand.MESSAGE_USAGE));
        }

        Name name = ParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        String[] nameKeywords = name.toString().split("\\s+");
        return new ViewAttendanceCommand(new SessionStudentsContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

    /**
     * Checks if the specified prefixes are present in the given ArgumentMultimap.
     *
     * @param argumentMultimap The ArgumentMultimap to check for prefix presence.
     * @param prefixes The prefixes to be checked.
     * @return `true` if all specified prefixes are present, `false` otherwise.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
