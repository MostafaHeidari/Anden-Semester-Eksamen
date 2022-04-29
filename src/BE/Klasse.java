package BE;

public class Klasse {
    public int klasseId;
    public String klasseNavn;

    public Klasse(int klasseId, String klasseNavn) {
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
