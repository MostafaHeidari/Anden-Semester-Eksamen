package BE;

public class FunctionalAbility {
    public String tilstand;
    public String fremtidigeTilstand;

    /**
     * @param caseID
     * @param tilstand
     * @param fremtidigeTilstand
     * Constructor with FunctionalAbility, caseID,  tilstand, fremtidigeTilstand
     */
    public FunctionalAbility(int caseID, String tilstand, String fremtidigeTilstand) {
        this.tilstand = tilstand;
        this.fremtidigeTilstand = fremtidigeTilstand;
    }

    /**
     * Gets the tilstand
     * @return tilstand
     */
    public String getTilstand() {
        return tilstand;
    }

    /**
     * Gets the fremtidigeTilstand
     * @return fremtidigeTilstand
     */
    public String getFremtidigeTilstand() {
        return fremtidigeTilstand;
    }

    /**
     * Sets the tilstand
     * @return tilstand
     */
    public void setTilstand(String tilstand) {
        this.tilstand = tilstand;
    }

    /**
     * Sets the fremtidigeTilstand
     * @return fremtidigeTilstand
     */
    public void setFremtidigeTilstand(String fremtidigeTilstand) {
        this.fremtidigeTilstand = fremtidigeTilstand;
    }
}
