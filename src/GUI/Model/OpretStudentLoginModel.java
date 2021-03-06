package GUI.Model;

import BE.Login;
import BE.Student;
import BLL.OpretStudentManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class OpretStudentLoginModel {

    private final OpretStudentManager opretStudentManager;

    /**
     * Constructor
     * @throws IOException
     */
    public OpretStudentLoginModel() throws IOException {
        opretStudentManager = new OpretStudentManager();
    }


    /*
    public static ObservableList getStudents() {
        return null;
    }
    
     */


    /**
     * Gets the login username and the password using login from loginManager
     * @param username
     * @param password
     * @return
     * @throws SQLServerException
     */
    public Login opretStudent(String username, String password) throws SQLException {
        return opretStudentManager.opretStudent(username, password);
    }
}
