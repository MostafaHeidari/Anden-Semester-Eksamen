package BLL;

import BE.SchoolClass;
import DAL.ClassDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class ClassManger {
    ClassDAO classDAO = new ClassDAO();

    /**
     * Constructor
     * @throws IOException
     */
    public ClassManger() throws IOException {
    }

    /**
     * Gets the SchoolClass className using SchoolClass from ClassDAO
     * @param className
     * @return
     * @throws SQLServerException
     */
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
