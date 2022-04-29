package BLL;

import BE.Class;
import DAL.ClassDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class ClassManger {
    ClassDAO classDAO = new ClassDAO();

    public ClassManger() throws IOException {
    }

    public Class uploadClassInfo(String className) throws SQLException {
        return (classDAO.uploadClassInfo(className));
    }

    public ObservableList<Class> getAllClasses() {
        ObservableList<Class> classesObs = FXCollections.observableArrayList();


        try {
            classesObs.addAll(classDAO.getAllClasses());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classesObs;
    }
}
