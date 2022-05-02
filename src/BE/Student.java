package BE;

public class Student {
    public int studentId;
    public String studentName;
    public String lastName;
    public String email;
    public String age;

    public Student(int studentId, String studentName, String lastName, String email, String age) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
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
                ", navn='" + studentName + '\'' +
                ", efternavn='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
