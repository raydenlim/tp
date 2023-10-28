package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_CONSULTATIONS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.consultation.Consultation;
import seedu.address.model.consultation.exceptions.PersonNotFoundInConsultException;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.exceptions.PersonNotFoundException;

/**
 * Removes a person identified using his/her name from the specified consultation by index.
 */
public class RemoveFromConsultCommand extends Command {
    public static final String COMMAND_WORD = "removefromconsult";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Removes a person identified using his/her name from the specified consultation "
            + "by index in the displayed consultation list.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + PREFIX_NAME + "NAME\n"
            + "Example: " + COMMAND_WORD + " 1" + PREFIX_NAME + "John Doe";

    public static final String MESSAGE_SUCCESS = "Student(s) removed from consultation at index %1$s: %1$s";
    public static final String MESSAGE_PERSON_NOT_FOUND = "No student(s) in address book matching given name(s)";
    public static final String MESSAGE_NOT_FOUND_IN_CONSULT = "No student(s) in consultation matching given name(s)";
    public static final String MESSAGE_NOT_EDITED = "At least one student is to be removed";
    private final Index index;
    private final RemoveFromConsultationDescriptor removeFromConsultationDescriptor;

    /**
     * @param index of the consultation in the filtered consultation list to remove students from
     * @param descriptor students to remove from the consultation
     */
    public RemoveFromConsultCommand(Index index, RemoveFromConsultationDescriptor descriptor) {
        requireAllNonNull(index, descriptor);

        this.index = index;
        this.removeFromConsultationDescriptor = descriptor;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Consultation> lastShownConsultationList = model.getFilteredConsultationList();

        if (index.getZeroBased() >= lastShownConsultationList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_CONSULTATION_DISPLAYED_INDEX);
        }

        Consultation targetConsultation = lastShownConsultationList.get(index.getZeroBased());
        Consultation updatedConsultation;

        // Handles input name not found in address book.
        try {
            updatedConsultation = createUpdatedConsultation(model, targetConsultation,
                    removeFromConsultationDescriptor);
        } catch (PersonNotFoundException e) {
            throw new CommandException(MESSAGE_PERSON_NOT_FOUND);
        } catch (PersonNotFoundInConsultException e) {
            throw new CommandException(MESSAGE_NOT_FOUND_IN_CONSULT);
        }

        model.setConsultation(targetConsultation, updatedConsultation);
        model.updateFilteredConsultationList(PREDICATE_SHOW_ALL_CONSULTATIONS);
        return new CommandResult(String.format(MESSAGE_SUCCESS, Messages.format(updatedConsultation)));
    }

    /**
     * Creates and returns a {@code Consultation} with the details of {@code targetConsultation}
     * edited with {@code removeFromConsultationDescriptor}.
     */
    public static Consultation createUpdatedConsultation(Model model, Consultation targetConsultation,
                                                         RemoveFromConsultationDescriptor descriptor) {
        assert targetConsultation != null;

        LocalDate date = targetConsultation.getDate();
        LocalTime time = targetConsultation.getTime();
        Set<Person> students = new HashSet<>(targetConsultation.getStudents());
        Set<Person> studentsToRemove = descriptor.names.stream().map(model::getMatchingStudentName)
                .collect(Collectors.toSet());

        for (Person student : studentsToRemove) {
            if (!students.remove(student)) {
                throw new PersonNotFoundInConsultException();
            }
        }
        return new Consultation(date, time, students);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RemoveFromConsultCommand)) {
            return false;
        }

        RemoveFromConsultCommand otherCommand = (RemoveFromConsultCommand) other;
        return index.equals(otherCommand.index)
                && removeFromConsultationDescriptor.equals(otherCommand.removeFromConsultationDescriptor);
    }

    /**
     * Stores the details to edit the consultation with (updated students). Each non-empty field value will replace the
     * corresponding field value of the consultation.
     */
    public static class RemoveFromConsultationDescriptor {
        private Set<Name> names;
        public RemoveFromConsultationDescriptor() {

        }

        public RemoveFromConsultationDescriptor(RemoveFromConsultationDescriptor toCopy) {
            setNames(toCopy.names);
        }

        /**
         * Returns true if students list is now empty.
         */
        public boolean isEmptyStudents() {
            return names.isEmpty();
        }

        /**
         * Sets {@code names} to this object's {@code names}.
         * A defensive copy of {@code names} is used internally.
         */
        public void setNames(Set<Name> names) {
            this.names = (names != null) ? new HashSet<>(names) : null;
        }

        /**
         * Returns an unmodifiable names set, which throws {@code UnsupportedOperationException}
         * if modification is attempted.
         * Returns {@code Optional#empty()} if {@code names} is null.
         */
        public Optional<Set<Name>> getNames() {
            return (names != null) ? Optional.of(Collections.unmodifiableSet(names)) : Optional.empty();
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }

            // instanceof handles nulls
            if (!(other instanceof RemoveFromConsultationDescriptor)) {
                return false;
            }

            RemoveFromConsultationDescriptor otherDescriptor = (RemoveFromConsultationDescriptor) other;
            return Objects.equals(names, otherDescriptor.names);
        }
    }
}
