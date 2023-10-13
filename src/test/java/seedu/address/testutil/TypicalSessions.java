package seedu.address.testutil;

import seedu.address.model.session.Session;


public class TypicalSessions {
    public static final Session SESSION1A = new Session(1, TypicalPersons.ALICE);
    public static final Session SESSION1B = new Session(1, TypicalPersons.ALICE);

    public static final Session SESSION2 = new Session(2, TypicalPersons.BOB);
    public static final Session SESSION3A = new Session(3, TypicalPersons.ALICE).addStudent(TypicalPersons.BOB);

    public static final Session SESSION3B = new Session(3, TypicalPersons.ALICE);
}


