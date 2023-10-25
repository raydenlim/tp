package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.CreateSessionCommand;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionNumber;
import seedu.address.testutil.PersonBuilder;


public class CreateSessionCommandTest {

    @Test
    public void execute_createSessionWithSingleStudent_success() throws CommandException {
        Model model = new ModelManager();
        Person student = new PersonBuilder().withName("Alice").build();
        SessionNumber sessionNumber = new SessionNumber("1");
        model.addPerson(student);

        CreateSessionCommand command = new CreateSessionCommand(sessionNumber, new Name("Alice"));
        command.execute(model);

        Session createdSession = model.findSessionBySessionNumber(sessionNumber);
        assertEquals(1, createdSession.getStudents().size());
        assertTrue(createdSession.getStudents().contains(student));
    }

    @Test
    public void execute_createSessionWithMultipleStudents_success() throws CommandException {
        Model model = new ModelManager();
        Person alice = new PersonBuilder().withName("Alice").build();
        Person bob = new PersonBuilder().withName("Bob").build();
        model.addPerson(alice);
        model.addPerson(bob);

        Set<Name> studentNames = new HashSet<>();
        studentNames.add(new Name("Alice"));
        studentNames.add(new Name("Bob"));

        CreateSessionCommand command = new CreateSessionCommand(new SessionNumber("1"), studentNames);
        command.execute(model);

        Session createdSession = model.findSessionBySessionNumber(new SessionNumber("1"));
        assertEquals(2, createdSession.getStudents().size());
        assertTrue(createdSession.getStudents().contains(alice));
        assertTrue(createdSession.getStudents().contains(bob));
    }


    @Test
    public void equals_sameCommands_returnsTrue() {
        CreateSessionCommand command1 = new CreateSessionCommand(new SessionNumber("1"), new Name("Alice"));
        CreateSessionCommand command2 = new CreateSessionCommand(new SessionNumber("1"), new Name("Alice"));

        assertTrue(command1.equals(command2));
    }

    @Test
    public void equals_differentCommands_returnsFalse() {
        CreateSessionCommand command1 = new CreateSessionCommand(new SessionNumber("1"), new Name("Alice"));
        CreateSessionCommand command2 = new CreateSessionCommand(new SessionNumber("1"), new Name("Bob"));

        assertFalse(command1.equals(command2));
    }

    @Test
    public void toStringMethod() throws CommandException {
        Model model = new ModelManager();
        String name = "Bob";
        Person bob = new PersonBuilder().withName(name).build();
        SessionNumber sessionNumber = new SessionNumber("1");
        model.addPerson(bob);
        CreateSessionCommand command = new CreateSessionCommand(sessionNumber, new Name(name));

        // Before execution, session has not been created and is null
        String expectedBeforeExecute = CreateSessionCommand.class.getCanonicalName()
                + "{toCreate=null}";
        assertEquals(expectedBeforeExecute, command.toString());

        // Execute creates the session to be added
        command.execute(model);
        String expectedAfterExecute = CreateSessionCommand.class.getCanonicalName()
                + "{toCreate=" + sessionNumber + " - " + name + "}";
        assertEquals(expectedAfterExecute, command.toString());

    }
}
