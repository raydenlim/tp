package seedu.address.model.consultation;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Iterator;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.consultation.exceptions.ConsultationNotFoundException;
import seedu.address.model.consultation.exceptions.DuplicateConsultationException;

/**
 * A list of Consultations.
 */
public class ConsultationList implements Iterable<Consultation> {
    private ObservableList<Consultation> internalList = FXCollections.observableArrayList();
    private final ObservableList<Consultation> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    public void setConsultationList(List<Consultation> consultationList) {
        requireAllNonNull(consultationList);
        internalList.setAll(consultationList);
    }

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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true; // Same object, equal
        }

        if (!(other instanceof ConsultationList)) {
            return false; // Not the same class, not equal
        }

        ConsultationList otherList = (ConsultationList) other;

        // Check if the lists have the same sessions in the same order
        return internalList.equals(otherList.internalList);
    }
}
