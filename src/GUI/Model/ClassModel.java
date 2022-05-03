package GUI.Model;

import BE.SchoolClass;
import BLL.ClassManger;
import DAL.ClassDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class ClassModel {
    ClassDAO classDAO = new ClassDAO();

    private ObservableList<SchoolClass> classList = FXCollections.observableArrayList();

    private ClassManger classManger;

    public ClassModel() throws IOException {
        classManger = new ClassManger();
    }

    public ObservableList<SchoolClass> getAllClasses() {
        classList = classManger.getAllClasses();
        return classList;
    }

    public void uploadKlasseInfo(String className) throws SQLException {
        classList.add(classManger.uploadClassInfo(className));
    }
}
