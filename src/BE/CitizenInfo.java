package BE;

public class CitizenInfo {
    private int citizenId;
    private String citizenName;
    private String citizenLastName;
    private String citizenAge;
    private int citizinPhoneNumber;
    private String citizenAddress;
    private boolean citizenSEX;
    private String citizenInformation;

    /**
     * @param citizenId
     * @param citizenName
     * @param citizenLastName
     * @param citizenAge
     * Constructor with citizenId, citizenName,  citizenLastName, citizenAge
     */

    public CitizenInfo(int citizenId, String citizenName, String citizenLastName, String citizenAge, int citizinPhoneNumber, String citizenAddress, boolean citizenSEX, String citizenInformation) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenLastName = citizenLastName;
        this.citizenAge = citizenAge;
        this.citizinPhoneNumber = citizinPhoneNumber;
        this.citizenAddress = citizenAddress;
        this.citizenSEX = citizenSEX;
        this.citizenInformation = citizenInformation;
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

    public int getCitizinPhoneNumber() {
        return citizinPhoneNumber;
    }

    public void setCitizinPhoneNumber(int citizinPhoneNumber) {
        this.citizinPhoneNumber = citizinPhoneNumber;
    }

    public String getCitizenAddress() {
        return citizenAddress;
    }

    public void setCitizenAddress(String citizenAddress) {
        this.citizenAddress = citizenAddress;
    }

    public boolean isCitizenSEX() {
        return citizenSEX;
    }

    public void setCitizenSEX(boolean citizenSEX) {
        this.citizenSEX = citizenSEX;
    }

    public String getCitizenInformation() {
        return citizenInformation;
    }

    public void setCitizenInformation(String citizenInformation) {
        this.citizenInformation = citizenInformation;
    }

    @Override
    public String toString() {
        return "CitizenInfo{" +
                "citizenId=" + citizenId +
                ", citizenName='" + citizenName + '\'' +
                ", citizenLastName='" + citizenLastName + '\'' +
                ", citizenAge='" + citizenAge + '\'' +
                ", citizinPhoneNumber=" + citizinPhoneNumber +
                ", citizenAddress='" + citizenAddress + '\'' +
                ", citizenSEX=" + citizenSEX +
                ", citizenInformation='" + citizenInformation + '\'' +
                '}';
    }
}
