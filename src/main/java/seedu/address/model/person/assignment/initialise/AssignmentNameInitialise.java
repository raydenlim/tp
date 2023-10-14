package seedu.address.model.person.assignment.initialise;

import seedu.address.model.person.assignment.AssignmentName;

import java.util.ArrayList;

public class AssignmentNameInitialise {
    private static ArrayList<AssignmentName> assignmentNames = new ArrayList<>();

    public void initMissions() {
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Rune Trials"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Rune Reading"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Beyond the Second Dimension"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Curve Introduction"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Curve Manipulation"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Beyond the First Dimension"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Premorseal Communications"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("POTS and Pans"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Musical Diversions"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Search and Rescue"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Sorting Things Out"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Robotic Trials"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Moving about on Planet Y"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Finding ELDRIC"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Know Your Environment"));
    }

    public void initQuests() {
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Runic Carpets"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Colorful Carpets"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Functional Expressionism"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Cardioid Arrest"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Curvaceous Wizardry"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("The Magical Tone Matrix"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Echoes of the Past"));
        AssignmentNameInitialise.assignmentNames.add(new AssignmentName("Grading a Sort"));
    }

    public AssignmentName getName(int index) {
        return this.assignmentNames.get(index);
    }

    public int size() {
        return this.assignmentNames.size();
    }
}
