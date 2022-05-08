package BE;

public class FunctionalAbility {
    public String condition;
    public String futureCondition;

    /**
     * @param caseID
     * @param condition
     * @param futureCondition
     * Constructor with FunctionalAbility, caseID,  condition, futureCondition
     */
    public FunctionalAbility(int caseID, String condition, String futureCondition) {
        this.condition = condition;
        this.futureCondition = futureCondition;
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
}
