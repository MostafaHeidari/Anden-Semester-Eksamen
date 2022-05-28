package BE;

public class GeneralInformation {
    //all these info variables takes from SOSU Sketches //
    private int id;
    private String mestring;
    private String motivation;
    private String resourcer;
    private String roller;
    private String vaner;
    private String uddanelseJob;
    private String liveHistorie;
    private String helbredsOplysninger;
    private String hjælpeMidler;
    private String boligensIndretning;
    private String netværk;
    private int patientID;

    /**
     * @param id
     * @param mestring
     * @param motivation
     * @param resourcer
     * @param roller
     * @param vaner
     * @param uddanelseJob
     * @param liveHistorie
     * @param helbredsOplysninger
     * @param hjælpeMidler
     * @param boligensIndretning
     * @param netværk
     * Constructor with id, mestring,  motivation, resources, rolls, habits, studyJOB, lifeStory, HealthInformation, AssistiveDevices, InteriorDesign, Network
     */
    public GeneralInformation(String mestring, String motivation, String resourcer, String roller, String vaner, String uddanelseJob, String liveHistorie, String helbredsOplysninger, String hjælpeMidler, String boligensIndretning, String netværk, int patientID) {
        this.mestring = mestring;
        this.motivation = motivation;
        this.resourcer = resourcer;
        this.roller = roller;
        this.vaner = vaner;
        this.uddanelseJob = uddanelseJob;
        this.liveHistorie = liveHistorie;
        this.helbredsOplysninger = helbredsOplysninger;
        this.hjælpeMidler = hjælpeMidler;
        this.boligensIndretning = boligensIndretning;
        this.netværk = netværk;
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

    public String getRoller() {
        return roller;
    }

    public void setRoller(String roller) {
        this.roller = roller;
    }

    public String getVaner() {
        return vaner;
    }

    public void setVaner(String vaner) {
        this.vaner = vaner;
    }

    public String getUddanelseJob() {
        return uddanelseJob;
    }

    public void setUddanelseJob(String uddanelseJob) {
        this.uddanelseJob = uddanelseJob;
    }

    public String getLiveHistorie() {
        return liveHistorie;
    }

    public void setLiveHistorie(String liveHistorie) {
        this.liveHistorie = liveHistorie;
    }

    public String getHelbredsOplysninger() {
        return helbredsOplysninger;
    }

    public void setHelbredsOplysninger(String helbredsOplysninger) {
        this.helbredsOplysninger = helbredsOplysninger;
    }

    public String getHjælpeMidler() {
        return hjælpeMidler;
    }

    public void setHjælpeMidler(String hjælpeMidler) {
        this.hjælpeMidler = hjælpeMidler;
    }

    public String getBoligensIndretning() {
        return boligensIndretning;
    }

    public void setBoligensIndretning(String boligensIndretning) {
        this.boligensIndretning = boligensIndretning;
    }

    public String getNetværk() {
        return netværk;
    }

    public void setNetværk(String netværk) {
        this.netværk = netværk;
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
                ", resources='" + resourcer + '\'' +
                ", rolls='" + roller + '\'' +
                ", habits='" + vaner + '\'' +
                ", educationAndJob='" + uddanelseJob + '\'' +
                ", lifeStory='" + liveHistorie + '\'' +
                ", healthInformation='" + helbredsOplysninger + '\'' +
                ", AssistiveDevices='" + hjælpeMidler + '\'' +
                ", homeLayout='" + boligensIndretning + '\'' +
                ", Network='" + netværk + '\'' +
                '}';
    }
}
