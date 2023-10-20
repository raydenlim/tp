package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ASSIGNMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GRADE;

import java.util.stream.Stream;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AddGradeCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.assignment.AssignmentName;

/**
 * Parses input arguments and creates a new AddGradeCommand object
 */
public class AddGradeCommandParser implements Parser<AddGradeCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddGradeCommand
     * and returns an AddGradeCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddGradeCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_ASSIGNMENT, PREFIX_GRADE);

        if (!arePrefixesPresent(argMultimap, PREFIX_ASSIGNMENT, PREFIX_GRADE)) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddGradeCommand.MESSAGE_USAGE));
        }

        Index index;

        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (ParseException pe) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddGradeCommand.MESSAGE_USAGE), pe);
        }

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_ASSIGNMENT, PREFIX_GRADE);
        AssignmentName assignmentName = ParserUtil.parseAssignmentName(argMultimap.getValue(PREFIX_ASSIGNMENT).get());
        String actualGrade = argMultimap.getValue(PREFIX_GRADE).get();
        return new AddGradeCommand(index, assignmentName, actualGrade);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
