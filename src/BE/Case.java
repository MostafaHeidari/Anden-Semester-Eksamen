package BE;

public class Case {
    public int caseId;
    public String caseName;
    public String caseInformation;

    public Case(int caseId, String caseName, String caseInformation) {
        this.caseId = caseId;
        this.caseName = caseName;
        this.caseInformation = caseInformation;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseInformation() {
        return caseInformation;
    }

    public void setCaseInformation(String caseInformation) {
        this.caseInformation = caseInformation;
    }
}
