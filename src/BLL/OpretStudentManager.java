package BLL;

import BE.Login;
import DAL.OpretStudentLoginDAO;

import java.io.IOException;
import java.sql.SQLException;

public class OpretStudentManager {
    private OpretStudentLoginDAO opretStudentDAO;


    public OpretStudentManager() throws IOException {
        opretStudentDAO = new OpretStudentLoginDAO();
    }

    public Login opretStudent(String username, String password) throws SQLException {
        return opretStudentDAO.addStudent(username, password);
    }
}
