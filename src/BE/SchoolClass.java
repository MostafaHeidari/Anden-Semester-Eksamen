package BE;

public class SchoolClass {
    public int classId;
    public String className;

    public SchoolClass(int klasseId, String klasseNavn) {
        this.classId = klasseId;
        this.className = klasseNavn;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int klasseId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String klasseNavn) {
        this.className = className;
    }
}
