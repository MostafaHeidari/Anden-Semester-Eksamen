package BE;

public class Student {
    public int studentId;
    public String studentName;
    public String lastName;
    public String email;
    public String age;

    public Student(int studentId,String navn, String efternavn, String email, String age) {
        this.studentId = studentId;
        this.studentName = navn;
        this.lastName = efternavn;
        this.email = email;
        this.age = age;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStduentName() {
        return studentName;
    }

    public void setStduentName(String stduentName) {
        this.studentName = stduentName;
    }

    public String getEfternavn() {
        return lastName;
    }

    public void setEfternavn(String efternavn) {
        this.lastName = efternavn;
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
