package BE;

public class Class {
    public int klasseId;
    public String klasseNavn;

    public Class(int klasseId, String klasseNavn) {
        this.klasseId = klasseId;
        this.klasseNavn = klasseNavn;
    }

    public int getKlasseId() {
        return klasseId;
    }

    public void setKlasseId(int klasseId) {
        this.klasseId = klasseId;
    }

    public String getKlasseNavn() {
        return klasseNavn;
    }

    public void setKlasseNavn(String klasseNavn) {
        this.klasseNavn = klasseNavn;
    }
}
