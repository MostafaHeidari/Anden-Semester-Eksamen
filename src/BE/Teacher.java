package BE;

public class Teacher {
    private int teacherId;
    private String teacherName;
    private String teacherLastName;
    private String teacherUserName;

    /**
     * @param teacherId
     * @param teacherName
     * @param teacherLastName
     * @param teacherUserName
     * Constructor with teacherId,  teacherName, teacherLastName, teacherEmail, teacherUserName
     */
    public Teacher(int teacherId, String teacherName, String teacherLastName, String teacherUserName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherLastName = teacherLastName;
        this.teacherUserName = teacherUserName;
    }

    /**
     * Gets the teacherId
     * @return teacherId
     */
    public int getTeacherId() {
        return teacherId;
    }

    /**
     * Sets the teacherId
     * @param teacherId
     */
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * Gets the teacherName
     * @return teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * Sets the teacherName
     * @param teacherName
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * Gets the teacherLastName
     * @return teacherLastName
     */
    public String getTeacherLastName() {
        return teacherLastName;
    }

    /**
     * Sets the teacherLastName
     * @param teacherLastName
     */
    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    /**
     * Gets the teacherUserName
     * @return teacherUserName
     */
    public String getTeacherUserName() {
        return teacherUserName;
    }

    /**
     * Sets the teacherUserName
     * @param teacherUserName
     */
    public void setTeacherUserName(String teacherUserName) {
        this.teacherUserName = teacherUserName;
    }
}
