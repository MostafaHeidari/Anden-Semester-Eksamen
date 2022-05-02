package BE;

public class Student {
    public int studentId;
    public String studentName;
    public String efternavn;
    public String email;
    public String age;

    public Student(int studentId,String navn, String efternavn, String email, String age) {
        this.studentId = studentId;
        this.studentName = navn;
        this.efternavn = efternavn;
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
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
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
                ", efternavn='" + efternavn + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
