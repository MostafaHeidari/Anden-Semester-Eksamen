package BLL;

import BE.Student;
import DAL.StudentDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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

/*
     // Edits a student using the editStudent method from userDAO //

    public void editStudent(Student student) throws Exception {
        StudentDAO.editStudent(student);
    }

 */

/*
    public void deleteStudent(Student selectedStudent) {
        StudentDAO.deleteStudent(selectedStudent);
    }

 */
}
