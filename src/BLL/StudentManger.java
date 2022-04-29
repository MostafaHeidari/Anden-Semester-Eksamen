package BLL;

import BE.Student;
import DAL.StudentDAO;

import java.io.IOException;
import java.sql.SQLException;

public class StudentManger {
    StudentDAO studentDAO = new StudentDAO();
    /**
     * Constructor
     * @throws IOException
     */
    public StudentManger() throws IOException {
        studentDAO = new StudentDAO();
    }
    public Student uploadStudentinfo(String studentNavn, String studentEfternavn, String studentEmail, String studentAlder) throws SQLException {
            return(studentDAO.uploadStudentinfo(studentNavn,studentEfternavn,studentEmail,studentAlder));
    }
}
