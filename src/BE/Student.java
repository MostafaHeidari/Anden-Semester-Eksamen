package BE;

public class Student {
    private int studentId;
    private String studentName;
    private String lastName;
    private String userName;

    /**
     * @param studentId
     * @param studentName
     * @param lastName
     * @param userName
     * Constructor with studentId,  studentName, lastName, userName
     */
    public Student(int studentId, String studentName, String lastName,String userName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.lastName = lastName;
        this.userName = userName;

    }

    /**
     * Gets the userName
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the userName
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the studentId
     * @return studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Sets the studentId
     * @param studentId
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    /**
     * Gets the studentName
     * @return studentName
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Sets the studentName
     * @Param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Gets the lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the lastName
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    /**
     * ToString method
     * @return studentId, studentName, lastName, email, age, userName
     */
    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
