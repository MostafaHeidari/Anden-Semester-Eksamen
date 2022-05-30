package BLL;

import BE.GeneralInformation;
import DAL.CaseDAO;
import DAL.GeneralInformationDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;

public class GeneralInformationManager {

    GeneralInformationDAO generalInformationDAO;

    public GeneralInformationManager() throws IOException {
        generalInformationDAO = new GeneralInformationDAO();
    }

    public ObservableList<GeneralInformation> getAllGeneralInformation(int citizenId) {
        ObservableList<GeneralInformation> GeneralInformations = FXCollections.observableArrayList();

        try {
            GeneralInformations.addAll(generalInformationDAO.getAllGeneralInformation(citizenId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return GeneralInformations;
    }
}
