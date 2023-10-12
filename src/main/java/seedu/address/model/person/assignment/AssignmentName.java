package seedu.address.model.person.assignment;

import java.util.ArrayList;

public class AssignmentName {
    private ArrayList<String> assignments = new ArrayList<>();

    public void initMissions() {
        this.assignments.add("Rune Trials");
        this.assignments.add("Rune Reading");
        this.assignments.add("Beyond the Second Dimension");
        this.assignments.add("Curve Introduction");
        this.assignments.add("Curve Manipulation");
        this.assignments.add("Beyond the First Dimension");
        this.assignments.add("Premorseal Communications");
        this.assignments.add("POTS and Pans");
        this.assignments.add("Musical Diversions");
        this.assignments.add("Search and Rescue");
        this.assignments.add("Sorting Things Out");
        this.assignments.add("Robotic Trials");
        this.assignments.add("Moving about on Planet Y");
        this.assignments.add("Finding ELDRIC");
        this.assignments.add("Know Your Environment");
    }

    public void initQuests() {
        this.assignments.add("Runic Carpets");
        this.assignments.add("Colorful Carpets");
        this.assignments.add("Functional Expressionism");
        this.assignments.add("Cardioid Arrest");
        this.assignments.add("Curvaceous Wizardry");
        this.assignments.add("The Magical Tone Matrix");
        this.assignments.add("Echoes of the Past");
        this.assignments.add("Grading a Sort");
    }

    public String getName(int index) {
        return this.assignments.get(index);
    }

    public int size() {
        return this.assignments.size();
    }
}
