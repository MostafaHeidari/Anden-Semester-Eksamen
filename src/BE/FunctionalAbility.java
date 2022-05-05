package BE;

public class FunctionalAbility {
    public String tilstand;
    public String fremtidigeTilstand;

    public FunctionalAbility(int caseID, String tilstand, String fremtidigeTilstand) {
        this.tilstand = tilstand;
        this.fremtidigeTilstand = fremtidigeTilstand;
    }

    public String getTilstand() {
        return tilstand;
    }

    public String getFremtidigeTilstand() {
        return fremtidigeTilstand;
    }

    public void setTilstand(String tilstand) {
        this.tilstand = tilstand;
    }

    public void setFremtidigeTilstand(String fremtidigeTilstand) {
        this.fremtidigeTilstand = fremtidigeTilstand;
    }
}
