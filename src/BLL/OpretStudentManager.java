package BLL;

import BE.Login;
import DAL.OpretStudentLoginDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.IOException;
import java.sql.SQLException;

public class OpretStudentManager {
    private OpretStudentLoginDAO opretStudentDAO;

    /**
     * Constructor
     * @throws IOException
     */
    public OpretStudentManager() throws IOException {
        opretStudentDAO = new OpretStudentLoginDAO();
    }

    /**
     * Gets the login username and the password using opretStudent from opretStudentDAODAO
     * @param username
     * @param password
     * @return
     * @throws SQLServerException
     */
    public Login opretStudent(String username, String password) throws SQLException {
        return opretStudentDAO.addStudent(username, password);
    }
}
