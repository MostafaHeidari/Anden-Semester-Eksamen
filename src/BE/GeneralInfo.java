package BE;

public class GeneralInfo {
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

    // the Constructor of GenralInfo class
    public GeneralInfo(int id, String mestring, String motivation, String ressourcer, String roller, String vaner, String uddannelseJOB, String livshistorie, String helbredsoplysninger, String hjaelpemidler, String boligIndretning, String netvaerk) {
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

    public String getRessourcer() {
        return ressourcer;
    }

    public void setRessourcer(String ressourcer) {
        this.ressourcer = ressourcer;
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

    public String getUddannelseJOB() {
        return uddannelseJOB;
    }

    public void setUddannelseJOB(String uddannelseJOB) {
        this.uddannelseJOB = uddannelseJOB;
    }

    public String getLivshistorie() {
        return livshistorie;
    }

    public void setLivshistorie(String livshistorie) {
        this.livshistorie = livshistorie;
    }

    public String getHelbredsoplysninger() {
        return Helbredsoplysninger;
    }

    public void setHelbredsoplysninger(String helbredsoplysninger) {
        Helbredsoplysninger = helbredsoplysninger;
    }

    public String getHjaelpemidler() {
        return Hjaelpemidler;
    }

    public void setHjaelpemidler(String hjaelpemidler) {
        Hjaelpemidler = hjaelpemidler;
    }

    public String getBoligIndretning() {
        return BoligIndretning;
    }

    public void setBoligIndretning(String boligIndretning) {
        BoligIndretning = boligIndretning;
    }

    public String getNetvaerk() {
        return Netvaerk;
    }

    public void setNetvaerk(String netvaerk) {
        Netvaerk = netvaerk;
    }


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
