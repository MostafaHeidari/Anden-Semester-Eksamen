package BE;

public class AdminView {
    private int teacherID;
    private String nameTeacher;
    private String lastNameTeacher;
    private String userNameTeacher;
    private String passwordTeacher;
    private String EmailTeacher;

    public AdminView(int teacherID, String nameTeacher, String lastNameTeacher, String userNameTeacher, String passwordTeacher, String emailTeacher) {
        this.teacherID = teacherID;
        this.nameTeacher = nameTeacher;
        this.lastNameTeacher = lastNameTeacher;
        this.userNameTeacher = userNameTeacher;
        this.passwordTeacher = passwordTeacher;
        EmailTeacher = emailTeacher;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getLastNameTeacher() {
        return lastNameTeacher;
    }

    public void setLastNameTeacher(String lastNameTeacher) {
        this.lastNameTeacher = lastNameTeacher;
    }

    public String getUserNameTeacher() {
        return userNameTeacher;
    }

    public void setUserNameTeacher(String userNameTeacher) {
        this.userNameTeacher = userNameTeacher;
    }

    public String getPasswordTeacher() {
        return passwordTeacher;
    }

    public void setPasswordTeacher(String passwordTeacher) {
        this.passwordTeacher = passwordTeacher;
    }

    public String getEmailTeacher() {
        return EmailTeacher;
    }

    public void setEmailTeacher(String emailTeacher) {
        EmailTeacher = emailTeacher;
    }

    @Override
    public String toString() {
        return "AdminView{" +
                "teacherID=" + teacherID +
                ", nameTeacher='" + nameTeacher + '\'' +
                ", lastNameTeacher='" + lastNameTeacher + '\'' +
                ", userNameTeacher='" + userNameTeacher + '\'' +
                ", passwordTeacher='" + passwordTeacher + '\'' +
                ", EmailTeacher='" + EmailTeacher + '\'' +
                '}';
    }
}
