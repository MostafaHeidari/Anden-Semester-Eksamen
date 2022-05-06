package BE;

public class GeneralInformation {
    //alle these info variables takes from SOSU Sketches //
    private int id;
    private String mestring;
    private String motivation;
    private String resources;
    private String roles;
    private String habits;
    private String educationAndJob;
    private String lifestory;
    private String healthInformation;
    private String Aids;
    private String homeLayout;
    private String network;

    // the Constructor of GenralInfo class

    public GeneralInformation(int id, String mestring, String motivation, String resources, String roles, String habits, String educationAndJob, String lifestory, String healthInformation, String aids, String homeLayout, String network) {
        this.id = id;
        this.mestring = mestring;
        this.motivation = motivation;
        this.resources = resources;
        this.roles = roles;
        this.habits = habits;
        this.educationAndJob = educationAndJob;
        this.lifestory = lifestory;
        this.healthInformation = healthInformation;
        Aids = aids;
        this.homeLayout = homeLayout;
        this.network = network;
    }

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

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
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

    public String getLifestory() {
        return lifestory;
    }

    public void setLifestory(String lifestory) {
        this.lifestory = lifestory;
    }

    public String getHealthInformation() {
        return healthInformation;
    }

    public void setHealthInformation(String healthInformation) {
        this.healthInformation = healthInformation;
    }

    public String getAids() {
        return Aids;
    }

    public void setAids(String aids) {
        Aids = aids;
    }

    public String getHomeLayout() {
        return homeLayout;
    }

    public void setHomeLayout(String homeLayout) {
        this.homeLayout = homeLayout;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    @Override
    public String toString() {
        return "GeneralInformation{" +
                "id=" + id +
                ", mestring='" + mestring + '\'' +
                ", motivation='" + motivation + '\'' +
                ", resources='" + resources + '\'' +
                ", roles='" + roles + '\'' +
                ", habits='" + habits + '\'' +
                ", educationAndJob='" + educationAndJob + '\'' +
                ", lifestory='" + lifestory + '\'' +
                ", healthInformation='" + healthInformation + '\'' +
                ", Aids='" + Aids + '\'' +
                ", homeLayout='" + homeLayout + '\'' +
                ", network='" + network + '\'' +
                '}';
    }
}
