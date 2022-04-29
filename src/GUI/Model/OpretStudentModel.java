package GUI.Model;

import BE.Login;
import BLL.OpretStudentManager;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;

public class OpretStudentModel {
    private OpretStudentManager opretStudentManager;

    /**
     * Constructor
     * @throws IOException
     */
    public OpretStudentModel() throws IOException {
        opretStudentManager = new OpretStudentManager();
    }

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
