package seedu.address.model.session;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.session.exceptions.DuplicateSessionException;
import seedu.address.model.session.exceptions.SessionNotFoundException;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

/**
 * A list of sessions that can be used to manage and manipulate session data.
 */
public class SessionList implements Iterable<Session> {
    private ObservableList<Session> internalList = FXCollections.observableArrayList();
    private final ObservableList<Session> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Checks if the list contains a specific session.
     *
     * @param toCheck The session to check for existence.
     * @return True if the session exists in the list, false otherwise.
     */
    public boolean contains(Session toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameSession);
    }

    /**
     * Adds a session to the list.
     *
     * @param toAdd The session to add.
     */
    public void addSession(Session toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    /**
     * Sets the information of a session in the list.
     *
     * @param target The session to be modified.
     * @param editedSession The modified session information.
     * @throws SessionNotFoundException If the target session is not found in the list.
     * @throws DuplicateSessionException If the edited session information duplicates an existing session.
     */
    public void setSession(Session target, Session editedSession) {
        requireAllNonNull(target, editedSession);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new SessionNotFoundException();
        }

        if (!target.isSameSession(editedSession) && contains(editedSession)) {
            throw new DuplicateSessionException();
        }

        internalList.set(index, editedSession);
    }

    /**
     * Removes a session from the list.
     *
     * @param toRemove The session to remove.
     * @throws SessionNotFoundException If the session to remove is not found in the list.
     */
    public void remove(Session toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new SessionNotFoundException();
        }
    }

    /**
     * Returns an unmodifiable view of the list of sessions.
     *
     * @return An unmodifiable list of sessions.
     */
    public ObservableList<Session> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    /**
     * Provides an iterator to iterate through the list of sessions.
     *
     * @return An iterator for the list of sessions.
     */
    @Override
    public Iterator<Session> iterator() {
        return internalList.iterator();
    }

    /**
     * Returns a string representation of the list of sessions.
     *
     * @return A string representation of the sessions in the list.
     */
    @Override
    public String toString() {
        return internalList.toString();
    }
}
