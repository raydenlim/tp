package seedu.address.logic;

import static javafx.collections.FXCollections.observableArrayList;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Path;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.AssignmentCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.AddressBookParser;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.person.Person;
import seedu.address.model.person.assignment.Assignment;
import seedu.address.model.person.assignment.AssignmentMap;
import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.initialise.AssignmentInitialise;
import seedu.address.model.person.assignment.initialise.AssignmentNameInitialise;
import seedu.address.model.session.Session;
import seedu.address.model.task.Task;
import seedu.address.storage.Storage;

/**
 * The main LogicManager of the app.
 */
public class LogicManager implements Logic {
    public static final String FILE_OPS_ERROR_FORMAT = "Could not save data due to the following error: %s";

    public static final String FILE_OPS_PERMISSION_ERROR_FORMAT =
            "Could not save data to file %s due to insufficient permissions to write to the file or the folder.";

    private final Logger logger = LogsCenter.getLogger(LogicManager.class);

    private final Model model;
    private final Storage storage;
    private final AddressBookParser addressBookParser;
    private Index indexToDisplay;

    /**
     * Constructs a {@code LogicManager} with the given {@code Model} and {@code Storage}.
     */
    public LogicManager(Model model, Storage storage) {
        this.model = model;
        this.storage = storage;
        addressBookParser = new AddressBookParser();
    }

    @Override
    public CommandResult execute(String commandText) throws CommandException, ParseException {
        logger.info("----------------[USER COMMAND][" + commandText + "]");

        CommandResult commandResult;
        Command command = addressBookParser.parseCommand(commandText);
        commandResult = command.execute(model);

        try {
            storage.saveAddressBook(model.getAddressBook());
            storage.saveTaskList(model.getTaskList());
            storage.saveSessionList(model.getSessionList());
            storage.saveConsultationList(model.getConsultationList());

            if (command instanceof AssignmentCommand) {
                AssignmentCommand assignmentCommand = (AssignmentCommand) command;
                indexToDisplay = assignmentCommand.getIndex();
            }
        } catch (AccessDeniedException e) {
            throw new CommandException(String.format(FILE_OPS_PERMISSION_ERROR_FORMAT, e.getMessage()), e);
        } catch (IOException ioe) {
            throw new CommandException(String.format(FILE_OPS_ERROR_FORMAT, ioe.getMessage()), ioe);
        }

        return commandResult;
    }

    @Override
    public ReadOnlyAddressBook getAddressBook() {
        return model.getAddressBook();
    }

    @Override
    public ObservableList<Person> getFilteredPersonList() {
        return model.getFilteredPersonList();
    }

    @Override
    public ObservableList<Task> getFilteredTaskList() {
        return model.getFilteredTaskList();
    }

    @Override
    public ObservableList<Consultation> getFilteredConsultationList() {
        return model.getFilteredConsultationList();
    }

    @Override
    public ObservableList<Session> getFilteredSessionList() {
        return model.getFilteredSessionList();
    }

    @Override
    public ObservableList<AssignmentName> getAssignmentNameList() {
        AssignmentInitialise.init();
        return AssignmentNameInitialise.getAllNames();
    }

    @Override
    public ObservableList<Assignment> getAssignments() {
        Person person = model.getAddressBook().getPersonList().get(indexToDisplay.getZeroBased());
        AssignmentMap assignmentMap = person.getAllAssignments();
        ObservableList<AssignmentName> assignmentNameList = AssignmentNameInitialise.getAllNames();
        ObservableList<Assignment> assignmentList = observableArrayList();
        AssignmentInitialise.init();
        for (int i = 0; i < assignmentNameList.size(); i++) {
            AssignmentName assignmentName = assignmentNameList.get(i);
            Assignment assignment = assignmentMap.get(assignmentName);
            assignmentList.add(assignment);
        }
        return assignmentList;
    }

    @Override
    public Index getIndex() {
        return this.indexToDisplay;
    }

    @Override
    public Path getAddressBookFilePath() {
        return model.getAddressBookFilePath();
    }

    @Override
    public GuiSettings getGuiSettings() {
        return model.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        model.setGuiSettings(guiSettings);
    }
}
