package seedu.address.model.consultation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.consultation.exceptions.ConsultationNotFoundException;
import seedu.address.model.consultation.exceptions.DuplicateConsultationException;
import seedu.address.model.person.Person;

import java.util.Iterator;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

public class ConsultationList implements Iterable<Consultation> {
    private ObservableList<Consultation> internalList = FXCollections.observableArrayList();
    private final ObservableList<Consultation> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    public boolean contains(Consultation toCheck) {
        requireNonNull(toCheck);
        return internalList.stream().anyMatch(toCheck::isSameConsultation);
    }

    public void addConsultation(Consultation toAdd) {
        requireNonNull(toAdd);
        internalList.add(toAdd);
    }

    public void setConsult(Consultation target, Consultation editedConsultation) {
        requireAllNonNull(target, editedConsultation);

        int index = internalList.indexOf(target);
        if (index == -1) {
            throw new ConsultationNotFoundException();
        }

        if(!target.isSameConsultation(editedConsultation) && contains(editedConsultation)) {
            throw new DuplicateConsultationException();
        }

        internalList.set(index, editedConsultation);
    }

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
