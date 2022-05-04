package BE;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {
    public int classId;
    public String className;
    private List<Student> listOfStudents = new ArrayList<>();

    public SchoolClass(int klasseId, String klasseNavn) {
        this.classId = klasseId;
        this.className = klasseNavn;
    }

    public void addStudentToList(Student student)
    {
        listOfStudents.add(student);
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int klasseId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String klasseNavn) {
        this.className = className;
    }

    public ObservableList<Student> getStudentsInClasses() {
        ObservableList<Student> temp = FXCollections.observableArrayList(listOfStudents);
        return temp;
    }
}
