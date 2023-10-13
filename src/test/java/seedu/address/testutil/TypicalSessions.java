package seedu.address.testutil;

import seedu.address.model.session.Session;

/**
 * A utility class containing a set of typical sessions for testing purposes.
 */
public class TypicalSessions {
    /**
     * A typical session with session number 1, attended by Alice.
     */
    public static final Session SESSION1A = new Session(1, TypicalPersons.ALICE);

    /**
     * A typical session with session number 1, attended by Alice.
     */
    public static final Session SESSION1B = new Session(1, TypicalPersons.ALICE);

    /**
     * A typical session with session number 2, attended by Bob.
     */
    public static final Session SESSION2 = new Session(2, TypicalPersons.BOB);

    /**
     * A typical session with session number 3, attended by Alice and Bob.
     */
    public static final Session SESSION3A = new Session(3, TypicalPersons.ALICE).addStudent(TypicalPersons.BOB);

    /**
     * A typical session with session number 3, attended by Alice.
     */
    public static final Session SESSION3B = new Session(3, TypicalPersons.ALICE);
}


