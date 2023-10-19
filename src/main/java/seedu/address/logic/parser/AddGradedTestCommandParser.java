package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FINALS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MIDTERMS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRACTICAL_EXAM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_READING_ASSESSMENT;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddGradedTestCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.gradedtest.Finals;
import seedu.address.model.gradedtest.GradedTest;
import seedu.address.model.gradedtest.MidTerms;
import seedu.address.model.gradedtest.PracticalExam;
import seedu.address.model.gradedtest.ReadingAssessment;

/**
 * Parses input arguments and creates a new AddGradedTestCommand object
 */
public class AddGradedTestCommandParser implements Parser<AddGradedTestCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AddGradedTestCommand
     * and returns an AddGradedTestCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddGradedTestCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_READING_ASSESSMENT, PREFIX_READING_ASSESSMENT,
                        PREFIX_MIDTERMS, PREFIX_FINALS, PREFIX_PRACTICAL_EXAM);

        if (!arePrefixesPresent(argMultimap, PREFIX_READING_ASSESSMENT, PREFIX_READING_ASSESSMENT,
                PREFIX_MIDTERMS, PREFIX_FINALS, PREFIX_PRACTICAL_EXAM)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddGradedTestCommand.MESSAGE_USAGE));
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_READING_ASSESSMENT, PREFIX_READING_ASSESSMENT,
                PREFIX_MIDTERMS, PREFIX_FINALS, PREFIX_PRACTICAL_EXAM);
        ReadingAssessment ra1 = ParserUtil.parseReadingAssessment(argMultimap
                .getValue(PREFIX_READING_ASSESSMENT).get());
        ReadingAssessment ra2 = ParserUtil.parseReadingAssessment(argMultimap
                .getValue(PREFIX_READING_ASSESSMENT).get());
        MidTerms midterms = ParserUtil.parseMidTerms(argMultimap.getValue(PREFIX_MIDTERMS).get());
        Finals finals = ParserUtil.parseFinals(argMultimap.getValue(PREFIX_FINALS).get());
        PracticalExam pe = ParserUtil.parsePracticalExam(argMultimap.getValue(PREFIX_PRACTICAL_EXAM).get());

        GradedTest gradedTestComb = new GradedTest(ra1, ra2, midterms, finals, pe);

        return new AddGradedTestCommand(gradedTestComb);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
