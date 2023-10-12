package seedu.address.model.person.assignment;

import java.util.ArrayList;

public class AssignmentMaxGrade {
    private ArrayList<String> maxGrades = new ArrayList<>();

    public void missionGrades() {
        this.maxGrades.add("600");
        this.maxGrades.add("1000");
        this.maxGrades.add("800");
        this.maxGrades.add("700");
        this.maxGrades.add("600");
        this.maxGrades.add("800");
        this.maxGrades.add("950");
        this.maxGrades.add("1200");
        this.maxGrades.add("1300");
        this.maxGrades.add("720");
        this.maxGrades.add("950");
        this.maxGrades.add("800");
        this.maxGrades.add("1000");
        this.maxGrades.add("1200");
        this.maxGrades.add("1200");
    }

    public void questGrades() {
        this.maxGrades.add("400");
        this.maxGrades.add("600");
        this.maxGrades.add("500");
        this.maxGrades.add("500");
        this.maxGrades.add("600");
        this.maxGrades.add("800");
        this.maxGrades.add("670");
        this.maxGrades.add("750");
    }

    public String getGrade(int index) {
        return this.maxGrades.get(index);
    }
}
