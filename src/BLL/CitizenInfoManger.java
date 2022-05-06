package BLL;

import BE.Citizen;
import BE.Student;
import DAL.CitizenInfoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class CitizenInfoManger {
    private CitizenInfoDAO citizenInfoDAO;


    public CitizenInfoManger() throws IOException {
        citizenInfoDAO = new CitizenInfoDAO();
    }

    public ObservableList<Citizen> getAllCitizens() {
        ObservableList<Citizen> citizensObs = FXCollections.observableArrayList();

        try {
            citizensObs.addAll(citizenInfoDAO.getAllCitizens());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citizensObs;
    }
}
