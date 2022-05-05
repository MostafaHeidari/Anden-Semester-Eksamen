package BE;

public class Case {
    public int caseId;
    public String caseName;
    public String caseInformation;

    /**
     * @param caseId
     * @param caseName
     * @param caseInformation
     * Constructor with Case, caseId,  caseName, caseInformation
     */
    public Case(int caseId, String caseName, String caseInformation) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.caseInformation = caseInformation;
    }

    /**
     * Gets the caseId
     * @return caseId
     */
    public int getCaseId() {
        return caseId;
    }

    /**
     * Sets the caseId
     * @param caseId
     */
    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    /**
     * Gets the caseName
     * @return caseName
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * Sets the caseName
     * @param caseName
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
     * Gets the caseInformation
     * @return caseInformation
     */
    public String getCaseInformation() {
        return caseInformation;
    }

    /**
     * Sets the caseInformation
     * @return caseInformation
     */
    public void setCaseInformation(String caseInformation) {
        this.caseInformation = caseInformation;
    }
}
