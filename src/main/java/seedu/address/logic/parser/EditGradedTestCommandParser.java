package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FINALS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MIDTERMS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRACTICAL_EXAM;
import static seedu.address.logic.parser.CliSyntax.PREFIX_READING_ASSESSMENT1;
import static seedu.address.logic.parser.CliSyntax.PREFIX_READING_ASSESSMENT2;

import java.util.Optional;
import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditGradedTestCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.gradedtest.Finals;
import seedu.address.model.gradedtest.MidTerms;
import seedu.address.model.gradedtest.PracticalExam;
import seedu.address.model.gradedtest.ReadingAssessment1;
import seedu.address.model.gradedtest.ReadingAssessment2;

/**
 * Parses input arguments and creates a new and updated EditGradedTestCommand object
 */
public class EditGradedTestCommandParser implements Parser<EditGradedTestCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the EditGradedTestCommand
     * and returns an EditGradedTestCommand object for execution.
     *
     * @throws ParseException if the user input does not conform to the expected format
     */
    public EditGradedTestCommand parse(String args) throws ParseException {
        requireNonNull(args);

        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_READING_ASSESSMENT1,
                PREFIX_READING_ASSESSMENT2, PREFIX_MIDTERMS, PREFIX_FINALS, PREFIX_PRACTICAL_EXAM);

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditGradedTestCommand.MESSAGE_USAGE),
                    pe);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_READING_ASSESSMENT1,
                PREFIX_READING_ASSESSMENT2, PREFIX_MIDTERMS, PREFIX_FINALS, PREFIX_PRACTICAL_EXAM);

        String[] segments = args.split("\\s+");

        // Create variables to store values
        ReadingAssessment1 ra1 = null;
        ReadingAssessment2 ra2 = null;
        MidTerms midTerms = null;
        Finals finals = null;
        PracticalExam practicalExam = null;

        for (String segment : segments) {
            if (segment.startsWith("ra1/")) {
                ra1 = ParserUtil.parseReadingAssessment1(argMultimap.getValue(PREFIX_READING_ASSESSMENT1).get());
            } else if (segment.startsWith("ra2/")) {
                ra2 = ParserUtil.parseReadingAssessment2(argMultimap.getValue(PREFIX_READING_ASSESSMENT2).get());
            } else if (segment.startsWith("mt/")) {
                midTerms = ParserUtil.parseMidTerms(argMultimap.getValue(PREFIX_MIDTERMS).get());
            } else if (segment.startsWith("f/")) {
                finals = ParserUtil.parseFinals(argMultimap.getValue(PREFIX_FINALS).get());
            } else if (segment.startsWith("pe/")) {
                practicalExam = ParserUtil.parsePracticalExam(argMultimap.getValue(PREFIX_PRACTICAL_EXAM).get());
            } else {
                // If the segment doesn't match any prefix, try to parse it as an index
                try {
                    index = ParserUtil.parseIndex(segment);
                } catch (ParseException ignored) {
                    // Ignore and continue parsing other segments
                }
            }
        }

        // Check if the necessary prefixes are present
        if (index == null || (ra1 == null && ra2 == null && midTerms == null
                && finals == null && practicalExam == null)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    EditGradedTestCommand.MESSAGE_USAGE));
        }

        return new EditGradedTestCommand(index, Optional.ofNullable(ra1), Optional.ofNullable(ra2),
                Optional.ofNullable(midTerms), Optional.ofNullable(finals), Optional.ofNullable(practicalExam));
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}