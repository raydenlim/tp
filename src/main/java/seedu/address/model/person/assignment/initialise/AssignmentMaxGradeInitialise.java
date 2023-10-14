package seedu.address.model.person.assignment.initialise;

import seedu.address.model.person.assignment.Grade;

import java.util.ArrayList;

public class AssignmentMaxGradeInitialise {
    private static ArrayList<Grade> maxGrades = new ArrayList<>();

    public void missionGrades() {
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("600"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("1000"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("800"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("700"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("600"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("800"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("950"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("1200"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("1300"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("720"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("950"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("800"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("1000"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("1200"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("1200"));
    }

    public void questGrades() {
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("400"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("600"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("500"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("500"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("600"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("800"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("670"));
        AssignmentMaxGradeInitialise.maxGrades.add(new Grade("750"));
    }

    public Grade getGrade(int index) {
        return this.maxGrades.get(index);
    }
}
