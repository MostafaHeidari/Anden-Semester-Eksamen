package BE;

public class FunctionalAbility {
    private String condition;
    private String futureCondition;
    private String professionalNote;
    private String performance;
    private String performanceMeaning;
    private String citizenNote;
    private int caseID;
    private int catID;

    /**
     * @param caseID
     * @param condition
     * @param futureCondition
     */
    public FunctionalAbility(int caseID, String condition, String futureCondition, String professionalNote, String performance, String performanceMeaning, String citizenNote, int catID) {
        this.condition = condition;
        this.futureCondition = futureCondition;
        this.professionalNote = professionalNote;
        this.performance = performance;
        this.performanceMeaning = performanceMeaning;
        this.citizenNote = citizenNote;
        this.caseID = caseID;
        this.catID = catID;
    }

    /**
     * Getters
     * @return condition, futureCondition, professionalNote, performance, performanceMeaning and citizenNote
     */
    public String getcondition() {
        return condition;
    }

    public String getfutureCondition() {
        return futureCondition;
    }

    public String getProfessionalNote() {
        return professionalNote;
    }

    public String getPerformance() {
        return performance;
    }

    public String getPerformanceMeaning() {
        return performanceMeaning;
    }

    public String getCitizenNote() {
        return citizenNote;
    }

    public int getCaseID() { return caseID; }

    public int getCatID() { return catID; }

    /**
     * Setters
     * @return condition, futureCondition, professionalNote, performance, performanceMeaning and citizenNote
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setFutureCondition(String futureCondition) {
        this.futureCondition = futureCondition;
    }

    public void setProfessionalNote(String professionalNote) {
        this.professionalNote = professionalNote;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public void setPerformanceMeaning(String performanceMeaning) {
        this.performanceMeaning = performanceMeaning;
    }

    public void setCitizenNote(String citizenNote) {
        this.citizenNote = citizenNote;
    }

    public void setCaseID(int caseID) { this.caseID = caseID; }

    public void setCatID(int catID) { this.catID = catID; }
}
