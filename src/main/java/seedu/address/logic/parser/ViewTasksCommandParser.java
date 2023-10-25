package seedu.address.logic.parser;

import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_DESCRIPTION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_PRIORITY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TASK_PROGRESS;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_TASKS;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import seedu.address.logic.commands.ViewTasksCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.task.DateContainsKeywordsPredicate;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskDescriptionContainsKeywordsPredicate;
import seedu.address.model.task.TaskNameContainsKeywordsPredicate;
import seedu.address.model.task.TaskPriorityContainsKeywordsPredicate;
import seedu.address.model.task.TaskProgressContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindCommand object
 */
public class ViewTasksCommandParser implements Parser<ViewTasksCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewTasksCommand
     * and returns a ViewTasksCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ViewTasksCommand parse(String args) throws ParseException {

        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TASK_NAME,
                        PREFIX_TASK_DESCRIPTION, PREFIX_TASK_PRIORITY, PREFIX_TASK_PROGRESS, PREFIX_DATE);

        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_TASK_NAME, PREFIX_TASK_DESCRIPTION,
                PREFIX_TASK_PRIORITY, PREFIX_TASK_PROGRESS, PREFIX_DATE);

        Predicate<Task> predicate = PREDICATE_SHOW_ALL_TASKS;

        if (argMultimap.getValue(PREFIX_TASK_NAME).isPresent()) {
            String[] taskNameKeywords = argMultimap.getValue(PREFIX_TASK_NAME).get().split("\\s+");
            predicate = new TaskNameContainsKeywordsPredicate(Arrays.asList(taskNameKeywords));
        }

        if (argMultimap.getValue(PREFIX_TASK_DESCRIPTION).isPresent()) {
            String[] taskDescKeywords = argMultimap.getValue(PREFIX_TASK_DESCRIPTION).get().split("\\s+");
            predicate = new TaskDescriptionContainsKeywordsPredicate(Arrays.asList(taskDescKeywords));
        }

        if (argMultimap.getValue(PREFIX_TASK_PRIORITY).isPresent()) {
            String[] taskPriorityKeywords = argMultimap.getValue(PREFIX_TASK_PRIORITY).get().split("\\s+");
            predicate = new TaskPriorityContainsKeywordsPredicate(Arrays.asList(taskPriorityKeywords));
        }

        if (argMultimap.getValue(PREFIX_TASK_PROGRESS).isPresent()) {
            String[] taskProgressKeywords = argMultimap.getValue(PREFIX_TASK_PROGRESS).get().split("\\s+");
            predicate = new TaskProgressContainsKeywordsPredicate(Arrays.asList(taskProgressKeywords));
        }

        if (argMultimap.getValue(PREFIX_DATE).isPresent()) {
            String[] dateKeywords = argMultimap.getValue(PREFIX_DATE).get().split("\\s+");
            predicate = new DateContainsKeywordsPredicate(Arrays.asList(dateKeywords));
        }

        return new ViewTasksCommand(predicate);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
