package seedu.address.model.person.assignment.initialise;

import seedu.address.model.person.assignment.AssignmentName;
import seedu.address.model.person.assignment.Grade;

public class AssignmentInitialise {
    public static AssignmentNameInitialise nameInitialise;
    private static AssignmentMaxGradeInitialise maxGradeInitialise;
    public static boolean isInitialised = false;

    public static void Init() {
            AssignmentInitialise.nameInitialise = new AssignmentNameInitialise();
            AssignmentInitialise.nameInitialise.initMissions();
            AssignmentInitialise.nameInitialise.initQuests();

            AssignmentInitialise.maxGradeInitialise = new AssignmentMaxGradeInitialise();
            AssignmentInitialise.maxGradeInitialise.missionGrades();
            AssignmentInitialise.maxGradeInitialise.questGrades();

            isInitialised = true;
    }

    public static AssignmentName getAssignmentName(int index) {
        return AssignmentInitialise.nameInitialise.getName(index);
    }

    public static Grade getAssignmentMaxGrade(int index) {
        return AssignmentInitialise.maxGradeInitialise.getGrade(index);
    }

    public static int size() {
        return AssignmentInitialise.nameInitialise.size();
    }
}
