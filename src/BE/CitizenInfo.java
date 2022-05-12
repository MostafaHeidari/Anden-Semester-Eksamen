package BE;

public class CitizenInfo {
    public int citizenId;
    public String citizenName;
    public String citizenLastName;
    public String citizenAge;
    private int phoneNumber;
    private String address;
    private boolean sex;
    public String information;

    /**
     * @param citizenId
     * @param citizenName
     * @param citizenLastName
     * @param citizenAge
     * Constructor with citizenId, citizenName,  citizenLastName, citizenAge
     */
    public CitizenInfo(int citizenId, String citizenName, String citizenLastName, String citizenAge, int phoneNumber, String address, boolean sex, String information) {
        this.citizenId = citizenId;
        this.citizenName = citizenName;
        this.citizenLastName = citizenLastName;
        this.citizenAge = citizenAge;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sex = sex;
        this.information = information;
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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

}
