package BLL;

import BE.Login;
import DAL.OpretStudentDAO;

import java.io.IOException;
import java.sql.SQLException;

public class OpretStudentManager {
    private OpretStudentDAO opretStudentDAO;

    public OpretStudentManager() throws IOException {
        opretStudentDAO = new OpretStudentDAO();
    }

    public Login opretStudent(String username, String password) throws SQLException {
        return opretStudentDAO.addStudent(username, password);
    }
}
