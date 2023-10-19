package seedu.address.model.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ConsultationListBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyConsultationList;
import seedu.address.model.ReadOnlySessionList;
import seedu.address.model.ReadOnlyTaskList;
import seedu.address.model.SessionListBook;
import seedu.address.model.TaskListBook;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionNumber;
import seedu.address.model.session.SessionStudents;
import seedu.address.model.tag.Tag;
import seedu.address.model.task.Task;
import seedu.address.model.task.TaskDescription;
import seedu.address.model.task.TaskName;
import seedu.address.model.task.TaskPriority;


/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static final Person PERSON_ALEX = new Person(new Name("Alex Yeoh"), new Phone("87438807"),
            new Email("alexyeoh@example.com"), new Address("Blk 30 Geylang Street 29, #06-40"),
            getTagSet("friends"));
    public static final Person PERSON_BERNICE = new Person(new Name("Bernice Yu"), new Phone("99272758"),
            new Email("berniceyu@example.com"), new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
            getTagSet("colleagues", "friends"));
    public static final Person PERSON_CHARLOTTE = new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"),
            new Email("charlotte@example.com"), new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
            getTagSet("neighbours"));
    public static final Person PERSON_DAVID = new Person(new Name("David Li"), new Phone("91031282"),
            new Email("lidavid@example.com"), new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
            getTagSet("family"));
    public static final Person PERSON_IRFAN = new Person(new Name("Irfan Ibrahim"), new Phone("92492021"),
            new Email("irfan@example.com"), new Address("Blk 47 Tampines Street 20, #17-35"),
            getTagSet("classmates"));
    public static final Person PERSON_ROY = new Person(new Name("Roy Balakrishnan"), new Phone("92624417"),
            new Email("royb@example.com"), new Address("Blk 45 Aljunied Street 85, #11-31"),
            getTagSet("colleagues"));

    public static Person[] getSamplePersons() {
        return new Person[] { PERSON_ALEX, PERSON_BERNICE, PERSON_CHARLOTTE, PERSON_DAVID, PERSON_IRFAN, PERSON_ROY };
    }

    public static Task[] getSampleTasks() {
        return new Task[] {
            new Task(new TaskName("Do 2103T"), new TaskDescription("Homework assignment"), TaskPriority.HIGH),
            new Task(new TaskName("Do cs2101"), new TaskDescription("Practice script"), TaskPriority.HIGH),
            new Task(new TaskName("Do cs2100"), new TaskDescription("Remember mips"), TaskPriority.HIGH)
        };
    }

    public static Consultation[] getSampleConsultations() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        return new Consultation[] { new Consultation(
                LocalDate.parse("11/11/2023", dateFormatter),
                LocalTime.parse("11:11", timeFormatter),
                SampleDataUtil.getStudentSet(PERSON_ALEX, PERSON_BERNICE)
        ), new Consultation(
                LocalDate.parse("01/11/2023", dateFormatter),
                LocalTime.parse("10:00", timeFormatter),
                SampleDataUtil.getStudentSet(PERSON_ALEX)
        ), new Consultation(
                LocalDate.parse("11/12/2023", dateFormatter),
                LocalTime.parse("15:00", timeFormatter),
                SampleDataUtil.getStudentSet(PERSON_DAVID, PERSON_IRFAN, PERSON_ROY)
        ),
        };
    }

    public static Session[] getSampleSessions() {
        return new Session[] {
            new Session(new SessionNumber("1"), new SessionStudents(getSamplePersons())),
            new Session(new SessionNumber("2"), new SessionStudents(getSamplePersons()))
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    public static ReadOnlyTaskList getSampleTaskList() {
        TaskListBook sampleTl = new TaskListBook();
        for (Task sampleTask : getSampleTasks()) {
            sampleTl.addTask(sampleTask);
        }
        return sampleTl;
    }

    public static ReadOnlyConsultationList getSampleConsultationList() {
        ConsultationListBook sampleClb = new ConsultationListBook();
        for (Consultation sampleConsultation : getSampleConsultations()) {
            sampleClb.addConsultation(sampleConsultation);
        }
        return sampleClb;
    }

    public static ReadOnlySessionList getSampleSessionList() {
        SessionListBook sampleSl = new SessionListBook();
        for (Session sampleSession : getSampleSessions()) {
            sampleSl.addSession(sampleSession);
        }
        return sampleSl;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a student set containing the list of person given.
     */
    public static Set<Person> getStudentSet(Person ... students) {
        return Arrays.stream(students)
                .collect(Collectors.toSet());
    }

    /**
     * Returns a names set containing the list of string names given.
     */
    public static Set<Name> getNamesSet(String ... names) {
        return Arrays.stream(names)
                .map(Name::new)
                .collect(Collectors.toSet());
    }

}
