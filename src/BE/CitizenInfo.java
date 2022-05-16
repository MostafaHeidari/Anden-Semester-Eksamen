package BE;

public class CitizenInfo {
    private int citizenId;
    private String citizenName;
    private String citizenLastName;
    private String citizenAddress;
    private String CPR;
    private String citizenInformation;

    /**
     * @param citizenId
     * @param citizenName
     * @param citizenLastName

     * Constructor with citizenId, citizenName,  citizenLastName, citizenAge
     */
    public CitizenInfo(int citizenId, String citizenName, String citizenLastName, String citizenAddress, String CPR, String citizenInformation) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenLastName = citizenLastName;
        this.citizenAddress = citizenAddress;
        this.CPR = CPR;
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

    public String getCitizenAddress() {
        return citizenAddress;
    }

    public void setCitizenAddress(String citizenAddress) {
        this.citizenAddress = citizenAddress;
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
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
                ", citizenAddress='" + citizenAddress + '\'' +
                ", CPR='" + CPR + '\'' +
                ", citizenInformation='" + citizenInformation + '\'' +
                '}';
    }
}
