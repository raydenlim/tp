package seedu.address.testutil;

import seedu.address.model.consultation.Consultation;

/**
 * A utility class containing a list of {@code Consultation} objects to be used in tests.
 */
public class TypicalConsultations {
    public static final Consultation CONSULTATION1 = new ConsultationBuilder()
            .withDate("11/11/2002")
            .withTime("00:00")
            .withStudents(TypicalPersons.AMY, TypicalPersons.GEORGE)
            .build();

    public static final Consultation CONSULTATION2 = new ConsultationBuilder()
            .withDate("12/12/2022")
            .withTime("19:00")
            .withStudents(TypicalPersons.ALICE)
            .build();

    public static final Consultation CONSULTATION3 = new ConsultationBuilder()
            .withDate("3/7/2023")
            .withTime("12:00")
            .withStudents(TypicalPersons.CARL, TypicalPersons.BOB, TypicalPersons.BENSON)
            .build();

    public static final Consultation CONSULTATION4 = new ConsultationBuilder()
            .withDate("3/3/2023")
            .withTime("13:30")
            .withStudents(TypicalPersons.ELLE)
            .build();

    private TypicalConsultations() {} // prevents instantiation
}
