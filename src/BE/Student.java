package BE;

public class Student {
    public int studentId;
    public String studentName;
    public String lastName;
    public String email;
    public String age;
    public String userName;

    /**
     * @param studentId
     * @param studentName
     * @param lastName
     * @param email
     * @param age
     * @param userName
     * Constructor with studentId,  studentName, lastName, email, userName
     */
    public Student(int studentId, String studentName, String lastName, String email, String age,String userName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
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
     * Gets the email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the age
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * Gets the age
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
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
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
