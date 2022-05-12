package BE;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SchoolGroups {
    private int groupId;
    private String groupName;
    private List<Student> listOfStudents = new ArrayList<>();

    /**
     * @param groupId
     * @param groupName
     * Constructor with SchoolGroups, classId and groupName
     */
    public SchoolGroups(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    /**
     * adds the student
     * @param student
     */
    public void addStudentToList(Student student)
    {
        listOfStudents.add(student);
    }

    /**
     * Gets the groupId
     * @return groupId
     */
    public int getGroupId() {
        return groupId;
    }

    /**
     * Sets the groupId
     * @return groupId
     */
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    /**
     * Gets the groupName
     * @return groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the groupName
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * Gets the list of Student in classes
     * @return temp
     */
    public ObservableList<Student> getStudentsInGroups() {
        ObservableList<Student> temp = FXCollections.observableArrayList(listOfStudents);
        return temp;
    }
}
