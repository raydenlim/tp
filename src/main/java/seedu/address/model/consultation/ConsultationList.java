package seedu.address.model.consultation;

import static java.util.Objects.requireNonNull;
//import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.consultation.exceptions.ConsultationNotFoundException;
import seedu.address.model.consultation.exceptions.DuplicateConsultationException;
import seedu.address.model.task.exceptions.DuplicateTaskException;
//import seedu.address.model.consultation.exceptions.DuplicateConsultationException;

/**
 * A list of Consultation.
 */
public class ConsultationList implements Iterable<Consultation> {
    private ObservableList<Consultation> internalList = FXCollections.observableArrayList();
    private final ObservableList<Consultation> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    /**
     * Returns true if the list contains an equivalent consultation as the given argument.
     */
    public boolean contains(Consultation toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameConsultation);
    }

    /**
     * Adds a consultation to the list.
     */
    public void addConsultation(Consultation toAdd) {
        requireNonNull(toAdd);
        if (contains(toAdd)) {
            throw new DuplicateConsultationException();
        }
        internalList.add(toAdd);
    }

    //    /**
    //     * Replaces the consultation {@code target} in the list with {@code editedConsultation}.
    //     * {@code target} must exist in the list.
    //     * The consultation {@code editedConsultation} must not be the same as another existing
    //     * consultation in the list.
    //     */
    //    public void setConsult(Consultation target, Consultation editedConsultation) {
    //        requireAllNonNull(target, editedConsultation);
    //
    //        int index = internalList.indexOf(target);
    //        if (index == -1) {
    //            throw new ConsultationNotFoundException();
    //        }
    //
    //        if (!target.isSameConsultation(editedConsultation) && contains(editedConsultation)) {
    //            throw new DuplicateConsultationException();
    //        }
    //
    //        internalList.set(index, editedConsultation);
    //    }

    /**
     * Removes the equivalent consultation from the list.
     * The consultation must exist in the list.
     */
    public void remove(Consultation toRemove) {
        requireNonNull(toRemove);
        if (!internalList.remove(toRemove)) {
            throw new ConsultationNotFoundException();
        }
    }

    public ObservableList<Consultation> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Consultation> iterator() {
        return internalList.iterator();
    }

    @Override
    public String toString() {
        return internalList.toString();
    }
}
