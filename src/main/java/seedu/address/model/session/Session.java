package seedu.address.session;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
public class Session {
    private final int sessionNumber;
    private Student[] studentsPresent;

    public Session(int sessionNumber, Student[] studentsPresent) {
        requireAllNonNull(sessionNumber, studentsPresent);
        this.sessionNumber = sessionNumber;
    }




}
