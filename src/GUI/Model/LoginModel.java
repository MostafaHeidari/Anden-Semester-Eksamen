package GUI.Model;

import BE.Login;
import BLL.LoginManager;
import DAL.crypto.BCrypt;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.SQLException;

public class LoginModel {

        // Static variable reference of single_instance
        // of type Singleton
    private static LoginModel single_instance = null;


        // Static method
        // Static method to create instance of Singleton class
        public static LoginModel getInstance() throws IOException {
            if (single_instance == null)
                single_instance = new LoginModel();

            return single_instance;
        }

    private LoginManager loginManager;

    private ObservableList<Login> loginList = FXCollections.observableArrayList();

    // Password -> A salt -> A hash
    // Store : password = password , salt = BCrypt.gensalt , hash =   new SecureRandom()
    // Log rounds
    String salt;

    /**
     * Constructor
     * @throws IOException
     */
    public LoginModel() throws IOException {
        loginManager = new LoginManager();
    }

    public String getSalt(){
        return BCrypt.gensalt(10);
    }

    /**
     * Gets the login username and the password using login from loginManager
     * @param username
     * @param password
     * @return
     * @throws SQLServerException
     */
    public Login login(String username, String password) throws SQLServerException {
        return loginManager.login(username, password);
    }

    /**
     * Gets the uploadLogin studentUsername, studentPassword using uploadLogin from loginManager
     * @param studentUsername
     * @param hashedPassword
     * @throws SQLServerException
     */
    public void uploadLogin(String studentUsername, String hashedPassword) throws SQLException {
        String salt = getSalt();
        loginList.add(loginManager.uploadLogin(studentUsername,BCrypt.hashpw(hashedPassword, salt), salt));
    }

    /**
     * Gets the uploadLogin studentUsername, studentPassword using uploadLogin from loginManager
     * @param userNameTeacher
     * @param passwordTeacher
     * @throws SQLServerException
     */
    public void uploadLoginTeacher(String userNameTeacher, String passwordTeacher) throws SQLException {
        String salt = getSalt();
        loginList.add(loginManager.uploadLoginTeacher(userNameTeacher,BCrypt.hashpw(passwordTeacher, salt), salt));
    }


    /**
     * Gets the uploadLogin userNameAdmin, passwordAdmin using uploadLogin from loginManager
     * @param userNameAdmin
     * @param passwordAdmin
     * @throws SQLServerException
     */
    public void uploadLoginAdmin(String userNameAdmin, String passwordAdmin) throws SQLException {
        String salt = getSalt();
        loginList.add(loginManager.uploadLoginAdmin(userNameAdmin,BCrypt.hashpw(passwordAdmin, salt), salt));
    }


    /**
     * Gets the removeAdmin selectedAdmin using removeAdmin from loginManager
     * @param selectedAdmin
     * @throws SQLServerException
     */
    public void removeAdmin(Login selectedAdmin) {
        loginManager.removeAdmin(selectedAdmin);
        loginList.remove(selectedAdmin);
    }
}
