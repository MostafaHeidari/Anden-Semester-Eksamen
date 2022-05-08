package BE;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    public int classId;
    public String className;
    private List<Student> listOfStudents = new ArrayList<>();

    /**
     * @param classId
     * @param className
     * Constructor with SchoolClass, classId and className
     */
    public SchoolClass(int classId, String className) {
        this.classId = classId;
        this.className = className;
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
     * Gets the getClassId
     * @return getClassId
     */
    public int getClassId() {
        return classId;
    }

    /**
     * Sets the getClassId
     * @return getClassId
     */
    public void setClassId(int classId) {
        this.classId = classId;
    }

    /**
     * Gets the className
     * @return className
     */
    public String getClassName() {
        return className;
    }

    /**
     * Sets the className
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Gets the list of Student in classes
     * @return temp
     */
    public ObservableList<Student> getStudentsInClasses() {
        ObservableList<Student> temp = FXCollections.observableArrayList(listOfStudents);
        return temp;
    }
}
