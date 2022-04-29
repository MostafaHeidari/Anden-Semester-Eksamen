package BLL;

import BE.Klasse;
import DAL.KlasseDAO;

import java.io.IOException;
import java.sql.SQLException;

public class KlasseManger {
    KlasseDAO klasseDAO = new KlasseDAO();

    public KlasseManger() throws IOException {
    }

    public Klasse uploadKlasseInfo(String klasseNavn) throws SQLException {
        return (klasseDAO.uploadKlasseInfo(klasseNavn));
    }
}
