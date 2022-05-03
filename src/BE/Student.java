package BE;

public class Student {
    public int studentId;
    public String studentName;
    public String lastName;
    public String email;
    public String age;
    public String userName;

    public Student(int studentId, String studentName, String lastName, String email, String age,String userName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.userName = userName;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

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
