package GUI.Model;

import BE.SchoolClass;
import BLL.ClassManger;
import DAL.ClassDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class ClassModel {
    ClassDAO classDAO = new ClassDAO();

    private ObservableList<SchoolClass> classList = FXCollections.observableArrayList();

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
    public ObservableList<SchoolClass> getAllClasses() {
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

    public void deleteAClass(SchoolClass selectedClass) {
        classList.remove(selectedClass);
        classManger.deleteAClass(selectedClass);
    }
}
