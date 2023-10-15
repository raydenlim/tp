package seedu.address.logic.commands.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.session.Session;
import seedu.address.testutil.PersonBuilder;


public class CreateSessionCommandTest {

    @Test
    public void execute_createSessionWithSingleStudent_success() throws CommandException {
        Model model = new ModelManager();
        Person student = new PersonBuilder().withName("Alice").build();
        model.addPerson(student);

        CreateSessionCommand command = new CreateSessionCommand("1", new Name("Alice"));
        command.execute(model);

        Session createdSession = model.findSessionBySessionNumber("1");
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

        CreateSessionCommand command = new CreateSessionCommand("1", studentNames);
        command.execute(model);

        Session createdSession = model.findSessionBySessionNumber("1");
        assertEquals(2, createdSession.getStudents().size());
        assertTrue(createdSession.getStudents().contains(alice));
        assertTrue(createdSession.getStudents().contains(bob));
    }


    @Test
    public void equals_sameCommands_returnsTrue() {
        CreateSessionCommand command1 = new CreateSessionCommand("S1", new Name("Alice"));
        CreateSessionCommand command2 = new CreateSessionCommand("S1", new Name("Alice"));

        assertEquals(command1, command2);
    }

    @Test
    public void equals_differentCommands_returnsFalse() {
        CreateSessionCommand command1 = new CreateSessionCommand("S1", new Name("Alice"));
        CreateSessionCommand command2 = new CreateSessionCommand("S2", new Name("Bob"));

        assertNotEquals(command1, command2);
    }
}
