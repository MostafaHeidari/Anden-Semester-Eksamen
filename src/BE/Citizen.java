package BE;

public class Citizen {
    public int citizenId;
    public String citizenName;
    public String citizenLastName;
    public String citizenAge;

    public Citizen(int citizenId, String citizenName, String citizenLastName, String citizenAge) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenLastName = citizenLastName;
        this.citizenAge = citizenAge;
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

    public void setCitizenAge(String citizenAge) {
        this.citizenAge = citizenAge;
    }
}
