package GUI.Model;

import BE.SchoolGroups;
import BLL.ClassManger;
import DAL.db.Teacher.ClassDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class ClassModel {
    ClassDAO classDAO = new ClassDAO();

    private ObservableList<SchoolGroups> classList = FXCollections.observableArrayList();

    private ClassManger classManger;

    /**
     * Constructor
     * @throws IOException
     */
    public ClassModel() throws IOException {
        classManger = new ClassManger();
    }

    /**
     * Gets the list of getAllClasses using the getAllClasses method in classManager.
     * @return a list of getAllClasses
     */
    public ObservableList<SchoolGroups> getAllClasses() {
        classList = classManger.getAllClasses();
        return classList;
    }

    /**
     * Gets the uploadKlasseInfo className using uploadKlasseInfo from classManger
     * @param className
     * @throws SQLServerException
     */
    public void uploadKlasseInfo(String className) throws SQLException {
        classList.add(classManger.uploadClassInfo(className));
    }

    /**
     * Gets the deleteAClass selectedClass using deleteAClass from classManger
     * @param selectedClass
     */
    public void deleteAClass(SchoolGroups selectedClass) {
        classList.remove(selectedClass);
        classManger.deleteAClass(selectedClass);
    }
}
