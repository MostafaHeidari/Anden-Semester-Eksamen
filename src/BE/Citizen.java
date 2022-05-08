package BE;

public class Citizen {
    public int citizenId;
    public String citizenName;
    public String citizenLastName;
    public String citizenAge;

    /**
     * @param citizenId
     * @param citizenName
     * @param citizenLastName
     * @param citizenAge
     * Constructor with citizenId, citizenName,  citizenLastName, citizenAge
     */
    public Citizen(int citizenId, String citizenName, String citizenLastName, String citizenAge) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenLastName = citizenLastName;
        this.citizenAge = citizenAge;
    }

    /**
     * Gets the citizenId
     * @return citizenId
     */
    public int getCitizenId() {
        return citizenId;
    }

    /**
     * Sets the citizenId
     * @param citizenId
     */
    public void setCitizenId(int citizenId) {
        this.citizenId = citizenId;
    }

    /**
     * Gets the citizenName
     * @return citizenName
     */
    public String getCitizenName() {
        return citizenName;
    }

    /**
     * Sets the citizenName
     * @param citizenName
     */
    public void setCitizenName(String citizenName) {
        this.citizenName = citizenName;
    }

    /**
     * Gets the citizenLastName
     * @return citizenLastName
     */
    public String getCitizenLastName() {
        return citizenLastName;
    }

    /**
     * Sets the citizenLastName
     * @param citizenLastName
     */
    public void setCitizenLastName(String citizenLastName) {
        this.citizenLastName = citizenLastName;
    }

    /**
     * Gets the citizenAge
     * @return citizenAge
     */
    public String getCitizenAge() {
        return citizenAge;
    }

    /**
     * Sets the citizenAge
     * @param citizenAge
     */
    public void setCitizenAge(String citizenAge) {
        this.citizenAge = citizenAge;
    }
}
