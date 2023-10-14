package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.commands.AddTaskCommand.MESSAGE_DUPLICATE_TASK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GRADED_TEST;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;

import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
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
public class AddGradedTestCommand {
    public static final String COMMAND_WORD = "addGT";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Creates a session with the student(s). "
            + "Parameters: "
            + PREFIX_GRADED_TEST + "GRADED_TEST_NUMBER "
            + "[" + PREFIX_NAME + "NAME]...\n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_NAME + "John Doe "
            + PREFIX_NAME + "Foo Bar";
    public static final String MESSAGE_SUCCESS = "New consultation added: %1$s";
    private String gradedTestName;
    private Name name;
    private Set<Name> names;
    private GradedTest gradedTestToAdd;

    /**
     * Creates an AddGradedTestCommand to add a Graded Test associated with a single student.
     *
     * @param gradedTestName The name of the Graded Test to add.
     * @param name The student's name to associate with the Graded Test.
     */
    public AddGradedTestCommand(String gradedTestName, Name name) {
        requireAllNonNull(gradedTestName, name);

        this.gradedTestName = gradedTestName;
        this.name = name;
    }

    /**
     * Creates an AddGradedTestCommand to add a Graded Test associated with multiple students.
     *
     * @param gradedTestName The name of the Graded Test to add.
     * @param names The set of student names to associate with the Graded Test.
     */
    public AddGradedTestCommand(String gradedTestName, Set<Name> names) {
        requireAllNonNull(gradedTestName, names);

        this.gradedTestName = gradedTestName;
        this.names = names;
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
        if (model.hasGradedTest(gradedTestToAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }
        model.addGradedTest(gradedTestToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(gradedTestToAdd)));
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
        return this.gradedTestToAdd.equals(otherTest.gradedTestToAdd);
    }

    /**
     * Generates a string representation of this AddGradedTestCommand.
     *
     * @return A string representation of the command.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("toAdd", gradedTestToAdd)
                .toString();
    }
}
