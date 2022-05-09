package BE;

public class GeneralInformation {
    //all these info variables takes from SOSU Sketches //
    private int id;
    private String mestring;
    private String motivation;
    private String resources;
    private String rolls;
    private String habits;
    private String educationAndJob;
    private String lifeStory;
    private final String healthInformation;
    private final String AssistiveDevices;
    private final String homeLayout;
    private final String Network;

    /**
     * @param id
     * @param mestring
     * @param motivation
     * @param resources
     * @param rolls
     * @param habits
     * @param studyJOB
     * @param lifeStory
     * @param HealthInformation
     * @param InteriorDesign
     * @param Network
     * Constructor with id, mestring,  motivation, resources, rolls, habits, studyJOB, lifeStory, HealthInformation, AssistiveDevices, InteriorDesign, Network
     */
    public GeneralInformation(int id, String mestring, String motivation, String resources, String rolls, String habits, String studyJOB, String lifeStory, String HealthInformation, String AssistiveDevices, String InteriorDesign, String Network) {
        this.id = id;
        this.mestring = mestring;
        this.motivation = motivation;
        this.resources = resources;
        this.rolls = rolls;
        this.habits = habits;
        this.educationAndJob = studyJOB;
        this.lifeStory = lifeStory;
        this.healthInformation = HealthInformation;
        this.AssistiveDevices = AssistiveDevices;
        this.homeLayout = InteriorDesign;
        this.Network = Network;
    }

    /**
     * Gets the id
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the mestring
     * @return mestring
     */
    public String getMestring() {
        return mestring;
    }

    /**
     * Sets the mestring
     * @param mestring
     */
    public void setMestring(String mestring) {
        this.mestring = mestring;
    }

    /**
     * Gets the motivation
     * @return motivation
     */
    public String getMotivation() {
        return motivation;
    }

    /**
     * Sets the motivation
     * @param motivation
     */
    public void setMotivation(String motivation) {
        this.motivation = motivation;
    }

    /**
     * Gets the resources
     * @return resources
     */
    public String getResources() {
        return resources;
    }

    /**
     * Sets the ressourcer
     * @param ressourcer
     */
    public void setResources(String ressourcer) {
        this.resources = resources;
    }

    /**
     * Gets the rolls
     * @return rolls
     */
    public String getRolls() {
        return rolls;
    }

    /**
     * Sets the rolls
     * @param rolls
     */
    public void setRolls(String rolls) {
        this.rolls = rolls;
    }

    /**
     * Gets the habits
     * @return habits
     */
    public String getHabits() {
        return habits;
    }

    /**
     * Gets the habits
     * @param habits
     */
    public void setHabits(String habits) {
        this.habits = habits;
    }

    /**
     * Gets the studyJOB
     * @return studyJOB
     */
    public String getstudyJOB() {
        return educationAndJob;
    }

    /**
     * Sets the studyJOB
     * @param studyJOB
     */
    public void setstudyJOB(String studyJOB) {
        this.educationAndJob = studyJOB;
    }

    /**
     * Gets the lifeStory
     * @return lifeStory
     */
    public String getlifeStory() {
        return lifeStory;
    }

    /**
     * Sets the lifeStory
     * @param lifeStory
     */
    public void setlifeStory(String lifeStory) {
        this.lifeStory = lifeStory;
    }

    /**
     * Gets the HealthInformation
     * @return HealthInformation
     */
    public String getHealthInformation() {
        return healthInformation;
    }

    /**
     * Sets the HealthInformation
     * @param HealthInformation
     */
    public void setHealthInformation(String HealthInformation) {
        HealthInformation = HealthInformation;
    }

    /**
     * Gets the AssistiveDevices
     * @return AssistiveDevices
     */
    public String getAssistiveDevices() {
        return AssistiveDevices;
    }

    /**
     * Sets the AssistiveDevices
     * @param AssistiveDevices
     */
    public void setAssistiveDevices(String AssistiveDevices) {
        AssistiveDevices = AssistiveDevices;
    }

    /**
     * Gets the InteriorDesign
     * @return InteriorDesign
     */
    public String getInteriorDesign() {
        return homeLayout;
    }

    /**
     * Sets the InteriorDesign
     * @param InteriorDesign
     */
    public void setInteriorDesign(String InteriorDesign) {
        InteriorDesign = InteriorDesign;
    }

    /**
     * Gets the Network
     * @return Network
     */
    public String getNetwork() {
        return Network;
    }

    /**
     * Sets the Network
     * @param Network
     */
    public void setNetwork(String Network) {
        Network = Network;
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
                ", resources='" + resources + '\'' +
                ", rolls='" + rolls + '\'' +
                ", habits='" + habits + '\'' +
                ", educationAndJob='" + educationAndJob + '\'' +
                ", lifeStory='" + lifeStory + '\'' +
                ", healthInformation='" + healthInformation + '\'' +
                ", AssistiveDevices='" + AssistiveDevices + '\'' +
                ", homeLayout='" + homeLayout + '\'' +
                ", Network='" + Network + '\'' +
                '}';
    }
}
