package BLL;

import BE.Klasse;
import DAL.KlasseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class KlasseManger {
    KlasseDAO klasseDAO = new KlasseDAO();

    public KlasseManger() throws IOException {
    }

    public Klasse uploadKlasseInfo(String klasseNavn) throws SQLException {
        return (klasseDAO.uploadKlasseInfo(klasseNavn));
    }

    public ObservableList<Klasse> getAllKlasser() {
        ObservableList<Klasse> klassesObs = FXCollections.observableArrayList();


        try {
            klassesObs.addAll(klasseDAO.getAllKlasser());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return klassesObs;
    }
}
