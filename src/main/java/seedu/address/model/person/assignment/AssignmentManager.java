package seedu.address.model.person.assignment;

public class AssignmentManager {
    private AssignmentName name;
    private AssignmentMaxGrade maxGrade;

    public AssignmentManager() {
        this.name = new AssignmentName();
        this.name.initMissions();
        this.name.initQuests();

        this.maxGrade = new AssignmentMaxGrade();
        this.maxGrade.missionGrades();
        this.maxGrade.questGrades();
    }

    public String getAssignmentName(int index) {
        return this.name.getName(index);
    }

    public String getAssignmentMaxGrade(int index) {
        return this.maxGrade.getGrade(index);
    }

    public int size() {
        return this.name.size();
    }
}
