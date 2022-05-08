package BE;

public class GeneralInformation {
    //alle these info variables takes from SOSU Sketches //
    private int id;
    private String mestring;
    private String motivation;
    private String ressourcer;
    private String roller;
    private String vaner;
    private String uddannelseJOB;
    private String livshistorie;
    private String Helbredsoplysninger;
    private String Hjaelpemidler;
    private String BoligIndretning;
    private String Netvaerk;

    /**
     * @param id
     * @param mestring
     * @param motivation
     * @param ressourcer
     * @param roller
     * @param vaner
     * @param uddannelseJOB
     * @param livshistorie
     * @param helbredsoplysninger
     * @param boligIndretning
     * @param netvaerk
     * Constructor with id, mestring,  motivation, ressourcer, roller, vaner, uddannelseJOB, livshistorie, helbredsoplysninger, hjaelpemidler, boligIndretning, netvaerk
     */
    public GeneralInformation(int id, String mestring, String motivation, String ressourcer, String roller, String vaner, String uddannelseJOB, String livshistorie, String helbredsoplysninger, String hjaelpemidler, String boligIndretning, String netvaerk) {
        this.id = id;
        this.mestring = mestring;
        this.motivation = motivation;
        this.ressourcer = ressourcer;
        this.roller = roller;
        this.vaner = vaner;
        this.uddannelseJOB = uddannelseJOB;
        this.livshistorie = livshistorie;
        Helbredsoplysninger = helbredsoplysninger;
        Hjaelpemidler = hjaelpemidler;
        BoligIndretning = boligIndretning;
        Netvaerk = netvaerk;
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
     * Gets the ressourcer
     * @return ressourcer
     */
    public String getRessourcer() {
        return ressourcer;
    }

    /**
     * Sets the ressourcer
     * @param ressourcer
     */
    public void setRessourcer(String ressourcer) {
        this.ressourcer = ressourcer;
    }

    /**
     * Gets the roller
     * @return roller
     */
    public String getRoller() {
        return roller;
    }

    /**
     * Sets the roller
     * @param roller
     */
    public void setRoller(String roller) {
        this.roller = roller;
    }

    /**
     * Gets the vaner
     * @return vaner
     */
    public String getVaner() {
        return vaner;
    }

    /**
     * Gets the vaner
     * @param vaner
     */
    public void setVaner(String vaner) {
        this.vaner = vaner;
    }

    /**
     * Gets the uddannelseJOB
     * @return uddannelseJOB
     */
    public String getUddannelseJOB() {
        return uddannelseJOB;
    }

    /**
     * Sets the uddannelseJOB
     * @param uddannelseJOB
     */
    public void setUddannelseJOB(String uddannelseJOB) {
        this.uddannelseJOB = uddannelseJOB;
    }

    /**
     * Gets the livshistorie
     * @return livshistorie
     */
    public String getLivshistorie() {
        return livshistorie;
    }

    /**
     * Sets the livshistorie
     * @param livshistorie
     */
    public void setLivshistorie(String livshistorie) {
        this.livshistorie = livshistorie;
    }

    /**
     * Gets the Helbredsoplysninger
     * @return Helbredsoplysninger
     */
    public String getHelbredsoplysninger() {
        return Helbredsoplysninger;
    }

    /**
     * Sets the helbredsoplysninger
     * @param helbredsoplysninger
     */
    public void setHelbredsoplysninger(String helbredsoplysninger) {
        Helbredsoplysninger = helbredsoplysninger;
    }

    /**
     * Gets the Hjaelpemidler
     * @return Hjaelpemidler
     */
    public String getHjaelpemidler() {
        return Hjaelpemidler;
    }

    /**
     * Sets the Hjaelpemidler
     * @param hjaelpemidler
     */
    public void setHjaelpemidler(String hjaelpemidler) {
        Hjaelpemidler = hjaelpemidler;
    }

    /**
     * Gets the BoligIndretning
     * @return BoligIndretning
     */
    public String getBoligIndretning() {
        return BoligIndretning;
    }

    /**
     * Sets the BoligIndretning
     * @param boligIndretning
     */
    public void setBoligIndretning(String boligIndretning) {
        BoligIndretning = boligIndretning;
    }

    /**
     * Gets the Netvaerk
     * @return Netvaerk
     */
    public String getNetvaerk() {
        return Netvaerk;
    }

    /**
     * Sets the netvaerk
     * @param netvaerk
     */
    public void setNetvaerk(String netvaerk) {
        Netvaerk = netvaerk;
    }

    /**
     * ToString method
     * @return id, mestring, motivation, ressourcer, roller, vaner, uddannelseJOB, livshistorie, Helbredsoplysninger, Hjaelpemidler, BoligIndretning, Netvaerk
     */
    @Override
    public String toString() {
        return "GeneralInfo{" +
                "id=" + id +
                ", mestring='" + mestring + '\'' +
                ", motivation='" + motivation + '\'' +
                ", ressourcer='" + ressourcer + '\'' +
                ", roller='" + roller + '\'' +
                ", vaner='" + vaner + '\'' +
                ", uddannelseJOB='" + uddannelseJOB + '\'' +
                ", livshistorie='" + livshistorie + '\'' +
                ", Helbredsoplysninger='" + Helbredsoplysninger + '\'' +
                ", Hjælpemidler='" + Hjaelpemidler + '\'' +
                ", BoligIndretning='" + BoligIndretning + '\'' +
                ", Netværk='" + Netvaerk + '\'' +
                '}';
    }
}
