package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.attendance.AttendancePresence;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionNumber;
import seedu.address.testutil.PersonBuilder;


public class TakeAttendanceCommandTest {

    @Test
    public void execute_takeAttendanceWithSingleStudent_success() throws CommandException {
        Model model = new ModelManager();
        Person student = new PersonBuilder().withName("Alice").build();
        Person newStudent = new PersonBuilder().withName("Bob").build();
        model.addPerson(student);
        model.addPerson(newStudent);
        Session currentSession = new Session(new SessionNumber("2"), student);
        model.addSession(currentSession);

        assertEquals(1, currentSession.getStudents().size());
        assertTrue(currentSession.getStudents().contains(student));

        TakeAttendanceCommand command =
                new TakeAttendanceCommand(new SessionNumber("2"), new Name("Bob"), new AttendancePresence("present"));
        command.execute(model);
        assertEquals(2, currentSession.getStudents().size());
        assertTrue(currentSession.getStudents().contains(newStudent));
    }


    @Test
    public void execute_takeAttendanceWithMultipleStudents_success() throws CommandException {
        Model model = new ModelManager();
        Person alice = new PersonBuilder().withName("Alice").build();
        Person bob = new PersonBuilder().withName("Bob").build();
        Session currentSession = new Session(new SessionNumber("3"));
        model.addPerson(alice);
        model.addPerson(bob);
        model.addSession(currentSession);

        Set<Name> studentNames = new HashSet<>();
        studentNames.add(new Name("Alice"));
        studentNames.add(new Name("Bob"));

        assertEquals(0, currentSession.getStudents().size());
        TakeAttendanceCommand command = new TakeAttendanceCommand(
                currentSession.getSessionNumber(), studentNames, new AttendancePresence("present"));
        command.execute(model);

        assertEquals(2, currentSession.getStudents().size());
        assertTrue(currentSession.getStudents().contains(alice));
        assertTrue(currentSession.getStudents().contains(bob));
    }


    @Test
    public void equals_sameCommands_returnsTrue() {
        TakeAttendanceCommand command1 =
                new TakeAttendanceCommand(new SessionNumber("1"), new Name("Alice"), new AttendancePresence("absent"));
        TakeAttendanceCommand command2 =
                new TakeAttendanceCommand(new SessionNumber("1"), new Name("Alice"), new AttendancePresence("absent"));

        assertTrue(command1.equals(command2));
    }

    @Test
    public void equals_differentCommands_returnsFalse() {
        TakeAttendanceCommand command1 = new TakeAttendanceCommand(
                new SessionNumber("1"), new Name("Alice"), new AttendancePresence("present"));
        TakeAttendanceCommand command2 =
                new TakeAttendanceCommand(new SessionNumber("1"), new Name("Bob"), new AttendancePresence("present"));
        TakeAttendanceCommand command3 =
                new TakeAttendanceCommand(new SessionNumber("1"), new Name("Alice"), new AttendancePresence("absent"));
        assertFalse(command1.equals(command2));
        assertFalse(command1.equals(command3));
    }

    @Test
    public void toStringMethod() throws CommandException {
        Model model = new ModelManager();
        String name = "Bob";
        Person bob = new PersonBuilder().withName(name).build();
        SessionNumber sessionNumber = new SessionNumber("1");
        model.addPerson(bob);
        Session session = new Session(sessionNumber, bob);
        model.addSession(session);

        TakeAttendanceCommand command =
                new TakeAttendanceCommand(sessionNumber, new Name(name), new AttendancePresence("present"));
        command.execute(model);


        String expected = TakeAttendanceCommand.class.getCanonicalName()
                + "{takeAttendance=" + sessionNumber + ", students=[" + bob + "]}";
        assertEquals(expected, command.toString());
    }
}
