package BE;

public class FunctionalAbility {
    private String condition;
    private String futureCondition;
    private int caseID;

    /**
     * @param caseID
     * @param condition
     * @param futureCondition
     */
    public FunctionalAbility(int caseID, String condition, String futureCondition) {
        this.condition = condition;
        this.futureCondition = futureCondition;
        this.caseID = caseID;
    }

    /**
     * Gets the condition
     * @return condition
     */
    public String getcondition() {
        return condition;
    }

    /**
     * Gets the futureCondition
     * @return futureCondition
     */
    public String getfutureCondition() {
        return futureCondition;
    }

    /**
     * Sets the condition
     * @return condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Sets the futureCondition
     * @return futureCondition
     */
    public void setFutureCondition(String futureCondition) {
        this.futureCondition = futureCondition;
    }

    /**
     * Sets the borgerTilstand
     * @return borgerTilstand
     */

    public int getCaseID() { return caseID; }

    public void setCaseID(int caseID) { this.caseID = caseID; }
}
