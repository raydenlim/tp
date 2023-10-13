package seedu.address.model.session;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.session.exceptions.DuplicateSessionException;
import seedu.address.model.session.exceptions.SessionNotFoundException;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
public class SessionList implements Iterable<Session> {
    private ObservableList<Session> internalList = FXCollections.observableArrayList();
    private final ObservableList<Session> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    public boolean contains(Session toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameSession);
    }

    public void addSession(Session toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    public void setSession(Session target, Session editedSession) {
        requireAllNonNull(target, editedSession);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new SessionNotFoundException();
        }


        if(!target.isSameSession(editedSession) && contains(editedSession)) {
            throw new DuplicateSessionException();
        }

        internalList.set(index, editedSession);
    }


    public void remove(Session toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new SessionNotFoundException();
        }
    }

    public ObservableList<Session> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Session> iterator() {
        return internalList.iterator();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}