package BE;

public class GeneralInformation {
    //all these info variables takes from SOSU Sketches //
    private int id;
    private String mestring;
    private String motivation;
    private String resourcer;
    private String rolls;
    private String habits;
    private String educationAndJob;
    private String lifeStory;
    private final String healthInformation;
    private final String AssistiveDevices;
    private final String homeLayout;
    private final String Network;
    private int patientID;

    /**
     * @param mestring
     * @param motivation
     * @param resourcer
     * @param rolls
     * @param habits
     * @param educationAndJob
     * @param lifeStory
     * @param healthInformation
     * @param assistiveDevices
     * @param network
     * @param patientID
     */
    public GeneralInformation(String mestring, String motivation, String resourcer, String rolls, String habits, String educationAndJob, String lifeStory, String healthInformation, String assistiveDevices, String homeLayout, String network, int patientID) {
        this.id = id;
        this.mestring = mestring;
        this.motivation = motivation;
        this.resourcer = resourcer;
        this.rolls = rolls;
        this.habits = habits;
        this.educationAndJob = educationAndJob;
        this.lifeStory = lifeStory;
        this.healthInformation = healthInformation;
        AssistiveDevices = assistiveDevices;
        this.homeLayout = homeLayout;
        Network = network;
        this.patientID = patientID;
    }

    /**
     * Getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMestring() {
        return mestring;
    }

    public void setMestring(String mestring) {
        this.mestring = mestring;
    }

    public String getMotivation() {
        return motivation;
    }

    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    public String getResourcer() {
        return resourcer;
    }

    public void setResourcer(String resourcer) {
        this.resourcer = resourcer;
    }

    public String getRolls() {
        return rolls;
    }

    public void setRolls(String rolls) {
        this.rolls = rolls;
    }

    public String getHabits() {
        return habits;
    }

    public void setHabits(String habits) {
        this.habits = habits;
    }

    public String getEducationAndJob() {
        return educationAndJob;
    }

    public void setEducationAndJob(String educationAndJob) {
        this.educationAndJob = educationAndJob;
    }

    public String getLifeStory() {
        return lifeStory;
    }

    public void setLifeStory(String lifeStory) {
        this.lifeStory = lifeStory;
    }

    public String getHealthInformation() {
        return healthInformation;
    }

    public String getAssistiveDevices() {
        return AssistiveDevices;
    }

    public String getHomeLayout() {
        return homeLayout;
    }

    public String getNetwork() {
        return Network;
    }

    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    /**
     * ToString method
     * @return id, mestring, motivation, resources, rolls, habits, studyJOB, lifeStory, HealthInformation, AssistiveDevices, InteriorDesign, Network
     */

    @Override
    public String toString() {
        return "GeneralInformation{" +
                "id=" + id +
                ", mestring='" + mestring + '\'' +
                ", motivation='" + motivation + '\'' +
                ", resourcer='" + resourcer + '\'' +
                ", rolls='" + rolls + '\'' +
                ", habits='" + habits + '\'' +
                ", educationAndJob='" + educationAndJob + '\'' +
                ", lifeStory='" + lifeStory + '\'' +
                ", healthInformation='" + healthInformation + '\'' +
                ", AssistiveDevices='" + AssistiveDevices + '\'' +
                ", homeLayout='" + homeLayout + '\'' +
                ", Network='" + Network + '\'' +
                ", patientID=" + patientID +
                '}';
    }
}
