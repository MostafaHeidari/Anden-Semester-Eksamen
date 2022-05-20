package BLL;

import BE.Login;
import DAL.LoginDAO;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.IOException;
import java.sql.SQLException;

public class LoginManager {
    private final LoginDAO loginDao;

    /**
     * Constructor
     * @throws IOException
     */
    public LoginManager() throws IOException {
        loginDao = new LoginDAO();
    }

    /**
     * Gets the login username and the password using login from LoginDAO
     * @param username
     * @param password
     * @return
     * @throws SQLServerException
     */
    public Login login(String username, String password) throws SQLServerException {
        return loginDao.login(username, password);
    }


    /**
     * Gets the uploadLogin studentUsername, studentPassword using uploadLogin from LoginDAO
     * @param studentUsername
     * @param hashedPassword
     * @param salt
     * @return
     * @throws SQLServerException
     */
    public Login uploadLogin(String studentUsername, String hashedPassword, String salt) throws SQLException {
        return(loginDao.uploadLogin(studentUsername, hashedPassword, salt));
    }

    /**
     * Gets the uploadLogin studentUsername, studentPassword using uploadLogin from LoginDAO
     * @param userNameTeacher
     * @param hashPassword
     * @param salt
     * @return
     * @throws SQLServerException
     */
    public Login uploadLoginTeacher(String userNameTeacher, String hashPassword, String salt) throws SQLException {
        return(loginDao.uploadLoginTeacher(userNameTeacher, hashPassword, salt));
    }

    /**
     * Gets the uploadLogin userNameAdmin, adminPassword using uploadLogin from LoginDAO
     * @param userNameAdmin
     * @param hashPassword
     * @param salt
     * @return
     * @throws SQLServerException
     */
    public Login uploadLoginAdmin(String userNameAdmin, String hashPassword, String salt) throws SQLException {
        return(loginDao.uploadLoginAdmin(userNameAdmin, hashPassword, salt));
    }

    /**
     * Gets the removeAdmin selectedAdmin using removeAdmin from loginDao
     * @param selectedAdmin
     * @throws SQLServerException
     */
    public void removeAdmin(Login selectedAdmin) {
        loginDao.removeAdmin(selectedAdmin);
    }
}
