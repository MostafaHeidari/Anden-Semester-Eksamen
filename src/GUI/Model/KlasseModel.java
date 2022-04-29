package GUI.Model;

import BE.Klasse;
import BE.Student;
import BLL.KlasseManger;
import DAL.KlasseDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.SQLException;

public class KlasseModel {
    KlasseDAO klasseDAO = new KlasseDAO();

    private ObservableList<Klasse> klasseList = FXCollections.observableArrayList();

    private KlasseManger klasseManger;

    public KlasseModel() throws IOException {
        klasseManger = new KlasseManger();
    }

    public void uploadKlasseInfo(String klasseNavn) throws SQLException {
        klasseList.add(klasseManger.uploadKlasseInfo(klasseNavn));
    }
}
