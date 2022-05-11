package BE;

public class Citizen {
    private int patientID;
    private String namePatient;
    private String lastNamePatient;
    private int phoneNumber;
    private String address;
    private boolean sex;

    public Citizen(int patientID, String namePatient, String lastNamePatient, int phoneNumber, String address, boolean sex) {
        this.patientID = patientID;
        this.namePatient = namePatient;
        this.lastNamePatient = lastNamePatient;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.sex = sex;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getLastNamePatient() {
        return lastNamePatient;
    }

    public void setLastNamePatient(String lastNamePatient) {
        this.lastNamePatient = lastNamePatient;
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

    @Override
    public String toString() {
        return "patient{" +
                "patientID=" + patientID +
                ", namePatient='" + namePatient + '\'' +
                ", lastNamePatient='" + lastNamePatient + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                '}';
    }
}

