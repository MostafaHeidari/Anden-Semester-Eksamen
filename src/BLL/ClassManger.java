package BLL;

import BE.SchoolClass;
import DAL.ClassDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class ClassManger {
    ClassDAO classDAO = new ClassDAO();

    public ClassManger() throws IOException {
    }

    public SchoolClass uploadClassInfo(String className) throws SQLException {
        return (classDAO.uploadClassInfo(className));
    }

    public ObservableList<SchoolClass> getAllClasses() {
        ObservableList<SchoolClass> classesObs = FXCollections.observableArrayList();


        try {
            classesObs.addAll(classDAO.getAllClasses());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classesObs;
    }
}
