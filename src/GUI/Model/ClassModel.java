package GUI.Model;

import BE.Class;
import BLL.ClassManger;
import DAL.ClassDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class ClassModel {
    ClassDAO classDAO = new ClassDAO();

    private ObservableList<Class> classList = FXCollections.observableArrayList();

    private ClassManger classManger;

    public ClassModel() throws IOException {
        classManger = new ClassManger();
    }

    public ObservableList<Class> getAllClasses() {
        classList = classManger.getAllClasses();
        return classList;
    }

    public void uploadKlasseInfo(String className) throws SQLException {
        classList.add(classManger.uploadClassInfo(className));
    }
}
