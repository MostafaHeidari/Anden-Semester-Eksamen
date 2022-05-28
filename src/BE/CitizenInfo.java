package BE;

public class CitizenInfo {
    private int citizenId;
    private String citizenName;
    private String citizenLastName;
    private String citizenAge;

    /**
     * @param citizenId
     * @param citizenName
     * @param citizenLastName
     * @param Age
     * Constructor with citizenId, citizenName,  citizenLastName, Age
     */
    public CitizenInfo(int citizenId, String citizenName, String citizenLastName, String Age) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenLastName = citizenLastName;
        this.citizenAge = Age;
    }




    public int getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    public String getCitizenName() {
        return citizenName;
    }

    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    public String getCitizenLastName() {
        return citizenLastName;
    }

    public void setCitizenLastName(String citizenLastName) {
        this.citizenLastName = citizenLastName;
    }

    public String getCitizenAge() {
        return citizenAge;
    }

    public void setCitizenAge(String Age) {
        this.citizenAge = Age;
    }


    @Override
    public String toString() {
        return "CitizenInfo{" +
                "citizenId=" + citizenId +
                ", citizenName='" + citizenName + '\'' +
                ", citizenLastName='" + citizenLastName + '\'' +
                ", Age='" + citizenAge + '\'' +
                '}';
    }
}
