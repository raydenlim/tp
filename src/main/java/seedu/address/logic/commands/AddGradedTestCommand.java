package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GRADED_TEST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_READING_ASSESSMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_MIDTERMS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_FINALS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PRACTICAL_EXAM;

import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.gradedtest.GradedTest;
import seedu.address.model.person.Name;


/**
 * Represents a command for adding a new Graded Test to the application.
 * Users can add a Graded Test with a name and associate it with a student's name or names.
 * It can add a Graded Test for a single student or multiple students.
 */
public class AddGradedTestCommand extends Command{
    public static final String COMMAND_WORD = "addGT";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Adds a new GradedTest with specified scores.\n"
            + "Parameters: "
            + PREFIX_READING_ASSESSMENT + "RA1 "
            + PREFIX_READING_ASSESSMENT + "RA2 "
            + PREFIX_MIDTERMS + "MIDTERMS "
            + PREFIX_FINALS + "FINALS "
            + PREFIX_PRACTICAL_EXAM + "PRACTICALEXAMS "
            + "[" + PREFIX_GRADED_TEST + "GRADEDTEST]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_READING_ASSESSMENT + "0 "
            + PREFIX_READING_ASSESSMENT + "1 "
            + PREFIX_MIDTERMS + "2 "
            + PREFIX_FINALS + "3 "
            + PREFIX_PRACTICAL_EXAM + "4 ";

    public static final String MESSAGE_SUCCESS = "Scores have been added: %1$s";
    public static final String MESSAGE_DUPLICATE_GRADED_TEST = "This graded test already exists in the graded test book";
    private final Name name;
    private final GradedTest gradedTest;

    /**
     * Creates an AddGradedTestCommand to add a Graded Test associated with a single student.
     *
     * @param gradedTest The name of the Graded Test to add.
     * @param name The student's name to associate with the Graded Test.
     */
    public AddGradedTestCommand(GradedTest gradedTest, Name name) {
        requireAllNonNull(gradedTest, name);

        this.gradedTest = gradedTest;
        this.name = name;
    }

    /**
     * Executes the AddGradedTestCommand to add the Graded Test to the model.
     *
     * @param model The model in which to add the Graded Test.
     * @return A CommandResult indicating the result of the execution.
     * @throws CommandException If the Graded Test already exists, indicating a duplicate.
     */
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        if (model.hasGradedTest(gradedTest)) {
            throw new CommandException(MESSAGE_DUPLICATE_GRADED_TEST);
        }
        model.addGradedTest(gradedTest);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(gradedTest)));
    }

    /**
     * Checks if this AddGradedTestCommand is equal to another object.
     * They are considered equal if they add the same Graded Test.
     *
     * @param other The other object to compare.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof AddGradedTestCommand)) {
            return false;
        }

        AddGradedTestCommand otherTest = (AddGradedTestCommand) other;
        return this.gradedTest.equals(otherTest.gradedTest);
    }
}
