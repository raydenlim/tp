package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import seedu.address.model.SessionListBook;
import seedu.address.model.session.Session;
import seedu.address.model.session.SessionList;

/**
 * A utility class containing a set of typical sessions for testing purposes.
 */
public class TypicalSessions {
    /**
     * A typical empty session with session number 9, with no students.
     */
    public static final Session EMPTY_SESSION = new Session("9", new HashSet<>());

    /**
     * A typical session with session number 1, attended by Alice.
     */
    public static final Session SESSION1A = new Session("1", TypicalPersons.ALICE);

    /**
     * A typical session with session number 1, attended by Alice.
     */
    public static final Session SESSION1B = new Session("1", TypicalPersons.ALICE);

    /**
     * A typical session with session number 2, attended by Bob.
     */
    public static final Session SESSION2 = new Session("2", TypicalPersons.BOB);

    /**
     * A typical session with session number 3, attended by Alice and Bob.
     */
    public static final Session SESSION3A = new Session("3",
            new HashSet<>(Arrays.asList(TypicalPersons.ALICE, TypicalPersons.BOB)));


    /**
     * A typical session with session number 3, attended by Alice.
     */
    public static final Session SESSION3B = new Session("3", TypicalPersons.ALICE);

    /**
     * A typical session with session number 2, attended by Alice.
     */
    public static final Session SESSION_TYPICAL1 = new Session("2", TypicalPersons.ALICE);

    /**
     * A typical session with session number 3, attended by Benson.
     */
    public static final Session SESSION_TYPICAL2 = new Session("3", TypicalPersons.BENSON);

    public static SessionListBook getTypicalSessionList() {
        SessionListBook sb = new SessionListBook();
        for (Session session : getTypicalSessions()) {
            sb.addSession(session);
        }
        return sb;
    }

    public static SessionList getTypicalSessions() {
        SessionList typicalSessions = new SessionList();
        List<Session> sessionsList = new ArrayList<>(Arrays.asList(SESSION_TYPICAL1, SESSION_TYPICAL2));
        typicalSessions.setSessionList(sessionsList);
        return typicalSessions;
    }
}


